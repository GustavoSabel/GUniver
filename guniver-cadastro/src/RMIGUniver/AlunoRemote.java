package RMIGUniver;

import java.rmi.*;
import java.util.List;

public interface AlunoRemote extends Remote {
	public Aluno BuscarAluno(int codigo) throws RemoteException;

	public List<Aluno> BuscarAlunos() throws RemoteException;
}
