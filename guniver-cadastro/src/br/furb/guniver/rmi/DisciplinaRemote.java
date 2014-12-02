package br.furb.guniver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Disciplina;

public interface DisciplinaRemote extends Remote {
	
	public List<Disciplina> buscarDisciplinas(int codCurso) throws RemoteException;
	public void cadastrarDisciplina(Disciplina disciplina) throws RemoteException;
	public Disciplina buscarDisciplina(int codDisciplina) throws RemoteException;
	

}
