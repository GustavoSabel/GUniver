package rmi_guniver;

import java.io.Serializable;

public class Aluno implements Serializable {
	private String nome;
	private int codigo;

	public Aluno(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Aluno() {
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
