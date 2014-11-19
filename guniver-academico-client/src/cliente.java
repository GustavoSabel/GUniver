import academico.Aluno;
import academico.Disciplina;
import academico.DisciplinaHolder;
import academico.IAcademico;
import academico.IAcademicoHelper;
import academico.Turma;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class cliente {

	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null);

			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			NamingContextExt namecontextRef = NamingContextExtHelper
					.narrow(objRef);

			IAcademico academico = IAcademicoHelper.narrow(namecontextRef
					.resolve_str("IAcademico"));

			Aluno aluno = new Aluno(1, "Gustavo");
			Disciplina disc = new Disciplina(1, "Sistemas Distribuidos");
			Turma turma = new Turma(1, "A", (short) 2014, (short) 1, disc);

			float[] notas = academico.getNotasAluno(aluno, turma);
			System.out.println("Notas:");
			for (int i = 0; i < notas.length; i++) {
				System.out.println(notas[i]);
			}
			System.out.println();

			System.out.println("Cadastrar aluno");
			StringHolder saida = new StringHolder();
			if (!academico.matricular(aluno, turma, saida)) {
				System.out.println("Aluno não cadastrado.");
				System.out.println(saida.value);
			} else {
				System.out.println("Aluno cadastrado com sucesso.");
			}

			System.out.println();
			System.out.println("Consultar disciplina");
			DisciplinaHolder dis = new DisciplinaHolder();
			if (academico.getDisciplina(10, dis)) {
				System.out.println("Disciplina não encontrada");
			} else {
				System.out.println("Disciplina encontrada: " + dis.value.nome);
			}

			academico.getOcorrencias(aluno);
			academico.getMatricula(aluno, disc);
			academico.getMatriculas(aluno);

		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}
}
