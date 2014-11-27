package rmi_guniver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DisciplinaRemote extends Remote {
	
	public List<Disciplina> getDisciplinas(int codCurso) throws RemoteException;
	public void addDisciplina(Disciplina disciplina) throws RemoteException;
	public Disciplina getDisciplina(int codDisciplina) throws RemoteException;
	

}
