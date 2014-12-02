package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Aluno;

public class AlunosSynchronizer extends EntitiesSynchronizer<Aluno> {

	public AlunosSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Aluno entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Collection<Aluno> doDownloadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doUpload(Aluno entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUploadAll(Collection<Aluno> entities) {
		// TODO Auto-generated method stub

	}

}
