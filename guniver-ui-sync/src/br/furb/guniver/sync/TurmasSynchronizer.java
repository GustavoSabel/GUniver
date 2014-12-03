package br.furb.guniver.sync;

import java.net.URL;
import java.rmi.Naming;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import br.furb.guniver.Conversor;
import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAlunoService;
import br.furb.guniver.central_do_aluno.stubs.Turma;
import br.furb.guniver.rmi.TurmaRemote;

public class TurmasSynchronizer extends EntitiesSynchronizer<Turma> {

    private TurmaRemote turmaRemote;
    private CentralAluno centralAluno;

    public TurmasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
	super(moduleUrl, executor);
	try {
	    URL url = new URL("http://" + moduleUrl + ":8080/centralAluno");
	    turmaRemote = (TurmaRemote) Naming.lookup("//" + moduleUrl + "/TurmaRemote");

	    centralAluno = new CentralAlunoService(url).getCentralAlunoPort();
	} catch (Exception ex) {
	    throw new RuntimeException("Erro ao conectar com " + moduleUrl, ex);
	}
    }

    @Override
    protected void doDownload(Turma entityAccessor) {
	throw new UnsupportedOperationException("Método não implementado");
	//entityAccessor.setAno(2012);
	//entityAccessor.setSemestre(1);
    }

    @Override
    protected Collection<Turma> doDownloadAll() {
	try {
	    List<Turma> turmas = centralAluno.getTurmas();
	    return turmas;
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    @Override
    protected void doUpload(Turma entity) {
	try {
	    turmaRemote.cadastrarTurma(Conversor.cast(entity));
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    @Override
    protected void doUploadAll(Collection<Turma> entities) {
	for (Turma turma : entities) {
	    doUpload(turma);
	}
    }

    protected Collection<Turma> doDownloadAllByAluno(Aluno aluno) {
	try {
	    List<Turma> turmas = centralAluno.getTurmasAluno(aluno.getCodigo());
	    return turmas;
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public Future<?> downloadAllByAluno(Aluno aluno) {
	SynchronizerTask<Aluno> downloadAllTask = new SynchronizerTask<Aluno>(aluno) {

	    @Override
	    void doTask(Aluno parameter) {
		fireDownloadAllComplete(doDownloadAllByAluno(parameter));
	    }
	};

	return submit(downloadAllTask);
    }

}
