package br.furb.guniver.webservice;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import br.furb.guniver.modelo.*;
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
	return Conversor.CastProvas(academico.getProvas(codigoAluno, codigoTurma));
    }

    @WebMethod
    public Collection<Matricula> getMatriculasAluno(int codigoAluno) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return Conversor.CastMatriculas(academico.getMatriculasAluno(codigoAluno));
    }

    @WebMethod
    public Collection<Matricula> getMatriculasTurma(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return Conversor.CastMatriculas(academico.getMatriculasTurma(codigoTurma));
    }

    @WebMethod
    public Collection<Horario> getHorarios(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return Conversor.CastHorarios(academico.getHorarios(codigoTurma));
    }
    
    @WebMethod
    public List<Aluno> getAlunos() throws RemoteException {
	return Conversor.CastAlunos(Cadastro.getInstancia().getAlunos());
    }
    
    @WebMethod
    public List<Curso> getCursos(int codigoCurso) throws RemoteException {
	return Conversor.CastCursos(Cadastro.getInstancia().getCursos(codigoCurso));
    }
    
    @WebMethod
    public List<Disciplina> getDisciplinas(int codigoCurso) throws RemoteException {
	return Conversor.CastDisciplinas(Cadastro.getInstancia().getDisciplinas(codigoCurso));
    }
    
    @WebMethod
    public List<Turma> getTurmas(int codigoAluno) throws RemoteException {
	return Conversor.CastTurmas(Cadastro.getInstancia().getTurmas(codigoAluno));
    }
    
    @WebMethod
    public List<Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return Conversor.CastAlunos(Cadastro.getInstancia().getAlunosTurma(codigoTurma));
    }
}
