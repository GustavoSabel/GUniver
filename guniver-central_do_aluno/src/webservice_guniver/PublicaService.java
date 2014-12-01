package webservice_guniver;

import javax.xml.ws.Endpoint;

public class PublicaService {

    public static void main(String[] args) {
	CentralAluno service = new CentralAluno();
	Endpoint endpoint = Endpoint.publish("http://localhost:8080/criarCompromisso", service);
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
