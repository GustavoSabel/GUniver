package webservice_guniver;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import webservice_guniver.model.Compromisso;
import endereco.Endereco;
import modulo.Academico;
import modulo.Cadastro;
import modulo.academico.Aluno;
import modulo.academico.Prova;

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
    public Collection<modulo.academico.Matricula> getMatriculasAluno(int codigoAluno) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getMatriculasAluno(codigoAluno);
    }

    @WebMethod
    public Collection<modulo.academico.Matricula> getMatriculasTurma(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getMatriculasTurma(codigoTurma);
    }

    @WebMethod
    public Collection<modulo.academico.Horario> getHorarios(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return academico.getHorarios(codigoTurma);
    }
    
    @WebMethod
    public List<modulo.cadastro.Aluno> getAlunos() throws RemoteException {
	return Cadastro.getInstancia().getAlunos();
    }
    
    @WebMethod
    public modulo.cadastro.Curso getCursos(int codigoCurso) throws RemoteException {
	return Cadastro.getInstancia().getCursos(codigoCurso);
    }
    
    @WebMethod
    public List<modulo.cadastro.Disciplina> getDisciplinas(int codigoCurso) throws RemoteException {
	return Cadastro.getInstancia().getDisciplinas(codigoCurso);
    }
    
    @WebMethod
    public List<modulo.cadastro.Turma> getTurmas(int codigoAluno) throws RemoteException {
	return Cadastro.getInstancia().getTurmas(codigoAluno);
    }
    
    @WebMethod
    public List<modulo.cadastro.Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return Cadastro.getInstancia().getAlunosTurma(codigoTurma);
    }
}
