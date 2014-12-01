package endereco;

public enum Endereco {
    academico("localhost");

    private String endereco;

    private Endereco(String endereco) {
	this.endereco = endereco;
    }

    public String getEndereco() {
	return endereco;
    }

}
