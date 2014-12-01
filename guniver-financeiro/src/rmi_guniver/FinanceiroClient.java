package rmi_guniver;

import java.io.ObjectInputStream.GetField;
import java.rmi.Naming;
import java.util.Date;
import java.util.List;

public class FinanceiroClient {

    public static void main(String[] args) {
	try {
	    //FinanceiroRemote obj = (FinanceiroRemote) Naming.lookup("//"
	    //		+ args[0] + "/FinanceiroRemote");

	    FinanceiroRemote obj = (FinanceiroRemote) Naming.lookup("//localhost/FinanceiroRemote");

	    Mensalidade men = new Mensalidade();
	    men.setCodigo(1);
	    men.setCodigoAluno(1);
	    men.setData(new Date());
	    men.setDescricao("Mensalidade reference ao mês 11 de 2014");
	    men.setSituacao(Situacao.a_pago);
	    men.setValor(785.85);

	    obj.CadastrarMensalidade(men);
	    System.out.println("Cadastrada a mensalidade "+men.getCodigo());
	    System.out.println("Data: "+ men.getData().toString());
	    System.out.println();

	    List<Mensalidade> mensalidadesPendentes = obj.consultarMensalidadesPendentes(1);
	    System.out.println("Mensalidades pendentes");
	    for (Mensalidade mensalidade : mensalidadesPendentes) {
		System.out.println(mensalidade.getDescricao());
	    }
	    System.out.println();

	    // Mon Dec 01 11:08:09 BRST 2014
	    System.out.println("Busca por mensalidades por periodo");
	    for(Mensalidade mens : obj.consultarMensalidadePeriodo(1,new Date())){
	    	System.out.println("Existe Mensalidade");
	    }
	    System.out.println("");
	    

	    obj.PagarMensansalidade(men);
	    System.out.println("Pagar a mensalidade "+men.getCodigo());
	    System.out.println();

	    mensalidadesPendentes = obj.consultarMensalidadesPendentes(1);
	    System.out.println("Mensalidades pendentes");
	    for (Mensalidade mensalidade : mensalidadesPendentes) {
		System.out.println(mensalidade.getDescricao());
	    }

	    System.out.println();
	    System.out.println("FIM");
	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }
}
