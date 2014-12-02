package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Prova;

public class ProvasSynchronizer extends EntitiesSynchronizer<Prova> {

	public ProvasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Prova entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Collection<Prova> doDownloadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doUpload(Prova entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Prova> entities) {
		// TODO Auto-generated method stub

	}

}
