package rmi_guniver;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceiroServer extends UnicastRemoteObject implements
		FinanceiroRemote {

	private static final long serialVersionUID = 1L;

	public FinanceiroServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			FinanceiroServer obj = new FinanceiroServer();
			Naming.rebind("//localhost/FinanceiroRemote", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	@Override
	public boolean PagarMensansalidade(Mensalidade mensalidade)
			throws RemoteException {

		for (Mensalidade mens : BancoDados.getIntancia().mensalidades) {
			if (mens.getCodigoAluno() == mensalidade.getCodigoAluno()) {
				if (mens.getCodito() == mensalidade.getCodito()) {
					mens.setSituacao(Situacao.pago);
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public List<Mensalidade> consultarMensalidadesPendentes(int codigoAluno)
			throws RemoteException {
		List<Mensalidade> pendentes = new ArrayList<>();

		for (Mensalidade mensalidade : BancoDados.getIntancia().mensalidades) {
			if (mensalidade.getCodigoAluno() == codigoAluno) {
				if (mensalidade.getSituacao() != Situacao.pago) {
					pendentes.add(mensalidade);
				}
			}
		}

		return pendentes;
	}

	@Override
	public boolean CadastrarMensalidade(Mensalidade mensalidade)
			throws RemoteException {
		BancoDados.getIntancia().mensalidades.add(mensalidade);
		return false;
	}

}
