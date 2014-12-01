package br.furb.guniver.modulo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import br.furb.guniver.modelo.academico.Aluno;
import br.furb.guniver.modelo.academico.IAcademico;
import br.furb.guniver.modelo.academico.IAcademicoHelper;
import br.furb.guniver.modelo.academico.Prova;
import br.furb.guniver.modelo.academico.Turma;

public class Academico {

    private String endereco;

    public Academico(String endereco) {
	this.endereco = endereco;
    }

    private IAcademico getAcademico() throws Exception {
	try {
	    String[] args = new String[] { "-ORBInitialHost", this.endereco };
	    ORB orb = ORB.init(args, null);

	    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	    NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

	    IAcademico academico = IAcademicoHelper.narrow(namecontextRef.resolve_str("IAcademico"));
	    return academico;

	} catch (InvalidName | NotFound | org.omg.CORBA.ORBPackage.InvalidName | CannotProceed e) {
	    throw new Exception("Erro no módulo CADASTRO ao consultar o móduclo ACADEMICO", e);
	}
    }

    public Collection<Prova> getProvas(int codigoAluno, int codigoTurma) throws Exception {
	return Arrays.asList(getAcademico().getNotasAluno(codigoAluno, codigoTurma));
    }

    public Collection<br.furb.guniver.modelo.academico.Matricula> getMatriculasAluno(int codigoAluno) throws Exception {
	return Arrays.asList(getAcademico().getMatriculasAluno(codigoAluno));
    }

    public Collection<br.furb.guniver.modelo.academico.Matricula> getMatriculasTurma(int codigoTurma) throws Exception {
	return Arrays.asList(getAcademico().getMatriculasTurma(codigoTurma));
    }

    public Collection<br.furb.guniver.modelo.academico.Horario> getHorarios(int coditoTurma) throws Exception {
	return Arrays.asList(getAcademico().getHorarios(coditoTurma));
    }

}