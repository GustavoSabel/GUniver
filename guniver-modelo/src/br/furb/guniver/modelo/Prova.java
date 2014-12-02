package br.furb.guniver.modelo;

import java.io.Serializable;

public final class Prova  implements Serializable{

    private String descricao;
    private Aluno aluno;
    private Turma turma;
    private float nota;

    public Prova() {
    }

    public Prova(String _descricao, Aluno _aluno, Turma _turma, float _nota) {
	descricao = _descricao;
	aluno = _aluno;
	turma = _turma;
	nota = _nota;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Aluno getAluno() {
	return aluno;
    }

    public void setAluno(Aluno aluno) {
	this.aluno = aluno;
    }

    public Turma getTurma() {
	return turma;
    }

    public void setTurma(Turma turma) {
	this.turma = turma;
    }

    public float getNota() {
	return nota;
    }

    public void setNota(float nota) {
	this.nota = nota;
    }

}
