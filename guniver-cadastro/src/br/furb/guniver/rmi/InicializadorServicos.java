package br.furb.guniver.rmi;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class InicializadorServicos {

    public static void main(String[] args) {
	try {
	    
	    UnicastRemoteObject obj = new AlunoServer();
	    Naming.rebind("//localhost/AlunoRemote", obj);
	    
	    obj = new CursoServer();
	    Naming.rebind("//localhost/CursoRemote", obj);
	    
	    obj = new DisciplinaServer();
	    Naming.rebind("//localhost/DisciplinaRemote", obj);
	    
	    obj = new TurmaServer();
	    Naming.rebind("//localhost/TurmaRemote", obj);
	    
	    System.out.println("Módulo Cadastro - RMI");
	    System.out.println("Servidor aguardando requisicoes ....");
	    
	} catch (Exception ex) {
	    System.out.println("Exception: " + ex.getMessage());
	}
    }
}
