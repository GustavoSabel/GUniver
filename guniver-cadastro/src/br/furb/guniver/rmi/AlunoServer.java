package br.furb.guniver.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import br.furb.guniver.modelo.Aluno;

public class AlunoServer extends UnicastRemoteObject implements AlunoRemote {

    private static final long serialVersionUID = 1L;

    public AlunoServer() throws RemoteException {
	super();
    }

    public Aluno getAluno(int codigo) throws RemoteException {
	for (Aluno aluno : BancoDados.getIntancia().getAlunos()) {
	    if (aluno.getCodigo() == codigo)
		return aluno;
	}
	return null;
    }

    public List<Aluno> getAlunos() throws RemoteException {
	return BancoDados.getIntancia().getAlunos();
    }

    @Override
    public void cadastrarAluno(Aluno aluno) throws RemoteException {
	for (Aluno alunoBanco : BancoDados.getIntancia().getAlunos()) {
	    if (alunoBanco.getCodigo() == aluno.getCodigo())
		throw new RemoteException("Já existe o aluno " + alunoBanco.getNome() + " com o código "
			+ alunoBanco.getCodigo());
	}
	BancoDados.getIntancia().getAlunos().add(aluno);
    }

    @Override
    public Aluno getAlunoPorNomeUsuario(String nomeUsuario) throws RemoteException {
	for (Aluno aluno : BancoDados.getIntancia().getAlunos()) {
	    if (aluno.getNomeUsuario() == nomeUsuario)
		return aluno;
	}
	return null;
    }

}
