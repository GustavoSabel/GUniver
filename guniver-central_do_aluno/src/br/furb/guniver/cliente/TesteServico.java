package br.furb.guniver.cliente;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import br.furb.guniver.cliente.stubs.CentralAluno;
import br.furb.guniver.cliente.stubs.CentralAlunoService;
import br.furb.guniver.cliente.stubs.Compromisso;
import br.furb.guniver.cliente.stubs.Matricula;
import br.furb.guniver.cliente.stubs.Prova;

public class TesteServico {

    public static void main(String[] args) {
	try {
	    TestarCentralAluno();
	    TestarIntegracaoAcademico();
	    TestarIntegracaoCadastro();
	    TestarIntegracaoFinanceiro();

	} catch (Exception ex) {
	    System.out.println("Erro: " + ex.getMessage());
	}
    }

    private static void TestarCentralAluno() {
	try {
	    System.out.println("TESTANDO MODULO CENTRAL DO ALUNO");
	    CentralAluno port = new CentralAlunoService().getCentralAlunoPort();
	    Compromisso compromisso = new Compromisso();

	    compromisso.setCodigoAluno(2);
	    compromisso.setTitulo("Novo ;compromisso");
	    compromisso.setDescricao("Descricao do Novo compromisso");

	    Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.HOUR, 10);

	    compromisso.setDataInicio(dateToXMLGregorianCalendar(calendar.getTime()));

	    calendar.add(Calendar.HOUR, 24);
	    compromisso.setDataFim(dateToXMLGregorianCalendar(calendar.getTime()));

	    compromisso = port.criarCompromisso(compromisso);
	    System.out.println("Cadastrado o compromisso " + compromisso.getCodigo());

	    compromisso = port.criarCompromisso(compromisso);
	    System.out.println("Cadastrado o compromisso " + compromisso.getCodigo());

	    compromisso.setCodigoAluno(1);
	    compromisso = port.criarCompromisso(compromisso);
	    System.out.println("Cadastrado o compromisso " + compromisso.getCodigo());

	    List<Compromisso> compromissos = port.getCompromissosAluno(1);
	    System.out.println("Todos compromissos cadastrados para o aluno 1:");
	    for (Compromisso compromisso2 : compromissos) {
		System.out.println(" - " + compromisso2.getCodigo() + " - " + compromisso2.getTitulo());
	    }

	    compromissos = port.getCompromissos();
	    System.out.println("Todos compromissos cadastrados:");
	    for (Compromisso compromisso2 : compromissos) {
		System.out.println(" - " + compromisso2.getCodigo() + " - " + compromisso2.getTitulo());
	    }

	    port.removerCompromisso((int) compromisso.getCodigo());
	    System.out.println("Remover o compromisso " + compromisso.getCodigo());

	    compromissos = port.getCompromissos();
	    System.out.println("Todos compromissos cadastrados:");
	    for (Compromisso compromisso2 : compromissos) {
		System.out.println(" - " + compromisso2.getCodigo() + " - " + compromisso2.getTitulo());
	    }

	    // String url = port.getMaterial("N serve pá nada");
	    // System.out.println("URL do material: " + url);
	} catch (Exception ex) {
	    System.out.println("Erro em TestarCentralAluno:\r\n" + ex.getMessage());
	}
    }

    private static void TestarIntegracaoCadastro() {
	try {
	    System.out.println("TESTANDO INTEGRAÇÃO COM O MODULO CADASTRO");
	    CentralAluno port = new CentralAlunoService().getCentralAlunoPort();
	    port.getAlunos();
	    System.out.println("Consultou Alunos");
	    port.getCurso(1);
	    System.out.println("Consultou Curso");
	    port.getDisciplinasCurso(1);
	    System.out.println("Consultou Disciplinas");
	    port.getTurmas();
	    System.out.println("Consultou Turmas");
	    br.furb.guniver.cliente.stubs.Aluno aluno = port.autenticaUsuario("Teste", "1234");
	    if (aluno == null)
		System.out.println("Usuario teste nao autenticado");
	    else
		System.out.println("Usuario teste autenticado");
	} catch (Exception ex) {
	    System.out.println("Erro em TestarIntegracaoCadastro:\r\n" + ex.getMessage());
	}
    }

    private static void TestarIntegracaoFinanceiro() {
	try {
	    System.out.println("TESTANDO INTEGRAÇÃO COM O MODULO FINANCEIRO");
	    CentralAluno port = new CentralAlunoService().getCentralAlunoPort();
	    int codigoALuno = 1;
	    port.getMensalidadesPendentes(codigoALuno);
	    System.out.println("Consultou as Mensalidades do aluno 1");
	} catch (Exception ex) {
	    System.out.println("Erro em TestarIntegracaoFinanceiro:\r\n" + ex.getMessage());
	}
    }

    public static void TestarIntegracaoAcademico() {
	try {
	    System.out.println("TESTANDO INTEGRAÇÃO COM O MODULO ACADEMICO");

	    CentralAluno port = new CentralAlunoService().getCentralAlunoPort();
	    List<Matricula> matriculas = port.getMatriculasAluno(1);
	    System.out.println("Matriculas do aluno 1:");
	    for (Matricula matricula : matriculas) {
		System.out.println(" - Aluno: " + matricula.getAluno().getNome() + " - Semestre:"
			+ matricula.getTurma().getAno() + "\\" + matricula.getTurma().getSemestre() + " - "
			+ "Disciplina: " + matricula.getTurma().getDisciplina().getNome());
	    }

	    matriculas = port.getMatriculasTurma(1);
	    System.out.println("Matriculas da turma 1:");
	    for (Matricula matricula : matriculas) {
		System.out.println(" - Aluno: " + matricula.getAluno().getNome() + " - Semestre:"
			+ matricula.getTurma().getAno() + "\\" + matricula.getTurma().getSemestre() + " - "
			+ "Disciplina: " + matricula.getTurma().getDisciplina().getNome());
	    }

	    List<Prova> provas = port.getProvas();
	    System.out.println("Todas as provas:");
	    for (Prova prova : provas) {
		System.out.println(" - Nome Prova: " + prova.getDescricao() + " - Nota:" + prova.getNota()
			+ " - Aluno:" + prova.getAluno().getNome());
	    }

	} catch (Exception ex) {
	    System.out.println("Erro: " + ex.getMessage());
	}
    }

    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
	GregorianCalendar gregorianCalendar = new GregorianCalendar();
	gregorianCalendar.setTime(date);
	XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(
		gregorianCalendar);
	return xmlGregorianCalendar;
    }
}
