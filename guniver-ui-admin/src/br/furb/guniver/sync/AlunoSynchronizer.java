package br.furb.guniver.sync;

import java.util.Collection;

import modulo.cadastro.Aluno;

public class AlunoSynchronizer extends EntitiesSynchronizer<Aluno> {

	public AlunoSynchronizer(String moduleUrl) {
		super(moduleUrl);
	}

	@Override
	protected void doDownload(Aluno entityAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDownloadAll() {
		// TODO Auto-generated method stub

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
