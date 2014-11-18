package RMIGUniver;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoServer extends UnicastRemoteObject implements AlunoRemote {

	private static final long serialVersionUID = 1L;

	public AlunoServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			AlunoServer obj = new AlunoServer();
			Naming.rebind("//localhost/AlunoRemote", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	public Aluno BuscarAluno(int codigo) throws RemoteException {
		return new Aluno("Gustavo", 20);
	}

	public List<Aluno> BuscarAlunos() throws RemoteException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno("Gustavo Sabel", 20));
		alunos.add(new Aluno("William Leander Seefeld", 24));
		alunos.add(new Aluno("Viviane :)", 28));
		return alunos;
	}
}
