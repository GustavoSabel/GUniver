package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import academico.Academico;
import academico.Matricula;

public class TurmaServer extends UnicastRemoteObject implements TurmaRemote {

    public TurmaServer() throws RemoteException {
	super();
    }

    public static void main(String[] args) {
	try {
	    TurmaServer obj = new TurmaServer();
	    Naming.rebind("//localhost/TurmaRemote", obj);
	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }

    @Override
    public List<Turma> getTurma(int codDisc, int ano, int semestre) throws RemoteException {
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
	BancoDados.getIntancia().getTurmas().add(turma);
    }

    @Override
    public List<Aluno> BuscarAlunosTurma(int codTurma) throws RemoteException {
	try {
	    List<Aluno> alunos = new ArrayList<Aluno>();
	    Matricula[] matriculasAcademico = new academico.Academico()
		    .buscarMatriculas(new Turma(codTurma, null, 0, 0));

	    for (Matricula matricula : matriculasAcademico) {
		Aluno aluno = BancoDados.getIntancia().getAluno(matricula.aluno.codigo);
		if (aluno != null) {
		    alunos.add(aluno);
		}
	    }
	    return alunos;
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
    }
    
    @Override
    public List<Turma> BuscarTurmas(int codAluno) throws RemoteException {
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
