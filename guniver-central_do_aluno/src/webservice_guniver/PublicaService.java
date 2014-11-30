package webservice_guniver;

import javax.xml.ws.Endpoint;

public class PublicaService {

    public static void main(String[] args) {
	CentralAluno service = new CentralAluno();
	Endpoint endpoint = Endpoint.publish("http://localhost:8080/cadastrarCompromisso", service);
	endpoint = Endpoint.publish("http://localhost:8080/consultarCompromissos", service);
	endpoint = Endpoint.publish("http://localhost:8080/consultarCompromissosAluno", service);

	System.out.println("Módulo Central do Aluno - Web Service");
	System.out.println("Servidor aguardando requisicoes ....");
    }
}
