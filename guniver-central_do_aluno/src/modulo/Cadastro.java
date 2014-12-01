package modulo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import modulo.cadastro.AlunoRemote;
import modulo.cadastro.CursoRemote;
import modulo.cadastro.DisciplinaRemote;
import modulo.cadastro.TurmaRemote;

public class Cadastro {

    private AlunoRemote alunoRemote;
    private CursoRemote cursoRemote;
    private DisciplinaRemote disciplinaRemote;
    private TurmaRemote turmaRemote;

    private static Cadastro cadastro;

    private Cadastro() {
	try {
	    alunoRemote = (AlunoRemote) Naming.lookup("//" + endereco.Endereco.cadastro.getEndereco() + "/AlunoRemote");

	    cursoRemote = (CursoRemote) Naming.lookup("//" + endereco.Endereco.cadastro.getEndereco() + "/CursoRemote");

	    disciplinaRemote = (DisciplinaRemote) Naming.lookup("//" + endereco.Endereco.cadastro.getEndereco()
		    + "/DisciplinaRemote");

	    turmaRemote = (TurmaRemote) Naming.lookup("//" + endereco.Endereco.cadastro.getEndereco() + "/TurmaRemote");
	} catch (Exception ex) {
	    System.out.println("Erro ao se conectar ao módulo cadastro. " + ex.getMessage());
	}
    }

    public static Cadastro getInstancia() {
	if (cadastro == null)
	    cadastro = new Cadastro();
	return cadastro;
    }

    public List<modulo.cadastro.Aluno> getAlunos() throws RemoteException {
	return alunoRemote.BuscarAlunos();
    }

    public modulo.cadastro.Curso getCursos(int codigoCurso) throws RemoteException {
	return cursoRemote.buscarCurso(codigoCurso);
    }

    public List<modulo.cadastro.Disciplina> getDisciplinas(int codigoCurso) throws RemoteException {
	return disciplinaRemote.buscarDisciplinas(codigoCurso);
    }

    public List<modulo.cadastro.Turma> getTurmas(int codigoAluno) throws RemoteException {
	return turmaRemote.BuscarTurmas(codigoAluno);
    }

    public List<modulo.cadastro.Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return turmaRemote.BuscarAlunosTurma(codigoTurma);
    }
}
