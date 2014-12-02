package br.furb.guniver.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import br.furb.guniver.modelo.Curso;

public class CursoServer extends UnicastRemoteObject implements CursoRemote {

    private static final long serialVersionUID = 55644L;

    public CursoServer() throws RemoteException {
	super();
    }

    @Override
    public List<Curso> getCursos() throws RemoteException {
	return BancoDados.getIntancia().getCurso();
    }

    @Override
    public void cadastrarCurso(Curso curso) throws RemoteException {
	BancoDados.getIntancia().getCurso().add(curso);

    }

    @Override
    public Curso buscarCurso(int codCurso) throws RemoteException {
	for (Curso curso : BancoDados.getIntancia().getCurso()) {
	    if (curso.getCodigo() == codCurso) {
		return curso;
	    }
	}
	return null;
    }

}
