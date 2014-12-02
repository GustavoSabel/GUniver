package br.furb.guniver.sync;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Curso;

public class CursosSynchronizer extends EntitiesSynchronizer<Curso> {

	public CursosSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Curso entityAccessor) {
		entityAccessor.setDescricao("Nome de algum curso");
	}

	@Override
	protected Collection<Curso> doDownloadAll() {
		return Arrays.asList(new Curso(124, "Primeiro curso"),//
				new Curso(456, "Segundo curso"), //
				new Curso(02, "Terceiro curso"));
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
