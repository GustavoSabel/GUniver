package br.furb.guniver.rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.util.List;
import br.furb.guniver.modelo.cadastro.Aluno;

public class AlunoServer extends UnicastRemoteObject implements AlunoRemote {

    private static final long serialVersionUID = 1L;

    public AlunoServer() throws RemoteException {
	super();
    }

    /*public static void main(String[] args) {
	try {
	    AlunoServer obj = new AlunoServer();
	    Naming.rebind("//localhost/AlunoRemote", obj);
	    
	    System.out.println("Módulo Cadastro - RMI - Aluno");
	    System.out.println("Servidor aguardando requisicoes ....");
	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }*/

    public Aluno BuscarAluno(int codigo) throws RemoteException {
	for (Aluno aluno : BancoDados.getIntancia().getAlunos()) {
	    if (aluno.getCodigo() == codigo)
		return aluno;
	}
	return null;
    }

    public List<Aluno> BuscarAlunos() throws RemoteException {
	return BancoDados.getIntancia().getAlunos();
    }

    @Override
    public void CadastrarAluno(Aluno aluno) throws RemoteException {
	for (Aluno alunoBanco : BancoDados.getIntancia().getAlunos()) {
	    if (alunoBanco.getCodigo() == aluno.getCodigo())
		throw new RemoteException("Já existe o aluno " + alunoBanco.getNome() + " com o código "
			+ alunoBanco.getCodigo());
	}
	BancoDados.getIntancia().getAlunos().add(aluno);
    }

}