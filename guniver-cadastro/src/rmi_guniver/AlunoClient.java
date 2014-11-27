package rmi_guniver;

import java.rmi.Naming;
import java.util.List;

public class AlunoClient {
	public static void main(String[] args) {
		try {
			AlunoRemote obj = (AlunoRemote) Naming.lookup("//" + args[0]
					+ "/AlunoRemote");
			CursoRemote obj2 = (CursoRemote) Naming.lookup("//"+ args[0]
					+ "/CursoRemote");
			DisciplinaRemote obj3 = (DisciplinaRemote) Naming.lookup("//"+ args[0]
					+ "/DisciplinaRemote");
			TurmaRemote obj4 = (TurmaRemote) Naming.lookup("//"+ args[0]
					+ "/TurmaRemote");

			//TESTANDO ALUNO
			Aluno alunoTeste = new Aluno(20, "Bruno");
			obj.CadastrarAluno(alunoTeste);
			alunoTeste = new Aluno(40, "Vivian");
			obj.CadastrarAluno(alunoTeste);

			System.out.println("obj.BuscarAluno(20)");
			Aluno al = obj.BuscarAluno(20);
			System.out.println("Aluno: " + al.getCodigo() + " - "
					+ al.getNome());

			System.out.println("obj.BuscarAlunos");
			List<Aluno> alunos = obj.BuscarAlunos();
			for (Aluno aluno : alunos) {
				System.out.println("Aluno: " + aluno.getCodigo() + " - "
						+ aluno.getNome());
			}
			//FIM DE TESTE DE ALUNO
			
			//TESTANDO CURSO
			
			System.out.println("Teste Curso");
			Curso curso = new Curso(1, "Ciencia da Computacao");
			obj2.addCurso(curso);
			curso = new Curso(2,"Sistemas de Informacao");
			obj2.addCurso(curso);
			curso = obj2.getCurso(1);
			System.out.println("Curso = " + curso.getDescricao());
			for(Curso cur : obj2.getCursos()){
				System.out.println("Curso = " + cur.getCodigo() + " - " +  cur.getDescricao());
			}
			//FIM DE TESTE DE CURSO
			
			//TESTANDO DISCIPLINA
			Disciplina disc = new Disciplina(10, "Sistemas Distribuidos", curso);
			obj3.addDisciplina(disc);
			disc = new Disciplina(20, "Banco de Dados", curso);
			obj3.addDisciplina(disc);
			for(Disciplina d : obj3.getDisciplinas(1)){
				System.out.println("Disciplina = " + d.getCodigo() + " - " +  d.getNome());
			}
			//FIM DE TESTE DE DISCIPLINA
			
			//TESTANDO TURMA
			Turma turma = new Turma(1, disc, 2014, 2);
			//obj4.addTurma(turma);
			//obj4.addAluno(1, al);
			//obj4.addAluno(1, alunoTeste);
			for(Aluno aluno : obj4.BuscarAlunosTurma(1)){
				System.out.println("Aluno: " + aluno.getCodigo() + " - " + aluno.getNome());
			}
			//FIM DE TESTE DE TURMA

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
}
