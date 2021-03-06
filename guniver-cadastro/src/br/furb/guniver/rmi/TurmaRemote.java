package br.furb.guniver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Turma;

public interface TurmaRemote extends Remote {
	
	public List <Turma> getTurma(int codDisc, int ano, int semestre) throws RemoteException;
	//public void addAluno(int codigo, Aluno aluno) throws RemoteException;
	public void cadastrarTurma(Turma turma) throws RemoteException;
	public List<Aluno> getAlunosTurma(int codTurma) throws RemoteException;
	public List<Turma> getTurmasAluno(int codAluno) throws RemoteException;
	public List<Turma> getTurmas() throws RemoteException;
	//public List<Aluno> BuscarAlunosDisciplina(int codDisciplinas) throws RemoteException;


}
