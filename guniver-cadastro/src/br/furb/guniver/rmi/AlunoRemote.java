package br.furb.guniver.rmi;

import java.rmi.*;
import java.util.List;
import br.furb.guniver.modelo.cadastro.Aluno;

public interface AlunoRemote extends Remote {
	public Aluno BuscarAluno(int codigo) throws RemoteException;
	public List<Aluno> BuscarAlunos() throws RemoteException;
	public void CadastrarAluno(Aluno aluno) throws RemoteException;
}
