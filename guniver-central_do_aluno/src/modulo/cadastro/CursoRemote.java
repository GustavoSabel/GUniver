package modulo.cadastro;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CursoRemote extends Remote {
	
	public List<Curso> getCursos() throws RemoteException;
	public void cadastrarCurso(Curso curso) throws RemoteException;
	public Curso buscarCurso(int codCurso) throws RemoteException;

}
