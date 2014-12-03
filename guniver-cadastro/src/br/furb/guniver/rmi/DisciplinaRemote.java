package br.furb.guniver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Disciplina;

public interface DisciplinaRemote extends Remote {

    public List<Disciplina> getDisciplinas() throws RemoteException;
    public List<Disciplina> getDisciplinasCurso(int codCurso) throws RemoteException;
    public void cadastrarDisciplina(Disciplina disciplina) throws RemoteException;
   //os métodos abaixo não aparecem no syncDisciplina
    public Disciplina getDisciplina(int codDisciplina) throws RemoteException;
    public List<Disciplina> getDisciplinasAll() throws RemoteException;
    //

}
