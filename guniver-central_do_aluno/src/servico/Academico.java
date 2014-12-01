package servico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import servico.academico.Aluno;
import servico.academico.IAcademico;
import servico.academico.IAcademicoHelper;
import servico.academico.Prova;

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

    public Collection<Prova> buscarProvas(int codigoAluno, int codigoTurma) throws Exception {
	List<Prova> provas = new ArrayList<Prova>();

	for (Prova prova : getAcademico().getNotasAluno(codigoAluno, codigoTurma)) {
	    provas.add(prova);
	}
	return provas;
    }

    /* public Matricula[] buscarMatriculas(rmi_guniver.Aluno aluno) throws Exception {
    servico.academico.Aluno alunoAc = new Aluno(aluno.getCodigo(), aluno.getNome());
    return getAcademico().getMatriculasAluno(alunoAc);
     }
     
     public Matricula[] buscarMatriculas(rmi_guniver.Turma turma) throws Exception {
    servico.academico.Turma turmaAc = new Turma(turma.getCodigo(), (short)turma.getAno(), (short)turma.getSemestre(), new servico.academico.Disciplina(0, ""));
    return getAcademico().getMatriculasTurma(turmaAc);
     }*/

}
