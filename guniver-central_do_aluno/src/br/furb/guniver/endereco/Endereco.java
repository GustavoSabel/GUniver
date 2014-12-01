package br.furb.guniver.endereco;

public enum Endereco {
    academico("localhost"),
    cadastro("localhost");

    private String endereco;

    private Endereco(String endereco) {
	this.endereco = endereco;
    }

    public String getEndereco() {
	return endereco;
    }

}
