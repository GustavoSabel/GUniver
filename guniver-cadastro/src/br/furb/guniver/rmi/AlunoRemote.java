package br.furb.guniver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Aluno;

public interface AlunoRemote extends Remote {
	public Aluno getAluno(int codigo) throws RemoteException;
	public List<Aluno> getAlunos() throws RemoteException;
	public void cadastrarAluno(Aluno aluno) throws RemoteException;
	public Aluno getAlunoPorNomeUsuario(String nomeUsuario) throws RemoteException;
}
