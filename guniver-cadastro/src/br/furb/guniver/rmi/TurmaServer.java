package br.furb.guniver.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Turma;
import br.furb.guniver.modelo.academico.Matricula;
import br.furb.guniver.modelo.endereco.Endereco;
import br.furb.guniver.modulo.Academico;

public class TurmaServer extends UnicastRemoteObject implements TurmaRemote {

    private static final long serialVersionUID = 1456L;
    private Academico academico;

    public TurmaServer() throws RemoteException {
	super();
	academico = new Academico(Endereco.academico.getEndereco());
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

	boolean turmaEncontrato = false;
	for (Turma turmaBanco : BancoDados.getIntancia().getTurmas()) {
	    if (turmaBanco.getCodigo() == turma.getCodigo()) {
		turmaBanco.setAno(turma.getAno());
		turmaBanco.setSemestre(turma.getSemestre());

		//turmaBanco.setDisciplina(turma.getDisciplina())
		//TODO: Verificar se deve mesmo ser atualizado o curso aqui

		turmaEncontrato = true;
		System.out.println(" - Turma atualizada");
	    }
	}
	if (!turmaEncontrato) {
	    BancoDados.getIntancia().getTurmas().add(turma);
	    System.out.println(" - Turma gravada");
	}

    }

    @Override
    public List<Aluno> getAlunosTurma(int codTurma) throws RemoteException {
	System.out.println("Executado BuscarAlunosTurma(int codTurma)");
	try {
	    List<Aluno> alunos = new ArrayList<Aluno>();

	    Matricula[] matriculasAcademico = academico.buscarMatriculas(new Turma(codTurma, null, 0, 0));

	    System.out.println("Número de matriculas: " + matriculasAcademico.length);

	    for (Matricula matricula : matriculasAcademico) {
		System.out.println("matricula.aluno.codigo: " + matricula.codigoAluno);
		Aluno aluno = BancoDados.getIntancia().getAluno(matricula.codigoAluno);
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
    public List<Turma> getTurmasAluno(int codAluno) throws RemoteException {
	System.out.println("Executado BuscarTurmas(int codAluno)");
	try {
	    List<Turma> turmas = new ArrayList<Turma>();
	    Matricula[] matriculasAcademico = academico.buscarMatriculas(new Aluno(codAluno, ""));

	    for (Matricula matricula : matriculasAcademico) {
		Turma turma = BancoDados.getIntancia().getTurma(matricula.codigoTurma);
		if (turma != null) {
		    turmas.add(turma);
		}
	    }
	    return turmas;
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
    }

    @Override
    public List<Turma> getTurmas() throws RemoteException {
	return BancoDados.getIntancia().getTurmas();
    }

}
