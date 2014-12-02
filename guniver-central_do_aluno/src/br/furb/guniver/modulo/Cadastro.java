package br.furb.guniver.modulo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.cadastro.AlunoRemote;
import br.furb.guniver.modelo.cadastro.CursoRemote;
import br.furb.guniver.modelo.cadastro.DisciplinaRemote;
import br.furb.guniver.modelo.cadastro.TurmaRemote;

public class Cadastro {

    private AlunoRemote alunoRemote;
    private CursoRemote cursoRemote;
    private DisciplinaRemote disciplinaRemote;
    private TurmaRemote turmaRemote;

    private static Cadastro cadastro;

    private Cadastro() {
	try {
	    alunoRemote = (AlunoRemote) Naming.lookup("//" + br.furb.guniver.modelo.endereco.Endereco.cadastro.getEndereco() + "/AlunoRemote");

	    cursoRemote = (CursoRemote) Naming.lookup("//" + br.furb.guniver.modelo.endereco.Endereco.cadastro.getEndereco() + "/CursoRemote");

	    disciplinaRemote = (DisciplinaRemote) Naming.lookup("//" + br.furb.guniver.modelo.endereco.Endereco.cadastro.getEndereco()
		    + "/DisciplinaRemote");

	    turmaRemote = (TurmaRemote) Naming.lookup("//" + br.furb.guniver.modelo.endereco.Endereco.cadastro.getEndereco() + "/TurmaRemote");
	} catch (Exception ex) {
	    System.out.println("Erro ao se conectar ao módulo cadastro. " + ex.getMessage());
	}
    }

    public static Cadastro getInstancia() {
	if (cadastro == null)
	    cadastro = new Cadastro();
	return cadastro;
    }

    public List<br.furb.guniver.modelo.cadastro.Aluno> getAlunos() throws RemoteException {
	return alunoRemote.BuscarAlunos();
    }

    public br.furb.guniver.modelo.cadastro.Curso getCursos(int codigoCurso) throws RemoteException {
	return cursoRemote.buscarCurso(codigoCurso);
    }

    public List<br.furb.guniver.modelo.cadastro.Disciplina> getDisciplinas(int codigoCurso) throws RemoteException {
	return disciplinaRemote.buscarDisciplinas(codigoCurso);
    }

    public List<br.furb.guniver.modelo.cadastro.Turma> getTurmas(int codigoAluno) throws RemoteException {
	return turmaRemote.BuscarTurmas(codigoAluno);
    }

    public List<br.furb.guniver.modelo.cadastro.Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return turmaRemote.BuscarAlunosTurma(codigoTurma);
    }
}
