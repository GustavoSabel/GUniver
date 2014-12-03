package br.furb.guniver.sync;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.central_do_aluno.stubs.Horario;
import br.furb.guniver.central_do_aluno.stubs.Turma;

public class HorariosSynchronizer extends EntitiesSynchronizer<Horario> {

	public HorariosSynchronizer(String url, ThreadPoolExecutor executor) {
		super(url, executor);
	}

	@Override
	protected void doDownload(Horario entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Collection<Horario> doDownloadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doUpload(Horario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Horario> entities) {
		// TODO Auto-generated method stub

	}

	protected Collection<Horario> doDownloadAllByAluno(Turma turma) {
		// TODO
		return Collections.emptyList();
	}

	public Future<?> downloadAllByTurma(Turma turma) {
		SynchronizerTask<Turma> downloadAllTask = new SynchronizerTask<Turma>(turma) {
			@Override
			void doTask(Turma parameter) {
				fireDownloadAllComplete(doDownloadAllByAluno(parameter));
			}
		};

		return submit(downloadAllTask);
	}

}
