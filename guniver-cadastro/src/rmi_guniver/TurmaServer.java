package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import endereco.Endereco;
import academico.Matricula;

public class TurmaServer extends UnicastRemoteObject implements TurmaRemote {

    private static final long serialVersionUID = 1456L;

    public TurmaServer() throws RemoteException {
	super();
    }

    public static void main(String[] args) {
	try {
	    TurmaServer obj = new TurmaServer();
	    Naming.rebind("//localhost/TurmaRemote", obj);

	    System.out.println("Módulo Cadastro - RMI - Turma");
	    System.out.println("Servidor aguardando requisicoes ....");
	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }

    @Override
    public List<Turma> getTurma(int codDisc, int ano, int semestre) throws RemoteException {
	System.out.println("Executado getTurma(int codDisc, int ano, int semestre)");
	List<Turma> listTurma = new ArrayList<>();
	for (Turma turma : BancoDados.getIntancia().getTurmas()) {
	    if (turma.getDisciplina().getCodigo() == codDisc && turma.getAno() == ano
		    && turma.getSemestre() == semestre)
		listTurma.add(turma);
	}
	if (!listTurma.isEmpty()) {
	    return listTurma;
	} else {
	    return null;
	}
    }

    @Override
    public void cadastrarTurma(Turma turma) throws RemoteException {
	System.out.println("Executado cadastrarTurma(Turma turma)");
	BancoDados.getIntancia().getTurmas().add(turma);
    }

    @Override
    public List<Aluno> BuscarAlunosTurma(int codTurma) throws RemoteException {
	System.out.println("Executado BuscarAlunosTurma(int codTurma)");
	try {
	    List<Aluno> alunos = new ArrayList<Aluno>();

	    Matricula[] matriculasAcademico = new academico.Academico(Endereco.academico.getEndereco())
		    .buscarMatriculas(new Turma(codTurma, null, 0, 0));

	    System.out.println("Número de matriculas: " + matriculasAcademico.length);

	    for (Matricula matricula : matriculasAcademico) {
		System.out.println("matricula.aluno.codigo: " + matricula.aluno.codigo);
		Aluno aluno = BancoDados.getIntancia().getAluno(matricula.aluno.codigo);
		if (aluno != null) {
		    alunos.add(aluno);
		}
	    }
	    System.out.println("Numero de alunos" + alunos.size());
	    return alunos;
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
    }

    @Override
    public List<Turma> BuscarTurmas(int codAluno) throws RemoteException {
	System.out.println("Executado BuscarTurmas(int codAluno)");
	try {
	    List<Turma> turmas = new ArrayList<Turma>();
	    Matricula[] matriculasAcademico = new academico.Academico(Endereco.academico.getEndereco())
		    .buscarMatriculas(new Aluno(codAluno, ""));

	    for (Matricula matricula : matriculasAcademico) {
		Turma turma = BancoDados.getIntancia().getTurma(matricula.turma.codigo);
		if (turma != null) {
		    turmas.add(turma);
		}
	    }
	    return turmas;
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
    }

}
