package br.furb.guniver.sync;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.Conversor;
import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAlunoService;
import br.furb.guniver.central_do_aluno.stubs.Disciplina;
import br.furb.guniver.rmi.DisciplinaRemote;

public class DisciplinasSynchronizer extends EntitiesSynchronizer<Disciplina> {

	private CentralAluno centralAluno;
	private DisciplinaRemote disciplinaRemote;

	public DisciplinasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
		URL url;
		try {
			url = new URL("http://" + moduleUrl + ":8080/centralAluno");
			centralAluno = new CentralAlunoService(url).getCentralAlunoPort();
		} catch (Exception ex) {
			System.out.println("Erro ao conectar com " + moduleUrl);
			System.out.println(ex.getMessage());
		}

	}

	@Override
	protected void doDownload(Disciplina entityAccessor) {
		Disciplina disciplina = centralAluno.getDisciplina(entityAccessor
				.getCodigo());
	}

	@Override
	protected Collection<Disciplina> doDownloadAll() {
		List<Disciplina> disc = centralAluno.getDisciplinas();
		return disc;
	}

	@Override
	protected void doUpload(Disciplina entity) {
		try {
			disciplinaRemote.cadastrarDisciplina(Conversor.cast(entity));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void doUploadAll(Collection<Disciplina> entities) {
		try {
			for (Disciplina disciplina : entities) {
				disciplinaRemote
						.cadastrarDisciplina(Conversor.cast(disciplina));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	protected Collection<Disciplina> doDownloadAllByAluno(Aluno aluno) {
		// TODO Auto-generated method stub

		return Collections.emptyList();
	}

	public Future<?> downloadAllByAluno(Aluno aluno) {
		SynchronizerTask<Aluno> downloadAllTask = new SynchronizerTask<Aluno>(
				aluno) {
			@Override
			void doTask(Aluno parameter) {
				fireDownloadAllComplete(doDownloadAllByAluno(parameter));
			}
		};

		return submit(downloadAllTask);
	}

}
