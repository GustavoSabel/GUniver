package br.furb.guniver.corba;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import br.furb.guniver.modelo.academico.IAcademico;
import br.furb.guniver.modelo.academico.IAcademicoHelper;

public class servidor {

    public static void main(String args[]) {
	try {
	    // Cria e inicializa o ORB
	    ORB orb = ORB.init(args, null);

	    // Cria a implementa��o e registra no ORB
	    consulta_alunoImpl consulta_aluno = new consulta_alunoImpl();

	    // Ativa o POA
	    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	    rootpoa.the_POAManager().activate();

	    // Pega a refer�ncia do servidor
	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(consulta_aluno);
	    IAcademico href = IAcademicoHelper.narrow(ref);

	    // Obt�m uma refer�ncia para o servidor de nomes
	    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	    NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

	    // Registra o servidor no servico de nomes
	    String name = "IAcademico";
	    NameComponent path[] = namecontextRef.to_name(name);
	    namecontextRef.rebind(path, href);

	    System.out.println("Módulo Academico - CORBA");
	    System.out.println("Servidor aguardando requisicoes ....");

	    // Aguarda chamadas dos clientes
	    orb.run();
	} catch (Exception e) {
	    System.err.println("ERRO: " + e);
	    e.printStackTrace(System.out);
	}
	System.out.println("Encerrando o Servidor.");
    }
}
