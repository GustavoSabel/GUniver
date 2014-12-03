package br.furb.guniver.sync;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAlunoService;

public class AlunosSynchronizer extends EntitiesSynchronizer<Aluno> {

    CentralAluno centralAluno;

    public AlunosSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
	super(moduleUrl, executor);
	try {
	    URL url = new URL("http://" + moduleUrl + ":8080/centralAluno");
	    centralAluno = new CentralAlunoService(url).getCentralAlunoPort();
	} catch (Exception ex) {
	    System.out.println("Erro ao conectar com " + moduleUrl);
	    System.out.println(ex.getMessage());
	}
    }

    @Override
    protected void doDownload(Aluno entityAccessor) {
	entityAccessor.setNome("Nome do aluno " + entityAccessor.getCodigo());
    }

    @Override
    protected Collection<Aluno> doDownloadAll() {
	List<Aluno> alunos = centralAluno.getAlunos();
	return alunos;
    }

    @Override
    protected void doUpload(Aluno entity) {
    }

    @Override
    protected void doUploadAll(Collection<Aluno> entities) {
    }

}
