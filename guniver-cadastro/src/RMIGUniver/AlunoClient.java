package RMIGUniver;

import java.rmi.Naming;
import java.util.List;

public class AlunoClient {
	public static void main(String[] args) {
		try {
			AlunoRemote obj = (AlunoRemote) Naming.lookup("//" + args[0]
					+ "/AlunoRemote");

			Aluno alunoTeste = new Aluno(20, "Teste");
			obj.CadastrarAluno(alunoTeste);
			alunoTeste = new Aluno(40, "Teste 2");
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

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
}
