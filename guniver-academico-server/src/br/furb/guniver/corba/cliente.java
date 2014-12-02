package br.furb.guniver.corba;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import br.furb.guniver.modelo.academico.Aluno;
import br.furb.guniver.modelo.academico.Disciplina;
import br.furb.guniver.modelo.academico.IAcademico;
import br.furb.guniver.modelo.academico.IAcademicoHelper;
import br.furb.guniver.modelo.academico.Prova;
import br.furb.guniver.modelo.academico.Turma;

public class cliente {

    public static void main(String args[]) {
	try {
	    ORB orb = ORB.init(args, null);

	    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	    NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

	    IAcademico academico = IAcademicoHelper.narrow(namecontextRef.resolve_str("IAcademico"));

	    Aluno aluno = new Aluno(45, "Vivian");
	    Disciplina discSD = new Disciplina(25, "Sistemas Distribuidos");
	    Disciplina discPD = new Disciplina(75, "Processo de Software I");
	    Turma turmaSD = new Turma(3, (short) 2014, (short) 2, discSD);
	    Turma turmaPD = new Turma(55, (short) 2014, (short) 1, discPD);

	    StringHolder mensagemErro = new StringHolder();
	    /*
	    			if (!academico.cadastrarDisciplina(discSD, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			if (!academico.cadastrarDisciplina(discPD, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			if (!academico.cadastrarTurma(turmaSD, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			if (!academico.cadastrarTurma(turmaPD, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}
	    */
	    if (!academico.matricular(aluno, turmaSD, mensagemErro)) {
		throw new Exception(mensagemErro.value);
	    }

	    if (!academico.matricular(aluno, turmaPD, mensagemErro)) {
		throw new Exception(mensagemErro.value);
	    }
	    /*			
	    			Prova prova = new Prova("A", aluno, turmaSD, 8.0f);
	    			if (!academico.cadastrarProva(prova, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			prova = new Prova("B", aluno, turmaSD, 7.5f);
	    			if (!academico.cadastrarProva(prova, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			prova = new Prova("C", aluno, turmaSD, 9.1f);
	    			if (!academico.cadastrarProva(prova, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			prova = new Prova("A", aluno, turmaPD, 5.25f);
	    			if (!academico.cadastrarProva(prova, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}

	    			prova = new Prova("B", aluno, turmaPD, 2.75f);
	    			if (!academico.cadastrarProva(prova, mensagemErro)) {
	    				throw new Exception(mensagemErro.value);
	    			}
	    */
	    Prova[] notas = academico.getNotasAluno(aluno.codigo, turmaPD.codigo);
	    System.out.println("Notas do(a) aluno(a) " + aluno.nome);
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
