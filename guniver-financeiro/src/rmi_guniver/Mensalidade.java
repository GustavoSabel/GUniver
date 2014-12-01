package rmi_guniver;

import java.io.Serializable;
import java.util.Date;

public class Mensalidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codito;
    private String descricao;
    private double valor;
    private Date data;
    private int codigoAluno;
    private Situacao situacao;

    public Situacao getSituacao() {
	return situacao;
    }

    public void setSituacao(Situacao situacao) {
	this.situacao = situacao;
    }

    public int getCodito() {
	return codito;
    }

    public void setCodito(int codito) {
	this.codito = codito;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public double getValor() {
	return valor;
    }

    public void setValor(double valor) {
	this.valor = valor;
    }

    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    public int getCodigoAluno() {
	return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
	this.codigoAluno = codigoAluno;
    }

}
