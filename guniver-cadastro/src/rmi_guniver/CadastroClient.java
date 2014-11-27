package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

public class CadastroClient {

    public static void main(String[] args) {
	try {
	    CadastroRemote obj = (CadastroRemote) Naming.lookup("//" + args[0] + "/AlunoRemote");

	    alert("INICIO -----------------------------------------------------------------");
	    Aluno alunoWilliam = new Aluno(1, "William Seefeld");
	    obj.CadastrarAluno(alunoWilliam);
	    Aluno alunoViviam = new Aluno(40, "Vivian");
	    obj.CadastrarAluno(alunoViviam);
	    CadastroClient.alert("CadastrarAluno OK");
	    alert("");
	    
	    Disciplina disciplinaSD = new Disciplina(10, "Sistemas Distribuidos");
	    obj.CadastrarDisciplina(disciplinaSD);
	    CadastroClient.alert("CadastrarDisciplina OK");
	    alert("");
	    
	    Turma turmaA = new Turma(1, "A", (short)2014, (short)2, disciplinaSD);
	    obj.CadastrarTurma(turmaA);
	    CadastroClient.alert("CadastrarTurma OK");
	    alert("");
	    
	    Aluno al = obj.BuscarAluno(1);
	    CadastroClient.alert("Aluno: " + al.getCodigo() + " - " + al.getNome());
	    CadastroClient.alert("BuscarAluno OK");
	    alert("");
	    
	    List<Aluno> alunos = obj.BuscarAlunos();
	    for (Aluno aluno : alunos) {
		System.out.println("Aluno: " + aluno.getCodigo() + " - " + aluno.getNome());
	    }
	    CadastroClient.alert("BuscarAlunos OK");
	    alert("");
	    
	    List<Turma> turmas = obj.BuscarTurmas(al);
	    for (Turma turma : turmas) {
		alert("Turma: " + turma.codigo + " Semestre:" + turma.ano + "\\" + turma.semestre);
		alert("Disciplina: " + turma.disciplina.nome);
	    }
	    CadastroClient.alert("BuscarTurmas OK");
	    alert("");
	    
	    /*
		public void CadastrarAluno(Aluno aluno) throws RemoteException;
		public void CadastrarTurma(Turma turma) throws RemoteException;
		public void CadastrarDisciplina(Disciplina disciplina) throws RemoteException;
		
		public Aluno BuscarAluno(int codigo) throws RemoteException;
		public List<Aluno> BuscarAlunos() throws RemoteException;
		public List<Turma> BuscarTurma(Aluno aluno) throws RemoteException;*/

	    alert("FIM -----------------------------------------------------------------");
	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }
    
    private static void alert(String msg) {
	System.out.println(msg);
    }
}
