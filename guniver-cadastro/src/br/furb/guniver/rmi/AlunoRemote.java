package br.furb.guniver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Aluno;

public interface AlunoRemote extends Remote {
	public Aluno BuscarAluno(int codigo) throws RemoteException;
	public List<Aluno> BuscarAlunos() throws RemoteException;
	public void CadastrarAluno(Aluno aluno) throws RemoteException;
}
