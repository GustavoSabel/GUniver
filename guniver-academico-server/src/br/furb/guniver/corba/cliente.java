package br.furb.guniver.corba;

import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import br.furb.guniver.modelo.academico.IAcademico;
import br.furb.guniver.modelo.academico.IAcademicoHelper;
import br.furb.guniver.modelo.academico.Prova;

public class cliente {

    public static void main(String args[]) {
	try {
	    ORB orb = ORB.init(args, null);

	    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	    NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

	    IAcademico academico = IAcademicoHelper.narrow(namecontextRef.resolve_str("IAcademico"));

	    StringHolder mensagemErro = new StringHolder();

	    if (!academico.cadastrarMatricula(1, 1, mensagemErro)) {
		throw new Exception(mensagemErro.value);
	    }

	    if (!academico.cadastrarMatricula(1, 2, mensagemErro)) {
		throw new Exception(mensagemErro.value);
	    }
	   
	    Prova[] notas = academico.getProvasAluno(1, 1);
	    System.out.println("Notas do(a) aluno(a) " + 1);
	    for (int i = 0; i < notas.length; i++) {
		System.out.println(" - " + notas[i].nota);
	    }

	    notas = academico.getProvas();
	    System.out.println("Todas as provas");
	    for (int i = 0; i < notas.length; i++) {
		System.out.println(" - " + notas[i].nota);
	    }
	    
	    /*Matricula[] matriculas = academico.getMatriculasSemestre(aluno.codigo, (short) 2014, (short) 1);
	    System.out.println("O Aluno" + aluno.nome
	        + " está matriculado nas seguintes disciplinas para o semestre 2014/1");
	    for (int i = 0; i < matriculas.length; i++) {
	    System.out.println(" - " + matriculas[i].turma.disciplina.nome);
	    }*/

	} catch (Exception e) {
	    System.out.println("ERROR : " + e);
	    e.printStackTrace(System.out);
	}
    }

    @SuppressWarnings("unused")
    private static void alert(String msg) {
	System.out.println(msg);
    }
}
