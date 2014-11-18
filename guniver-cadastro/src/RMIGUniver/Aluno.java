package RMIGUniver;

public class Aluno {
	private String nome;
	private int codigo;

	public Aluno(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
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
