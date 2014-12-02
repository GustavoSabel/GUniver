package br.furb.guniver.sync;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Aluno;

public class AlunosSynchronizer extends EntitiesSynchronizer<Aluno> {

	public AlunosSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
	}

	@Override
	protected void doDownload(Aluno entityAccessor) {
		entityAccessor.setNome("Nome do aluno " + entityAccessor.getCodigo());
	}

	@Override
	protected Collection<Aluno> doDownloadAll() {
		return Arrays.asList(new Aluno(1, "joao123", "123456", "João"), // 
				new Aluno(5, "pedroso", "qsenha", "Pedro Silva"), // 
				new Aluno(234, "ramonin", "hoho2512", "Ramon Noel"));
	}

	@Override
	protected void doUpload(Aluno entity) {
	}

	@Override
	protected void doUploadAll(Collection<Aluno> entities) {
	}

}
