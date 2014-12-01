package rmi_guniver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
			
			System.out.println("Módulo Financeiro - RMI");
			System.out.println("Servidor aguardando requisicoes ....");
			    
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	@Override
	public boolean PagarMensansalidade(Mensalidade mensalidade)
			throws RemoteException {

		for (Mensalidade mens : BancoDados.getIntancia().mensalidades) {
			if (mens.getCodigoAluno() == mensalidade.getCodigoAluno()) {
				if (mens.getCodigo() == mensalidade.getCodigo()) {
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
	public List<Mensalidade> consultarMensalidadePeriodo(
			int codigoAluno, Date data) throws RemoteException {
		List<Mensalidade> men = new ArrayList<>();
		for (Mensalidade mensalidade : BancoDados.getIntancia().mensalidades) {
			if (mensalidade.getCodigoAluno() == codigoAluno) {
				int[] data1 = getData(data); //[0] = DIA | [1] = MES | [2] = ANO
				int[] data2 = getData(mensalidade.getData());
				if(data1[1] == data2[1] &&
						data1[2] == data2[2]){
					men.add(mensalidade);
				}
			}
			
		}
		if(!men.isEmpty()){
			return men;
		}
		return null;
	}
	
	private int[] getData(Date data){
		int[] ret = new int[3];
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		ret[0] = cal.get(Calendar.DAY_OF_MONTH);
		ret[1] = cal.get(Calendar.MONTH)+1;
		ret[2] = cal.get(Calendar.YEAR);
		return ret;
	}
	

	@Override
	public boolean CadastrarMensalidade(Mensalidade mensalidade)
			throws RemoteException {
		BancoDados.getIntancia().mensalidades.add(mensalidade);
		return false;
	}

}
