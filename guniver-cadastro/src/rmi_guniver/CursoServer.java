package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CursoServer extends UnicastRemoteObject implements CursoRemote {

	public CursoServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			CursoServer obj = new CursoServer();
			Naming.rebind("//localhost/CursoRemote", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	@Override
	public List<Curso> getCursos() throws RemoteException {
		return BancoDados.getIntancia().getCurso();
	}

	@Override
	public void addCurso(Curso curso) throws RemoteException {
		BancoDados.getIntancia().getCurso().add(curso);

	}

	@Override
	public Curso getCurso(int codCurso) throws RemoteException {
		for (Curso curso : BancoDados.getIntancia().getCurso()) {
			if (curso.getCodigo() == codCurso) {
				return curso;
			}
		}
		return null;
	}

}
