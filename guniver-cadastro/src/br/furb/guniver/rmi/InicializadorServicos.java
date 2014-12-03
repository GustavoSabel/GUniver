package br.furb.guniver.rmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class InicializadorServicos {

	public static void main(String[] args) {
		try {
			String hostAddress;
			try {
				hostAddress = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
				hostAddress = "localhost";
			}

			String host = "//" + hostAddress + "/";

			UnicastRemoteObject obj = new AlunoServer();
			Naming.rebind(host + "AlunoRemote", obj);

			obj = new CursoServer();
			Naming.rebind(host + "CursoRemote", obj);

			obj = new DisciplinaServer();
			Naming.rebind(host + "DisciplinaRemote", obj);

			obj = new TurmaServer();
			Naming.rebind(host + "TurmaRemote", obj);

			System.out.println("Módulo Cadastro - RMI");
			System.out.println("Servidor aguardando requisicoes ....");

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
}
