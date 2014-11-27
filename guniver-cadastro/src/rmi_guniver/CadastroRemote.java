package rmi_guniver;

import java.rmi.*;
import java.util.List;

public interface CadastroRemote extends Remote {
	public void CadastrarAluno(Aluno aluno) throws RemoteException;
	public void CadastrarTurma(Turma turma) throws RemoteException;
	public void CadastrarDisciplina(Disciplina disciplina) throws RemoteException;
	
	public Aluno BuscarAluno(int codigo) throws RemoteException;
	public List<Aluno> BuscarAlunos() throws RemoteException;
	public List<Turma> BuscarTurmas(Aluno aluno) throws RemoteException;
}
