package endereco;

public enum Endereco {
    cadastro("localhost");

    private String endereco;

    private Endereco(String endereco) {
	this.endereco = endereco;
    }

    public String getEndereco() {
	return endereco;
    }

}
