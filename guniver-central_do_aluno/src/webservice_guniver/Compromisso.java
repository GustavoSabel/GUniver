package webservice_guniver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compromisso {

    private long codigo;
    private String titulo;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private boolean isDiaTodo;
    private List<Integer> lembretes;
    private long codigoAluno;

    public Compromisso() {
	this.lembretes = new ArrayList<>();
    }

    public long getCodigo() {
	return codigo;
    }

    public void setCodigo(long codigo) {
	this.codigo = codigo;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Date getDataInicio() {
	return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
	return dataFim;
    }

    public void setDataFim(Date dataFim) {
	this.dataFim = dataFim;
    }

    public boolean isDiaTodo() {
	return isDiaTodo;
    }

    public void setDiaTodo(boolean isDiaTodo) {
	this.isDiaTodo = isDiaTodo;
    }

    public void addLembrete(Integer minutosAntecedencia) {
	this.lembretes.add(minutosAntecedencia);
    }

    public List<Integer> getLembretes() {
	return lembretes;
    }

    public void setLembretes(List<Integer> lembretes) {
	this.lembretes = lembretes;
    }

    public long getCodigoAluno() {
	return codigoAluno;
    }

    public void setCodigoAluno(long codigoAluno) {
	this.codigoAluno = codigoAluno;
    }

}
