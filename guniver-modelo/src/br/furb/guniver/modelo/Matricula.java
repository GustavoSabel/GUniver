package br.furb.guniver.modelo;

public final class Matricula {

    private Aluno aluno = null;
    private Turma turma = null;

    public Matricula() {
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
