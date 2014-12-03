package br.furb.guniver.modulo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Curso;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Turma;
import br.furb.guniver.rmi.AlunoRemote;
import br.furb.guniver.rmi.CursoRemote;
import br.furb.guniver.rmi.DisciplinaRemote;
import br.furb.guniver.rmi.TurmaRemote;

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

    public List<Aluno> getAlunos() throws RemoteException {
	return alunoRemote.getAlunos();
    }
    
    public Aluno getAluno(int codigoAluno) throws RemoteException {
	return alunoRemote.getAluno(codigoAluno);
    }

    public Curso getCurso(int codigoCurso) throws RemoteException {
	return cursoRemote.buscarCurso(codigoCurso);
    }

    public List<Disciplina> getDisciplinasCurso(int codigoCurso) throws RemoteException {
	return disciplinaRemote.getDisciplinasCurso(codigoCurso);
    }
    
    public List<Disciplina> getDisciplinas() throws RemoteException {
	return disciplinaRemote.getDisciplinas();
    }
    
    public List<Turma> getTurmas(int codigoAluno) throws RemoteException {
	return turmaRemote.getTurmas(codigoAluno);
    }

    public List<Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return turmaRemote.getAlunosTurma(codigoTurma);
    }
    
    public Aluno getAlunoPorNomeUsuario(String nomeUsuario) throws RemoteException {
	return alunoRemote.getAlunoPorNomeUsuario(nomeUsuario);
    }
}
