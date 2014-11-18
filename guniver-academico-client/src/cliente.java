import academico.Aluno;
import academico.Disciplina;
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

			float[] notas = academico.getNotasAlunoTurma(aluno, turma);
			System.out.println("Notas:");
			for (int i = 0; i < notas.length; i++) {
				System.out.println(notas[i]);
			}
			System.out.println();

			academico.getNotasTurma(turma);
			academico.getOcorrencias(aluno);
			academico.getMatricula(aluno, disc);
			academico.getMatriculas(aluno);
			academico.matricular(aluno);

		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}
}
