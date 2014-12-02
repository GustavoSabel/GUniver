package br.furb.guniver.sync;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Prova;
import br.furb.guniver.modelo.Turma;

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
		Aluno alunoUm = new Aluno(123, "alunoum", "senhaa", "Aluno Um");
		Aluno alunoDois = new Aluno(564, "degundoAluno", "otraSennha", "Segundo aluno");
		Turma turmaUm = new Turma(234, null, 0, 0);
		Turma turmaDois = new Turma(78987, null, 0, 0);
		return Arrays.asList(new Prova("Provinha Um", alunoUm, turmaUm, 8.7f),//
				new Prova("Provinha Dois", alunoUm, turmaUm, 5.9f), //
				new Prova("Avaliação", alunoDois, turmaDois, 5.9f));
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
