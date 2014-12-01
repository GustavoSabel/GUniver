package academico;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Academico {

    private String endereco;
    public Academico(String endereco) {
	this.endereco = endereco;
    }
    
    public IAcademico getAcademico() throws Exception {
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

    public Matricula[] buscarMatriculas(rmi_guniver.Aluno aluno) throws Exception {
	return getAcademico().getMatriculasAluno(aluno.getCodigo());
    }
    
    public Matricula[] buscarMatriculas(rmi_guniver.Turma turma) throws Exception {
	return getAcademico().getMatriculasTurma(turma.getCodigo());
    }

}
