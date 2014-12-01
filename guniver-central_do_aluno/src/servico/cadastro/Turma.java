package servico.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {

	private int codigo;
	private Disciplina disciplina;
	private int ano;
	private int semestre;
	//private List<Aluno> alunos;

	public Turma(int codigo, Disciplina disciplina, int ano, int semestre) {
		this.codigo = codigo;
		this.disciplina = disciplina;
		this.ano = ano;
		this.semestre = semestre;
		//alunos = new ArrayList<Aluno>();
	}

	/*public void addAluno(Aluno aluno) {
		if(!alunos.contains(aluno)){
			alunos.add(aluno);
		}
	}
*/
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
/*
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
*/
}
