package CorbaGUniver;

import java.util.ArrayList;
import java.util.List;

import academico.Aluno;
import academico.Curso;
import academico.Disciplina;
import academico.Matricula;
import academico.Ocorrencia;
import academico.Prova;
import academico.Turma;

public class BancoDados {

	public List<Aluno> alunos;
	public List<Prova> provas;
	public List<Disciplina> disciplinas;
	public List<Matricula> matriculas;
	public List<Ocorrencia> ocorrencias;
	public List<Turma> turmas;

	private static BancoDados instancia;

	private BancoDados() {
		disciplinas = new ArrayList<>();
		provas = new ArrayList<>();
		matriculas = new ArrayList<>();
		ocorrencias = new ArrayList<>();
		turmas = new ArrayList<>();
		alunos = new ArrayList<>();
		Disciplina disciplinaSD = new Disciplina(1, "Sistemas Distribuidos");
		Disciplina disciplinaPS = new Disciplina(2, "Processo de Software");
		Aluno alunoGustavo = new Aluno(1, "Gustavo Sabel");
		Turma turmaA = new Turma(1, "A", (short) 2014, (short) 1, disciplinaSD);
		Turma turmaB = new Turma(2, "A", (short) 2014, (short) 1, disciplinaPS);
		matriculas.add(new Matricula(alunoGustavo, turmaA));
		matriculas.add(new Matricula(alunoGustavo, turmaB));
		disciplinas.add(disciplinaSD);
		disciplinas.add(disciplinaPS);
		alunos.add(alunoGustavo);
		turmas.add(turmaA);
		provas.add(new Prova("Prova A", alunoGustavo, turmaA, 7.5f));
		provas.add(new Prova("Prova B", alunoGustavo, turmaA, 9.25f));
		provas.add(new Prova("Prova C", alunoGustavo, turmaA, 5.0f));
		provas.add(new Prova("Prova A", alunoGustavo, turmaB, 6.0f));
		provas.add(new Prova("Prova B", alunoGustavo, turmaB, 8.0f));
	}

	public static BancoDados getInstance() {
		if (instancia == null)
			instancia = new BancoDados();
		return instancia;
	}

	public List<Prova> getProvasAluno(Aluno aluno, Turma turma) {
		List<Prova> provasAluno = new ArrayList<>();
		System.out.println("1");
		for (Prova prova : provas) {
			System.out.println("2");
			if (prova.aluno.codigo == aluno.codigo) {
				System.out.println("3");
				if (prova.aluno.codigo == turma.codigo) {
					System.out.println("4");
					provasAluno.add(prova);
				}
			}
		}
		return provasAluno;
	}
}
