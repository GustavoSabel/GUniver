package br.furb.guniver.rmi;

import java.util.ArrayList;
import java.util.List;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Curso;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Turma;

public class BancoDados {

    private List<Aluno> alunos;
    private List<Turma> turmas;
    private List<Disciplina> disciplina;
    private List<Curso> curso;
    private static BancoDados instacia;

    private BancoDados() {
	alunos = new ArrayList<>();
	turmas = new ArrayList<>();
	disciplina = new ArrayList<>();
	curso = new ArrayList<>();
	//CargaInicial();
    }

    public static BancoDados getIntancia() {
	if (instacia == null)
	    instacia = new BancoDados();
	return instacia;
    }

    private void cargaInicial() {
	Curso curso = new Curso(1, "Ciencia da Computacao");
	Disciplina disc = new Disciplina(1, "Banco de Dados", curso);
	Aluno alunoGustavo = new Aluno(1, "Gustavo Sabel");
	alunos.add(alunoGustavo);
	Turma turmaTeste = new Turma(1, disc, 2014, 2);
	turmas.add(turmaTeste);
    }

    public List<Aluno> getAlunos() {
	return alunos;
    }

    public Aluno getAluno(int codigoAluno) {
	for (Aluno aluno : alunos) {
	    if(aluno.getCodigo() == codigoAluno)
		return aluno;
	}
	return null;
    }
    
    public Turma getTurma(int codigoTurma) {
	for (Turma turma : turmas) {
	    if(turma.getCodigo() == codigoTurma)
		return turma;
	}
	return null;
    }

    public List<Turma> getTurmas() {
	return turmas;
    }

    public List<Disciplina> getDisciplina() {
	return disciplina;
    }

    public List<Curso> getCurso() {
	return curso;
    }

}
