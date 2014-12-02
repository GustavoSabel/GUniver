package br.furb.guniver.modelo.endereco;

public enum Endereco {
    /*academico("MC-4380"),
    cadastro("MC-4380"),
    financeiro("MC-4373");*/

    academico("localhost"),
    cadastro("localhost"),
    financeiro("localhost");
	
    private String endereco;

    private Endereco(String endereco) {
	this.endereco = endereco;
    }

    public String getEndereco() {
	return endereco;
    }
}
