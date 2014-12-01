package modulo.cadastro;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Disciplina implements Serializable {

	private int codigo;
	private String nome;
	private Curso curso;

	public Disciplina(int codigo, String nome, Curso curso) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.curso = curso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
