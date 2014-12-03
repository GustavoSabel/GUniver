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
	System.out.println("removerCompromisso");
	BancoDados.getInstance().deleteCompromisso(codigoCompromisso);
    }

    @WebMethod
    public Compromisso criarCompromisso(Compromisso compromisso) {
	System.out.println("criarCompromisso");
	return BancoDados.getInstance().setCompromisso(compromisso);
    }

    @WebMethod
    public Collection<Compromisso> getCompromissos() {
	System.out.println("getCompromissos");
	return BancoDados.getInstance().getCompromissos();
    }

    @WebMethod
    public Collection<Compromisso> getCompromissosAluno(long codigoAluno) {
	System.out.println("getCompromissosAluno");
	return BancoDados.getInstance().getCompromissos(codigoAluno);
    }

    @WebMethod
    public String getMaterial(String idMaterial) {
	System.out.println("getMaterial");
	return "http://ava.furb.br/ava/resources/tela_view.php?ds_diretorio=2666732&nm_arquivo=estados_UML.doc";
    }

    @WebMethod
    public Collection<Prova> getProvasAluno(int codigoAluno, int codigoTurma) throws Exception {
	System.out.println("getProvas");
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castProvas(academico.getProvas(codigoAluno, codigoTurma));
    }
    
    @WebMethod
    public Collection<Prova> getProvas() throws Exception {
	System.out.println("CentralAluno.getProvas()");
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castProvas(academico.getProvas());
    }

    @WebMethod
    public Collection<Matricula> getMatriculasAluno(int codigoAluno) throws Exception {
	System.out.println("getMatriculasAluno");
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castMatriculas(academico.getMatriculasAluno(codigoAluno));
    }

    @WebMethod
    public Collection<Matricula> getMatriculasTurma(int codigoTurma) throws Exception {
	System.out.println("getMatriculasTurma");
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castMatriculas(academico.getMatriculasTurma(codigoTurma));
    }

    @WebMethod
    public Collection<Horario> getHorarios(int codigoTurma) throws Exception {
	System.out.println("getHorarios");
	Academico academico = new Academico(Endereco.academico.getEndereco());
	return ConversorAcademico.castHorarios(academico.getHorarios(codigoTurma));
    }

    @WebMethod
    public List<Aluno> getAlunos() throws RemoteException {
	System.out.println("getAlunos");
	return Cadastro.getInstancia().getAlunos();
    }
    
    @WebMethod
    public Aluno getAluno(int codigoAluno) throws RemoteException {
	System.out.println("getAluno");
	return Cadastro.getInstancia().getAluno(codigoAluno);
    }

    @WebMethod
    public Curso getCurso(int codigoCurso) throws RemoteException {
	System.out.println("getCurso");
	return Cadastro.getInstancia().getCurso(codigoCurso);
    }

    @WebMethod
    public List<Disciplina> getDisciplinasCurso(int codigoCurso) throws RemoteException {
	System.out.println("CentralAluno.getDisciplinas()");
	return Cadastro.getInstancia().getDisciplinasCurso(codigoCurso);
    }
    
    @WebMethod
    public List<Disciplina> getDisciplinas() throws RemoteException {
	System.out.println("CentralAluno.getDisciplinas()");
	return Cadastro.getInstancia().getDisciplinas();
    }

    @WebMethod
    public List<Turma> getTurmas(int codigoAluno) throws RemoteException {
	System.out.println("getTurmas");
	return Cadastro.getInstancia().getTurmas(codigoAluno);
    }

    @WebMethod
    public List<Aluno> getAlunosTurma(int codigoTurma) throws RemoteException {
	System.out.println("getAlunosTurma");
	return Cadastro.getInstancia().getAlunosTurma(codigoTurma);
    }

    @WebMethod
    public List<Mensalidade> getMensalidadesPendentes(int codigoAluno) throws RemoteException {
	System.out.println("getMensalidadesPendentes");
	return Financeiro.getInstancia().getMensalidadesPendentes(codigoAluno);
    }

    @WebMethod
    public Aluno autenticaUsuario(String nomeUsuario, String senha) throws RemoteException {
	System.out.println("autenticaUsuario");
	Aluno aluno = Cadastro.getInstancia().getAlunoPorNomeUsuario(nomeUsuario);
	if (aluno != null && aluno.getSenha() == senha) {
	    return aluno;
	} else {
	    return null;
	}
    }
}
