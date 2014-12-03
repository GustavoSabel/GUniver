package br.furb.guniver.sync;

import java.util.Arrays;
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
		Disciplina d1 = new Disciplina();
		d1.setCodigo(123);
		d1.setNome("Primeira disciplina");
		Disciplina d2 = new Disciplina();
		d2.setCodigo(54322);
		d2.setNome("Disciplina Dois");
		Disciplina d3 = new Disciplina();
		d3.setCodigo(6785451);
		d3.setNome("Terceira");

		return Arrays.asList(d1, d2, d3);
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
