
package br.furb.guniver.central_do_aluno.stubs;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CentralAluno", targetNamespace = "http://webservice.guniver.furb.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CentralAluno {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "removerCompromisso", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.RemoverCompromisso")
    @ResponseWrapper(localName = "removerCompromissoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.RemoverCompromissoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/removerCompromissoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/removerCompromissoResponse")
    public void removerCompromisso(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Compromisso>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompromissosAluno", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetCompromissosAluno")
    @ResponseWrapper(localName = "getCompromissosAlunoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetCompromissosAlunoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getCompromissosAlunoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getCompromissosAlunoResponse")
    public List<Compromisso> getCompromissosAluno(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Matricula>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMatriculasAluno", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMatriculasAluno")
    @ResponseWrapper(localName = "getMatriculasAlunoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMatriculasAlunoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getMatriculasAlunoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getMatriculasAlunoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.guniver.furb.br/CentralAluno/getMatriculasAluno/Fault/Exception")
    })
    public List<Matricula> getMatriculasAluno(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Matricula>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMatriculasTurma", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMatriculasTurma")
    @ResponseWrapper(localName = "getMatriculasTurmaResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMatriculasTurmaResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getMatriculasTurmaRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getMatriculasTurmaResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.guniver.furb.br/CentralAluno/getMatriculasTurma/Fault/Exception")
    })
    public List<Matricula> getMatriculasTurma(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Disciplina>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDisciplinasCurso", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetDisciplinasCurso")
    @ResponseWrapper(localName = "getDisciplinasCursoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetDisciplinasCursoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getDisciplinasCursoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getDisciplinasCursoResponse")
    public List<Disciplina> getDisciplinasCurso(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Mensalidade>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMensalidadesPendentes", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMensalidadesPendentes")
    @ResponseWrapper(localName = "getMensalidadesPendentesResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMensalidadesPendentesResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getMensalidadesPendentesRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getMensalidadesPendentesResponse")
    public List<Mensalidade> getMensalidadesPendentes(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cadastrarMatricula", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.CadastrarMatricula")
    @ResponseWrapper(localName = "cadastrarMatriculaResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.CadastrarMatriculaResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/cadastrarMatriculaRequest", output = "http://webservice.guniver.furb.br/CentralAluno/cadastrarMatriculaResponse")
    public int cadastrarMatricula(
        @WebParam(name = "arg0", targetNamespace = "")
        Matricula arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns br.furb.guniver.central_do_aluno.stubs.Compromisso
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "criarCompromisso", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.CriarCompromisso")
    @ResponseWrapper(localName = "criarCompromissoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.CriarCompromissoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/criarCompromissoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/criarCompromissoResponse")
    public Compromisso criarCompromisso(
        @WebParam(name = "arg0", targetNamespace = "")
        Compromisso arg0);

    /**
     * 
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Compromisso>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompromissos", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetCompromissos")
    @ResponseWrapper(localName = "getCompromissosResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetCompromissosResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getCompromissosRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getCompromissosResponse")
    public List<Compromisso> getCompromissos();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMaterial", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMaterial")
    @ResponseWrapper(localName = "getMaterialResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetMaterialResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getMaterialRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getMaterialResponse")
    public String getMaterial(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Prova>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProvasAluno", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetProvasAluno")
    @ResponseWrapper(localName = "getProvasAlunoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetProvasAlunoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getProvasAlunoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getProvasAlunoResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.guniver.furb.br/CentralAluno/getProvasAluno/Fault/Exception")
    })
    public List<Prova> getProvasAluno(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Prova>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProvas", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetProvas")
    @ResponseWrapper(localName = "getProvasResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetProvasResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getProvasRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getProvasResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.guniver.furb.br/CentralAluno/getProvas/Fault/Exception")
    })
    public List<Prova> getProvas()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Horario>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHorarios", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetHorarios")
    @ResponseWrapper(localName = "getHorariosResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetHorariosResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getHorariosRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getHorariosResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.guniver.furb.br/CentralAluno/getHorarios/Fault/Exception")
    })
    public List<Horario> getHorarios(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Aluno>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAlunos", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetAlunos")
    @ResponseWrapper(localName = "getAlunosResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetAlunosResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getAlunosRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getAlunosResponse")
    public List<Aluno> getAlunos();

    /**
     * 
     * @param arg0
     * @return
     *     returns br.furb.guniver.central_do_aluno.stubs.Aluno
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAluno", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetAluno")
    @ResponseWrapper(localName = "getAlunoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetAlunoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getAlunoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getAlunoResponse")
    public Aluno getAluno(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns br.furb.guniver.central_do_aluno.stubs.Curso
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurso", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetCurso")
    @ResponseWrapper(localName = "getCursoResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetCursoResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getCursoRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getCursoResponse")
    public Curso getCurso(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Disciplina>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDisciplinas", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetDisciplinas")
    @ResponseWrapper(localName = "getDisciplinasResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetDisciplinasResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getDisciplinasRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getDisciplinasResponse")
    public List<Disciplina> getDisciplinas();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Turma>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTurmas", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetTurmas")
    @ResponseWrapper(localName = "getTurmasResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetTurmasResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getTurmasRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getTurmasResponse")
    public List<Turma> getTurmas(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.furb.guniver.central_do_aluno.stubs.Aluno>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAlunosTurma", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetAlunosTurma")
    @ResponseWrapper(localName = "getAlunosTurmaResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.GetAlunosTurmaResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/getAlunosTurmaRequest", output = "http://webservice.guniver.furb.br/CentralAluno/getAlunosTurmaResponse")
    public List<Aluno> getAlunosTurma(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns br.furb.guniver.central_do_aluno.stubs.Aluno
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "autenticaUsuario", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.AutenticaUsuario")
    @ResponseWrapper(localName = "autenticaUsuarioResponse", targetNamespace = "http://webservice.guniver.furb.br/", className = "br.furb.guniver.central_do_aluno.stubs.AutenticaUsuarioResponse")
    @Action(input = "http://webservice.guniver.furb.br/CentralAluno/autenticaUsuarioRequest", output = "http://webservice.guniver.furb.br/CentralAluno/autenticaUsuarioResponse")
    public Aluno autenticaUsuario(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
