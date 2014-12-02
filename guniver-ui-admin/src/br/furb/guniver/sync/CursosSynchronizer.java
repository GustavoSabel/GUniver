package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Curso;

public class CursosSynchronizer extends EntitiesSynchronizer<Curso> {

	public CursosSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doDownload(Curso entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDownloadAll() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUpload(Curso entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Curso> entities) {
		// TODO Auto-generated method stub

	}

}
