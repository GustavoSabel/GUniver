package br.furb.guniver.modelo;

public class Curso {

    private int codigo;
    private String descricao;

    public Curso(int codigo, String descricao) {
	super();
	this.codigo = codigo;
	this.descricao = descricao;
    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

}
