package rmi_guniver;

import java.io.Serializable;

public final class Turma implements Serializable {

    private static final long serialVersionUID = 3L;
    public int codigo;
    public String nome;
    public short ano;
    public short semestre;
    public Disciplina disciplina;

    public Turma() {
    }

    public Turma(int _codigo, String _nome, short _ano, short _semestre, Disciplina _disciplina) {
	this.codigo = _codigo;
	this.nome = _nome;
	this.ano = _ano;
	this.semestre = _semestre;
	this.disciplina = _disciplina;
    }
}
