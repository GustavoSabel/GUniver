package rmi_guniver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TurmaRemote extends Remote {
	
	public List <Turma> getTurma(int codDisc, int ano, int semestre) throws RemoteException;
	public void addAluno(int codigo, Aluno aluno) throws RemoteException;
	public void addTurma(Turma turma) throws RemoteException;
	public List<Aluno> BuscarAlunosTurma(int codTurma) throws RemoteException;
	public List<Aluno> BuscarAlunosDisciplina(int codDisciplinas) throws RemoteException;


}
