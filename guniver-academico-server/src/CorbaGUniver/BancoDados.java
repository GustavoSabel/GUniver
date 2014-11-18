package CorbaGUniver;

import java.util.ArrayList;
import java.util.List;

import CorbaGUniver.Model.Prova;
import academico.Aluno;
import academico.Disciplina;
import academico.Matricula;
import academico.Ocorrencia;
import academico.Turma;

public class BancoDados {

	private List<Aluno> alunos;
	private List<Prova> provas;
	private List<Disciplina> disciplinas;
	private List<Matricula> matriculas;
	private List<Ocorrencia> ocorrencias;
	private List<Turma> turmas;

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
		disciplinas.add(disciplinaSD);
		disciplinas.add(disciplinaPS);
		alunos.add(alunoGustavo);
		turmas.add(turmaA);
		provas.add(new Prova(7.5f, alunoGustavo, turmaA));
		provas.add(new Prova(9.25f, alunoGustavo, turmaA));
		provas.add(new Prova(5.0f, alunoGustavo, turmaA));
		provas.add(new Prova(6.0f, alunoGustavo, turmaB));
		provas.add(new Prova(8.0f, alunoGustavo, turmaB));
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
			if (prova.getAluno().codigo == aluno.codigo) {
				System.out.println("3");
				if (prova.getTurma().codigo == turma.codigo) {
					System.out.println("4");
					provasAluno.add(prova);
				}
			}
		}
		return provasAluno;
	}
}
