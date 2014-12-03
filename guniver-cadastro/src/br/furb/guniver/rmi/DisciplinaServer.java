package br.furb.guniver.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import br.furb.guniver.modelo.Curso;
import br.furb.guniver.modelo.Disciplina;

public class DisciplinaServer extends UnicastRemoteObject implements DisciplinaRemote {

    public DisciplinaServer() throws RemoteException {
	super();
    }

    @Override
    public List<Disciplina> getDisciplinas() throws RemoteException {
	return BancoDados.getIntancia().getDisciplina();
    }

    @Override
    public List<Disciplina> getDisciplinasCurso(int codCurso) throws RemoteException {
	System.out.println("Executado getDisciplinas");
	List<Disciplina> listDisc = new ArrayList<>();
	for (Disciplina disciplina : BancoDados.getIntancia().getDisciplina()) {
	    if (disciplina.getCurso().getCodigo() == codCurso) {
		listDisc.add(disciplina);
	    }
	}
	if (!listDisc.isEmpty()) {
	    return listDisc;
	}
	return null;
    }

    @Override
    public void cadastrarDisciplina(Disciplina disciplina) throws RemoteException {
	System.out.println("Executado cadastrarDisciplina");

	boolean disciplinaEncontrato = false;
	for (Disciplina disciplinaBanco : BancoDados.getIntancia().getDisciplina()) {
	    if (disciplinaBanco.getCodigo() == disciplina.getCodigo()) {
		disciplinaBanco.setNome(disciplina.getNome());

		//TODO: Verificar se deve mesmo ser atualizado o curso aqui
		//disciplinaBanco.setCurso(disciplina.getCurso());

		disciplinaEncontrato = true;
		System.out.println(" - Disciplina atualizada");
	    }
	}
	if (!disciplinaEncontrato) {
	    BancoDados.getIntancia().getDisciplina().add(disciplina);
	    System.out.println(" - Disciplina gravada");
	}

    }

    @Override
    public Disciplina getDisciplina(int codDisciplina) throws RemoteException {
	System.out.println("Executado getDisciplina");
	for (Disciplina disciplina : BancoDados.getIntancia().getDisciplina()) {
	    if (disciplina.getCodigo() == codDisciplina) {
		return disciplina;
	    }
	}
	return null;
    }

	@Override
	public List<Disciplina> getDisciplinasAll() throws RemoteException {
		return BancoDados.getIntancia().getDisciplina();
//skdhushdus
	}

}
