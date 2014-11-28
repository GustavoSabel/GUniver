package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import academico.Matricula;

public class TurmaServer extends UnicastRemoteObject implements TurmaRemote {

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

    /*
    	@Override
    	public void addAluno(int codigo, Aluno aluno) throws RemoteException {
    		//TODO busca a turma atraves do indice e não pelo código como deveria
    		Turma turma = BancoDados.getIntancia().getTurmas().get(codigo - 1);
    		turma.addAluno(aluno);
    	}*/

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
	    
	    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX: " + codTurma);
	    
	    Matricula[] matriculasAcademico = new academico.Academico()
		    .buscarMatriculas(new Turma(codTurma, null, 0, 0));
	    
	    System.out.println("Número de matriculas: " + matriculasAcademico.length);
	    
	    for (Matricula matricula : matriculasAcademico) {
		System.out.println("matricula.aluno.codigo: " + matricula.aluno.codigo);
		Aluno aluno = BancoDados.getIntancia().getAluno(matricula.aluno.codigo);
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
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
	    Matricula[] matriculasAcademico = new academico.Academico()
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
    
    /*
    	@Override
    	public List<Aluno> BuscarAlunosDisciplina(int codDisciplinas)
    			throws RemoteException {
    		List<Aluno> listAluno = new ArrayList<>();
    		for (Turma turma : BancoDados.getIntancia().getTurmas()) {
    			if (turma.getDisciplina().getCodigo() == codDisciplinas){
    				for(Aluno aluno : turma.getAlunos()){
    					listAluno.add(aluno);
    				}
    			}
    		}
    		if(!listAluno.isEmpty()){
    			return listAluno;
    		}
    		return null;
    	}
    	*/



}
