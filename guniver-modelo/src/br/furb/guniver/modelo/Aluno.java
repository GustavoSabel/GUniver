package br.furb.guniver.modelo;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nomeUsuario;
    private String nome;
    private int codigo;
    private String senha;

    public Aluno() {
    }

    public Aluno(int codigo, String nomeUsuario) {
	this();
	this.codigo = codigo;
	this.nomeUsuario = nomeUsuario;
    }

    public Aluno(int codigo, String nomeUsuario, String senha) {
	this(codigo, nomeUsuario);
	this.senha = senha;
    }
    
    public Aluno(int codigo, String nomeUsuario, String senha, String nome) {
	this(codigo, nomeUsuario, senha);
	this.nome = nome;
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

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getNomeUsuario() {
	return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario = nomeUsuario;
    }

}
