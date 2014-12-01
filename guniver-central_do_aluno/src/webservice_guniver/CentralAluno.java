package webservice_guniver;

import java.util.Collection;
import javax.jws.WebMethod;
import javax.jws.WebService;
import servico.Academico;
import servico.academico.Aluno;
import servico.academico.Prova;
import webservice_guniver.model.Compromisso;

@WebService
public class CentralAluno {

    @WebMethod
    public void removerCompromisso(long codigoCompromisso) {
	BancoDados.getInstance().deleteCompromisso(codigoCompromisso);
    }

    @WebMethod
    public Compromisso criarCompromisso(Compromisso compromisso) {
	return BancoDados.getInstance().setCompromisso(compromisso);
    }

    @WebMethod
    public Collection<Compromisso> getCompromissos() {
	return BancoDados.getInstance().getCompromissos();
    }

    @WebMethod
    public Collection<Compromisso> getCompromissosAluno(long codigoAluno) {
	return BancoDados.getInstance().getCompromissos(codigoAluno);
    }

    @WebMethod
    public String getMaterial(String idMaterial) {
	return "http://ava.furb.br/ava/resources/tela_view.php?ds_diretorio=2666732&nm_arquivo=estados_UML.doc";
    }

    @WebMethod
    public Collection<Prova> getProvas(int codigoAluno, int codigoTurma) {
	try {
	    Academico aca = new Academico(endereco.Endereco.academico.getEndereco());
	    Collection<Prova> provas = aca.buscarProvas(codigoAluno, codigoTurma);
	    return provas;
	} catch (Exception ex) {
	    System.out.println("Erro ao buscar as provas: \r\n" + ex.getMessage());
	}
	return null;
    }
/*
    @WebMethod
    public void getTurmas() {

    }

    @WebMethod
    public void getDisciplinas() {

    }*/
}
