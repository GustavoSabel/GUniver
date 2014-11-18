package CorbaGUniver.Model;

import academico.Aluno;
import academico.Disciplina;
import academico.Turma;

public class Prova {
	private float nota;
	private Aluno aluno;
	private Turma turma;

	public Prova(float nota, Aluno aluno, Turma turma) {
		super();
		this.nota = nota;
		this.aluno = aluno;
		this.turma = turma;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
