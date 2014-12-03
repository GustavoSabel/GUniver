package br.furb.guniver.sync;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.Disciplina;

public class DisciplinasSynchronizer extends EntitiesSynchronizer<Disciplina> {

	public DisciplinasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Disciplina entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Collection<Disciplina> doDownloadAll() {
		/*return Arrays.asList(new Disciplina(123, "Primeira disciplina", null), //
				new Disciplina(54322, "Disciplina Dois", null), //
				new Disciplina(6785451, "Terceira", null));*/
		return Collections.emptyList();
	}

	@Override
	protected void doUpload(Disciplina entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Disciplina> entities) {
		// TODO Auto-generated method stub

	}

	protected Collection<Disciplina> doDownloadAllByAluno(Aluno aluno) {
		// TODO Auto-generated method stub

		return Collections.emptyList();
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
