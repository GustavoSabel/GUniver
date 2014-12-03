package br.furb.guniver.webservice;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

public class PublicaService {

	public static void main(String[] args) {
		CentralAluno service = new CentralAluno();
		String hostAddress;
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			hostAddress = "localhost";
		}
		//Endpoint.publish("http://" + hostAddress + ":8080/centralAluno", service);

		Endpoint.publish("http://192.168.0.13:8080/centralAluno", service);
		
		/*endpoint = Endpoint.publish("http://localhost:8080/removerCompromisso", service);
		endpoint = Endpoint.publish("http://localhost:8080/getCompromissos", service);
		endpoint = Endpoint.publish("http://localhost:8080/getCompromissosAluno", service);
		endpoint = Endpoint.publish("http://localhost:8080/getMaterial", service);
		endpoint = Endpoint.publish("http://localhost:8080/getProvas", service);
		endpoint = Endpoint.publish("http://localhost:8080/getMatriculasAluno", service);
		endpoint = Endpoint.publish("http://localhost:8080/getMatriculasTurma", service);
		endpoint = Endpoint.publish("http://localhost:8080/getHorarios", service);*/

		System.out.println("Módulo Central do Aluno - Web Service");
		System.out.println("Servidor aguardando requisicoes ....");
	}
}