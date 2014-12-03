package br.furb.guniver.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.furb.guniver.modelo.Aluno;

public class AlunoServer extends UnicastRemoteObject implements AlunoRemote {

	private static final long serialVersionUID = 1L;

	public AlunoServer() throws RemoteException {
		super();
	}

	public Aluno getAluno(int codigo) throws RemoteException {
		System.out.println("ExecutadogetAluno");
		for (Aluno aluno : BancoDados.getIntancia().getAlunos()) {
			if (aluno.getCodigo() == codigo)
				return aluno;
		}
		return null;
	}

	public List<Aluno> getAlunos() throws RemoteException {
		System.out.println("Executado getAlunos");
		return BancoDados.getIntancia().getAlunos();
	}

	@Override
	public void cadastrarAluno(Aluno aluno) throws RemoteException {
		System.out.println("Executado cadastrarAluno");
		Boolean jaExiste = false;
		for (Aluno alunoBanco : BancoDados.getIntancia().getAlunos()) {
			if (alunoBanco.getCodigo() == aluno.getCodigo()) {
				//throw new RemoteException("Já existe o aluno " + alunoBanco.getNome() + " com o código "
				//	+ alunoBanco.getCodigo());
				jaExiste = true;
				alunoBanco.setNome(aluno.getNome());
				alunoBanco.setNomeUsuario(aluno.getNomeUsuario());
				alunoBanco.setSenha(aluno.getSenha());
				System.out.println(" - Aluno alterado");
			}
		}
		if (!jaExiste) {
			BancoDados.getIntancia().getAlunos().add(aluno);
			System.out.println(" - Aluno cadastrado");
		}
	}

	@Override
	public Aluno getAlunoPorNomeUsuario(String nomeUsuario) throws RemoteException {
		System.out.println("Executado getAlunoPorNomeUsuario");
		if (nomeUsuario == null) {
			return null;
		}
		for (Aluno aluno : BancoDados.getIntancia().getAlunos()) {
			if (nomeUsuario.equals(aluno.getNomeUsuario()))
				return aluno;
		}
		return null;
	}

}
