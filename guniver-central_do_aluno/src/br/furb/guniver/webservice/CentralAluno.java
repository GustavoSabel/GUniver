package br.furb.guniver.webservice;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import br.furb.guniver.modelo.academico.Aluno;
import br.furb.guniver.modelo.academico.Prova;
import br.furb.guniver.modelo.central_do_aluno.Compromisso;
import br.furb.guniver.modelo.endereco.Endereco;
import br.furb.guniver.modulo.Academico;
import br.furb.guniver.modulo.Cadastro;

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
    public Collection<Prova> getProvas(int codigoAluno, int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getProvas(codigoAluno, codigoTurma);
    }

    @WebMethod
    public Collection<br.furb.guniver.modelo.academico.Matricula> getMatriculasAluno(int codigoAluno) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getMatriculasAluno(codigoAluno);
    }

    @WebMethod
    public Collection<br.furb.guniver.modelo.academico.Matricula> getMatriculasTurma(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getMatriculasTurma(codigoTurma);
    }

    @WebMethod
    public Collection<br.furb.guniver.modelo.academico.Horario> getHorarios(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getHorarios(codigoTurma);
    }
    
    @WebMethod
    public List<br.furb.guniver.modelo.cadastro.Aluno> getAlunos() throws RemoteException {
	return Cadastro.getInstancia().getAlunos();
    }
    
    @WebMethod
    public br.furb.guniver.modelo.cadastro.Curso getCursos(int codigoCurso) throws RemoteException {
	return Cadastro.getInstancia().getCursos(codigoCurso);
    }
    
    @WebMethod
    public List<br.furb.guniver.modelo.cadastro.Disciplina> getDisciplinas(int codigoCurso) throws RemoteException {
	return Cadastro.getInstancia().getDisciplinas(codigoCurso);
    }
    
    @WebMethod
    public List<br.furb.guniver.modelo.cadastro.Turma> getTurmas(int codigoAluno) throws RemoteException {
	return Cadastro.getInstancia().getTurmas(codigoAluno);
    }
    
    @WebMethod
    public List<br.furb.guniver.modelo.cadastro.Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return Cadastro.getInstancia().getAlunosTurma(codigoTurma);
    }
}
