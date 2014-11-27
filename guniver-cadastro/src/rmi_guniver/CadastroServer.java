package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import academico.Academico;
import academico.model.Matricula;

public class CadastroServer extends UnicastRemoteObject implements CadastroRemote {

    private static final long serialVersionUID = 1L;

    public CadastroServer() throws RemoteException {
	super();
    }

    public static void main(String[] args) {
	try {
	    CadastroServer obj = new CadastroServer();
	    Naming.rebind("//localhost/AlunoRemote", obj);

	    System.out.println("CADASTRO");
	    System.out.println("Servidor aguardando requisicoes ....");

	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }

    public Aluno BuscarAluno(int codigo) throws RemoteException {
	for (Aluno aluno : BancoDados.getIntancia().alunos) {
	    if (aluno.getCodigo() == codigo)
		return aluno;
	}
	return null;
    }

    public List<Aluno> BuscarAlunos() throws RemoteException {
	return BancoDados.getIntancia().alunos;
    }

    @Override
    public void CadastrarAluno(Aluno aluno) throws RemoteException {
	for (Aluno alunoBanco : BancoDados.getIntancia().alunos) {
	    if (alunoBanco.getCodigo() == aluno.getCodigo())
		throw new RemoteException("Já existe o aluno " + alunoBanco.getNome() + " com o código "
			+ alunoBanco.getCodigo());
	}
	BancoDados.getIntancia().alunos.add(aluno);
    }

    @Override
    public void CadastrarTurma(Turma turma) throws RemoteException {
	for (Turma turmaCadastrada : BancoDados.getIntancia().turmas) {
	    if (turmaCadastrada.codigo == turma.codigo) {
		throw new RemoteException("Já existe a turma " + turmaCadastrada.nome + " cadastrada com o código "
			+ turmaCadastrada.codigo);
	    }
	}
	BancoDados.getIntancia().turmas.add(turma);
    }

    @Override
    public void CadastrarDisciplina(Disciplina disciplina) throws RemoteException {
	for (Disciplina disciplinaCadastrada : BancoDados.getIntancia().disciplinas) {
	    if (disciplinaCadastrada.codigo == disciplina.codigo) {
		throw new RemoteException("Já existe a disciplina " + disciplinaCadastrada.nome
			+ " cadastrada com o código " + disciplinaCadastrada.codigo);
	    }
	}
	BancoDados.getIntancia().disciplinas.add(disciplina);
    }

    @Override
    public List<Turma> BuscarTurmas(Aluno aluno) throws RemoteException {
	try {
	    List<Turma> turmas = new ArrayList<Turma>();
	    Academico academico = new Academico();
	    Matricula[] matriculas = academico.buscarMatriculas(aluno);

	    for (Matricula matricula : matriculas) {
		for (Turma turma : BancoDados.getIntancia().turmas) {
		    if (matricula.turma.codigo == turma.codigo) {
			turmas.add(turma);
		    }
		}
	    }

	    return turmas;
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
    }
}
