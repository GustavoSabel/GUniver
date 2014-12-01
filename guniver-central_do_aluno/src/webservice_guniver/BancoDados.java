package webservice_guniver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import webservice_guniver.model.Compromisso;

public class BancoDados {

    private Collection<Compromisso> compromissos;
    private long idUltimoCompromisso = 1;

    private static BancoDados instancia;

    private BancoDados() {
	compromissos = new ArrayList<>();
	CargaInicial();
    }

    public static BancoDados getInstance() {
	if (instancia == null)
	    instancia = new BancoDados();
	return instancia;
    }

    public Compromisso setCompromisso(Compromisso c) {
	c.setCodigo(idUltimoCompromisso++);
	this.compromissos.add(c);

	return c;
    }

    public Collection<Compromisso> getCompromissos() {
	return this.compromissos;
    }

    public Collection<Compromisso> getCompromissos(long codigoAluno) {
	Collection<Compromisso> compromissos = new ArrayList<Compromisso>();
	for (Compromisso compromisso : this.compromissos) {
	    if (compromisso.getCodigoAluno() == codigoAluno)
		compromissos.add(compromisso);
	}
	return compromissos;
    }

    private void CargaInicial() {
	Compromisso c = new Compromisso();
	c.setTitulo("Titulo compromisso");
	c.setDescricao("Descricao compromisso");
	c.setCodigo(1);
	c.setDiaTodo(false);
	c.setDataInicio(Calendar.getInstance().getTime());
	c.setDataFim(Calendar.getInstance().getTime());
	compromissos.add(c);
    }

    public void deleteCompromisso(long codigoCompromisso) {
	for (Compromisso compromisso : this.compromissos) {
	    if (compromisso.getCodigo() == codigoCompromisso) {
		this.compromissos.remove(compromisso);
		break;
	    }
	}
    }
}
