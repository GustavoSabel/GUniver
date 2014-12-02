package br.furb.guniver.modelo;

import java.io.Serializable;

public final class Matricula implements Serializable {

    private Aluno aluno = null;
    private Turma turma = null;

    public Matricula() {
    }

    
    public Matricula(Aluno aluno, Turma turma) {
	this.aluno = aluno;
	this.turma = turma;
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

}
