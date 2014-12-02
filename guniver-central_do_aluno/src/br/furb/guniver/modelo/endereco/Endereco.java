package br.furb.guniver.modelo.endereco;

public enum Endereco {
    academico("MC-3364"),
    cadastro("MC-3364"),
    financeiro("MC-3364");
/*
    academico("localhost"),
    cadastro("localhost"),
    financeiro("localhost");
	*/
    private String endereco;

    private Endereco(String endereco) {
	this.endereco = endereco;
    }

    public String getEndereco() {
	return endereco;
    }
}
