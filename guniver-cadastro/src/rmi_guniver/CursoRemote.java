package rmi_guniver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CursoRemote extends Remote {
	
	public List<Curso> getCursos() throws RemoteException;
	public void addCurso(Curso curso) throws RemoteException;
	public Curso getCurso(int codCurso) throws RemoteException;

}
