package rmi_guniver;

import java.io.Serializable;

public final class Disciplina implements Serializable {

    private static final long serialVersionUID = 2L;

    public int codigo;
    public String nome;

    public Disciplina() {
    }

    public Disciplina(int _codigo, String _nome) {
	this.codigo = _codigo;
	this.nome = _nome;
    }

}
