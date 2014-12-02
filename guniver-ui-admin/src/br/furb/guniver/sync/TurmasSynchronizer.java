package br.furb.guniver.sync;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Turma;

public class TurmasSynchronizer extends EntitiesSynchronizer<Turma> {

	public TurmasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Turma entityAccessor) {
		entityAccessor.setAno(2012);
		entityAccessor.setSemestre(1);
	}

	@Override
	protected Collection<Turma> doDownloadAll() {
		return Arrays.asList(new Turma(132, null, 2012, 1), new Turma(3452, null, 2012, 2));
	}

	@Override
	protected void doUpload(Turma entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Turma> entities) {
		// TODO Auto-generated method stub

	}

}
