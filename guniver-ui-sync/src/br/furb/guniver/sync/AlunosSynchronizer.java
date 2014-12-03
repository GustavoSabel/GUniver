package br.furb.guniver.sync;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import br.furb.guniver.Conversor;
import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAlunoService;
import br.furb.guniver.rmi.AlunoRemote;

public class AlunosSynchronizer extends EntitiesSynchronizer<Aluno> {

    private CentralAluno centralAluno;
    private AlunoRemote alunoRemote;

    public AlunosSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
	super(moduleUrl, executor);
	try {
	    URL url = new URL("http://" + moduleUrl + ":8080/centralAluno");
	    alunoRemote = (AlunoRemote) Naming.lookup("//" + moduleUrl + "/AlunoRemote");

	    centralAluno = new CentralAlunoService(url).getCentralAlunoPort();
	} catch (MalformedURLException | RemoteException | NotBoundException ex) {
	    throw new RuntimeException("Erro ao conectar com " + moduleUrl, ex);
	}
    }

    @Override
    protected void doDownload(Aluno entityAccessor) {
	Aluno aluno = centralAluno.autenticaUsuario(entityAccessor.getNomeUsuario(), entityAccessor.getSenha());
	if (aluno == null) {
	    throw new AuthenticationException("Usuário ou senha incorretos!");
	}
	entityAccessor.setCodigo(aluno.getCodigo());
	entityAccessor.setNome(aluno.getNome());
	entityAccessor.setNomeUsuario(aluno.getNomeUsuario());
	entityAccessor.setSenha(aluno.getSenha());
    }

    @Override
    protected Collection<Aluno> doDownloadAll() {
	List<Aluno> alunos = centralAluno.getAlunos();
	return alunos;
    }

    @Override
    protected void doUpload(Aluno entity) {
	try {
	    alunoRemote.cadastrarAluno(Conversor.cast(entity));
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    @Override
    protected void doUploadAll(Collection<Aluno> entities) {
	try {
	    for (Aluno aluno : entities) {
		alunoRemote.cadastrarAluno(Conversor.cast(aluno));
	    }
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

}
