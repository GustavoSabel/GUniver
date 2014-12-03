package br.furb.guniver.rmi;

import java.rmi.Naming;
import br.furb.guniver.modelo.*;

public class Client {

	public static void main(String[] args) {
		try {
			System.out.println("");
			System.out.println("Inicio de testes em ALUNO");
			TestarAluno(args[0]);
			System.out.println("");
			System.out.println("Inicio de testes em CURSO");
			TestarCurso(args[0]);
			System.out.println("");
			System.out.println("Inicio de testes em DISCIPLINA");
			TestarDisciplina(args[0]);
			System.out.println("");
			System.out.println("Inicio de testes em TURMA");
			TestarTurma(args[0]);
		} catch (Exception ex) {
			System.out.println("Exception: \r\n" + ex.getMessage());
		}
	}

	private static void TestarAluno(String endereco) throws Exception {
		AlunoRemote alunoRemote = (AlunoRemote) Naming.lookup("//" + endereco
				+ "/AlunoRemote");
		Aluno alunoTeste = new Aluno(1, "Bruno");
		System.out.println("Cadastrar aluno" + alunoTeste.getCodigo() + " - "
				+ alunoTeste.getNome());
		alunoRemote.cadastrarAluno(alunoTeste);
		alunoTeste = new Aluno(40, "Vivian");
		System.out.println("Cadastrar aluno" + alunoTeste.getCodigo() + " - "
				+ alunoTeste.getNome());
		alunoRemote.cadastrarAluno(alunoTeste);

		System.out.println("Buscar aluno 1");
		Aluno al = alunoRemote.getAluno(1);
		System.out.println("Aluno: " + al.getCodigo() + " - " + al.getNome());

		System.out.println("Consultar aluno");
		for (Aluno aluno : alunoRemote.getAlunos()) {
			System.out.println(" - Aluno: " + aluno.getCodigo() + " - "
					+ aluno.getNome());
		}
	}

	private static void TestarCurso(String endereco) throws Exception {
		CursoRemote cursoRemote = (CursoRemote) Naming.lookup("//" + endereco
				+ "/CursoRemote");

		System.out.println("Teste Curso");
		Curso curso = new Curso(1, "Ciencia da Computacao");
		cursoRemote.cadastrarCurso(curso);
		curso = new Curso(2, "Sistemas de Informacao");
		cursoRemote.cadastrarCurso(curso);
		curso = cursoRemote.buscarCurso(1);
		System.out.println("Curso = " + curso.getDescricao());

		System.out.println("Consultar cursos");
		for (Curso cur : cursoRemote.getCursos()) {
			System.out.println(" - Curso = " + cur.getCodigo() + " - "
					+ cur.getDescricao());
		}
	}

	private static void TestarDisciplina(String endereco) throws Exception {
		DisciplinaRemote disciplinaRemote = (DisciplinaRemote) Naming
				.lookup("//" + endereco + "/DisciplinaRemote");

		Curso curso = new Curso(1, "Ciencia da Computacao");
		Disciplina disc = new Disciplina(1, "Sistemas Distribuidos", curso);

		disciplinaRemote.cadastrarDisciplina(disc);
		disc = new Disciplina(20, "Banco de Dados", curso);
		disciplinaRemote.cadastrarDisciplina(disc);
		System.out.println("Consultar disciplinas");
		for (Disciplina d : disciplinaRemote.getDisciplinasCurso(1)) {
			System.out.println(" - Disciplina = " + d.getCodigo() + " - "
					+ d.getNome());
		}
	}

	private static void TestarTurma(String endereco) throws Exception {

		TurmaRemote turmaRemote = (TurmaRemote) Naming.lookup("//" + endereco
				+ "/TurmaRemote");

		Turma turmaNova = new Turma(1, new Disciplina(1, "", null), 2014, 2);
		turmaRemote.cadastrarTurma(turmaNova);
		BancoDados.getIntancia().getAlunos()
				.add(new Aluno(1, "Teseeeeeeeeeee"));
		System.out.println("Alunos da Turma 1:");
		for (Aluno aluno : turmaRemote.getAlunosTurma(1)) {
			System.out.println(" - Aluno: " + aluno.getCodigo() + " - "
					+ aluno.getNome());
		}

		System.out.println("Turmas do Aluno 1:");
		for (Turma turma : turmaRemote.getTurmas()) {
			System.out.println(" - Turma: " + turma.getCodigo()
					+ " - Semestre: " + turma.getAno() + "/"
					+ turma.getSemestre() + " - Disciplina"
					+ turma.getDisciplina().getNome());
		}
	}
}
