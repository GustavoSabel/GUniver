package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import modulo.cadastro.Disciplina;

public class DisciplinasSynchronizer extends EntitiesSynchronizer<Disciplina> {

	public DisciplinasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Disciplina entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDownloadAll() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUpload(Disciplina entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Disciplina> entities) {
		// TODO Auto-generated method stub

	}

}
