package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Turma;

public class TurmasSynchronizer extends EntitiesSynchronizer<Turma> {

	public TurmasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Turma entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDownloadAll() {
		// TODO Auto-generated method stub

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
