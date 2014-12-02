package br.furb.guniver.modulo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Curso;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Mensalidade;
import br.furb.guniver.modelo.Turma;
import br.furb.guniver.modelo.endereco.Endereco;
import br.furb.guniver.rmi.AlunoRemote;
import br.furb.guniver.rmi.CursoRemote;
import br.furb.guniver.rmi.DisciplinaRemote;
import br.furb.guniver.rmi.FinanceiroRemote;
import br.furb.guniver.rmi.TurmaRemote;

public class Financeiro {

    private FinanceiroRemote financeiroRemote;

    private static Financeiro cadastro;

    private Financeiro() {
	try {
	    financeiroRemote = (FinanceiroRemote) Naming.lookup("//" + Endereco.financeiro.getEndereco() + "/FinanceiroRemote");
	} catch (Exception ex) {
	    System.out.println("Erro ao se conectar ao módulo cadastro. " + ex.getMessage());
	}
    }

    public static Financeiro getInstancia() {
	if (cadastro == null)
	    cadastro = new Financeiro();
	return cadastro;
    }

    public List<Mensalidade> getMensalidadesPendentes(int codigoAluno) throws RemoteException {
	return financeiroRemote.consultarMensalidadesPendentes(codigoAluno);
    }
    
}
