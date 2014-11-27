package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaServer extends UnicastRemoteObject implements
		DisciplinaRemote {

	public DisciplinaServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			DisciplinaServer obj = new DisciplinaServer();
			Naming.rebind("//localhost/DisciplinaRemote", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	@Override
	public List<Disciplina> getDisciplinas(int codCurso) throws RemoteException {
		List<Disciplina> listDisc = new ArrayList<>();
		for (Disciplina disciplina : BancoDados.getIntancia().getDisciplina()) {
			if (disciplina.getCurso().getCodigo() == codCurso) {
			   listDisc.add(disciplina);
			}
		}
		if (!listDisc.isEmpty()){
			return listDisc;
		}
		return null;
	}

	@Override
	public void addDisciplina(Disciplina disciplina) throws RemoteException {
		BancoDados.getIntancia().getDisciplina().add(disciplina);

	}

	@Override
	public Disciplina getDisciplina(int codDisciplina) throws RemoteException {
		for (Disciplina disciplina : BancoDados.getIntancia().getDisciplina()) {
			if (disciplina.getCodigo() == codDisciplina) {
				return disciplina;
			}
		}
		return null;
	}

}
