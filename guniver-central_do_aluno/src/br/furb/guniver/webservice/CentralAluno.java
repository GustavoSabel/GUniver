package br.furb.guniver.webservice;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Compromisso;
import br.furb.guniver.modelo.Curso;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Horario;
import br.furb.guniver.modelo.Matricula;
import br.furb.guniver.modelo.Mensalidade;
import br.furb.guniver.modelo.Prova;
import br.furb.guniver.modelo.Turma;
import br.furb.guniver.modelo.endereco.Endereco;
import br.furb.guniver.modulo.Academico;
import br.furb.guniver.modulo.Cadastro;
import br.furb.guniver.modulo.ConversorAcademico;
import br.furb.guniver.modulo.Financeiro;

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
	return ConversorAcademico.castProvas(academico.getProvas(codigoAluno, codigoTurma));
    }

    @WebMethod
    public Collection<Matricula> getMatriculasAluno(int codigoAluno) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castMatriculas(academico.getMatriculasAluno(codigoAluno));
    }

    @WebMethod
    public Collection<Matricula> getMatriculasTurma(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castMatriculas(academico.getMatriculasTurma(codigoTurma));
    }

    @WebMethod
    public Collection<Horario> getHorarios(int codigoTurma) throws Exception {
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castHorarios(academico.getHorarios(codigoTurma));
    }

    @WebMethod
    public List<Aluno> getAlunos() throws RemoteException {
	return Cadastro.getInstancia().getAlunos();
    }

    @WebMethod
    public Curso getCurso(int codigoCurso) throws RemoteException {
	return Cadastro.getInstancia().getCurso(codigoCurso);
    }

    @WebMethod
    public List<Disciplina> getDisciplinas(int codigoCurso) throws RemoteException {
	return Cadastro.getInstancia().getDisciplinas(codigoCurso);
    }

    @WebMethod
    public List<Turma> getTurmas(int codigoAluno) throws RemoteException {
	return Cadastro.getInstancia().getTurmas(codigoAluno);
    }

    @WebMethod
    public List<Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	return Cadastro.getInstancia().getAlunosTurma(codigoTurma);
    }

    @WebMethod
    public List<Mensalidade> getMensalidadesPendentes(int codigoAluno) throws RemoteException {
	return Financeiro.getInstancia().getMensalidadesPendentes(codigoAluno);
    }

    @WebMethod
    public Aluno autenticaUsuario(String nomeUsuario, String senha) throws RemoteException {
	Aluno aluno = Cadastro.getInstancia().getAlunoPorNomeUsuario(nomeUsuario);
	if (aluno != null && aluno.getSenha() == senha) {
	    return aluno;
	} else {
	    return null;
	}
    }
}
