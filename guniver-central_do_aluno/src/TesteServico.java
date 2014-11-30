import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import pacote.cliente.CentralAluno;
import pacote.cliente.CentralAlunoService;
import pacote.cliente.Compromisso;

public class TesteServico {

    public static void main(String[] args) {
	try {
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
	    
	    port.removerCompromisso((int)compromisso.getCodigo());
	    System.out.println("Remover o compromisso " + compromisso.getCodigo());

	    compromissos = port.getCompromissos();
	    System.out.println("Todos compromissos cadastrados:");
	    for (Compromisso compromisso2 : compromissos) {
		System.out.println(" - " + compromisso2.getCodigo() + " - " + compromisso2.getTitulo());
	    }
	    
	    String url = port.getMaterial("N serve pá nada");
	    System.out.println("URL do material: " + url);
	    
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
