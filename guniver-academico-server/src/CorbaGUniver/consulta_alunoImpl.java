package CorbaGUniver;

import java.util.List;

import CorbaGUniver.Model.Prova;
import academico.Aluno;
import academico.Disciplina;
import academico.IAcademicoPOA;
import academico.Matricula;
import academico.Ocorrencia;
import academico.SituacaoMatricula;
import academico.Turma;

class consulta_alunoImpl extends IAcademicoPOA {

	public float[] getNotasAlunoTurma(Aluno aluno, Turma turma) {
		List<Prova> provas = BancoDados.getInstance().getProvasAluno(aluno, turma);
		float[] notas = new float[provas.size()];
		for (int i = 0; i < provas.size(); i++) {
			notas[i] = provas.get(i).getNota();
		}
		return notas;
	}

	public float[][] getNotasTurma(Turma turma) {
		System.out.println("getNotasTurma");
		return new float[][] { new float[] { 7, 5, 3, 4 },
				new float[] { 10, 5, 7 } };
	}

	public Ocorrencia[] getOcorrencias(Aluno aluno) {
		System.out.println("getOcorrencias");
		return new Ocorrencia[] { new Ocorrencia("Sei lá :D") };
	}

	public Matricula getMatricula(Aluno aluno, Disciplina disciplina) {
		System.out.println("getMatricula");
		return new Matricula(50, new Aluno(1, "a"), new Disciplina(10,
				"Sistemas Distribuidos"));
	}

	public Matricula[] getMatriculas(Aluno aluno) {
		System.out.println("getMatriculas");
		return new Matricula[] { new Matricula(50, new Aluno(1, "a"), new Disciplina(
				10, "Sistemas Distribuidos")) };
	}

	public SituacaoMatricula matricular(Aluno aluno) {
		System.out.println("matricular");
		return SituacaoMatricula.pago;
	}

}