package rmi_guniver;

import java.rmi.*;
import java.util.Date;
import java.util.List;

public interface FinanceiroRemote extends Remote {
	public boolean PagarMensansalidade(Mensalidade mensalidade) throws RemoteException;
	public List<Mensalidade> consultarMensalidadesPendentes(int codigoAluno) throws RemoteException;
	public List<Mensalidade> consultarMensalidadePeriodo(int codigoAluno,Date data) throws RemoteException;
	public boolean CadastrarMensalidade(Mensalidade mensalidade) throws RemoteException;
}
