

import java.util.ArrayList;
import java.util.List;

import academico.Aluno;
import academico.Disciplina;
import academico.Matricula;
import academico.Prova;
import academico.Turma;

public class BancoDados {

	//public List<Aluno> alunos; // Os alunos ficam no módulo cadastro
	public List<Prova> provas;
	public List<Disciplina> disciplinas;
	public List<Matricula> matriculas;
	public List<Turma> turmas;

	private static BancoDados instancia;

	private BancoDados() {
		disciplinas = new ArrayList<>();
		provas = new ArrayList<>();
		matriculas = new ArrayList<>();
		turmas = new ArrayList<>();
		//CargaInicial();
	}

	public static BancoDados getInstance() {
		if (instancia == null)
			instancia = new BancoDados();
		return instancia;
	}
	
	private void CargaInicial()
	{
		Disciplina disciplinaSD = new Disciplina(1, "Sistemas Distribuidos");
		Disciplina disciplinaPS = new Disciplina(2, "Processo de Software");
		Aluno alunoGustavo = new Aluno(1, "Gustavo Sabel");
		Turma turmaA = new Turma(1, "A", (short) 2014, (short) 1, disciplinaSD);
		Turma turmaB = new Turma(2, "A", (short) 2014, (short) 1, disciplinaPS);
		matriculas.add(new Matricula(alunoGustavo, turmaA));
		matriculas.add(new Matricula(alunoGustavo, turmaB));
		disciplinas.add(disciplinaSD);
		disciplinas.add(disciplinaPS);
		//alunos.add(alunoGustavo);
		turmas.add(turmaA);
		provas.add(new Prova("Prova A", alunoGustavo, turmaA, 7.5f));
		provas.add(new Prova("Prova B", alunoGustavo, turmaA, 9.25f));
		provas.add(new Prova("Prova C", alunoGustavo, turmaA, 5.0f));
		provas.add(new Prova("Prova A", alunoGustavo, turmaB, 6.0f));
		provas.add(new Prova("Prova B", alunoGustavo, turmaB, 8.0f));
	}
}
