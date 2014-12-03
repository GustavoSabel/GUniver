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
	System.out.println("Executado getCursos");
	return BancoDados.getIntancia().getCurso();
    }

    @Override
    public void cadastrarCurso(Curso curso) throws RemoteException {
	System.out.println("Executado cadastrarCurso");
	boolean cursoEncontrato = false;
	for (Curso cursoBanco : BancoDados.getIntancia().getCurso()) {
	    if (cursoBanco.getCodigo() == curso.getCodigo()) {
		cursoBanco.setDescricao(curso.getDescricao());
		cursoEncontrato = true;
		System.out.println(" - curso atualizado");
	    }
	}
	if (!cursoEncontrato) {
	    BancoDados.getIntancia().getCurso().add(curso);
	    System.out.println(" - curso gravado");
	}
    }

    @Override
    public Curso buscarCurso(int codCurso) throws RemoteException {
	System.out.println("Executado buscarCurso");
	for (Curso curso : BancoDados.getIntancia().getCurso()) {
	    if (curso.getCodigo() == codCurso) {
		return curso;
	    }
	}
	return null;
    }

}
