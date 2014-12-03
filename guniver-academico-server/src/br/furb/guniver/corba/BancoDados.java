package br.furb.guniver.corba;

import java.util.ArrayList;
import java.util.List;
import br.furb.guniver.modelo.academico.Matricula;
import br.furb.guniver.modelo.academico.Prova;

public class BancoDados {

    //public List<Aluno> alunos;
    //public List<Disciplina> disciplinas;
    //public List<Turma> turmas;
    public List<Prova> provas;
    public List<Matricula> matriculas;
    private static BancoDados instancia;

    private BancoDados() {
	//disciplinas = new ArrayList<>();
	//turmas = new ArrayList<>();
	provas = new ArrayList<>();
	matriculas = new ArrayList<>();
	CargaInicial();
    }

    public static BancoDados getInstance() {
	if (instancia == null)
	    instancia = new BancoDados();
	return instancia;
    }

    private void CargaInicial() {
	matriculas.add(new Matricula(1, 1));
	matriculas.add(new Matricula(1, 2));
	provas.add(new Prova("Prova A", 1, 1, 7.5f));
	provas.add(new Prova("Prova B", 1, 1, 9.25f));
	provas.add(new Prova("Prova C", 1, 1, 5.0f));
	provas.add(new Prova("Prova A", 1, 2, 6.0f));
	provas.add(new Prova("Prova B", 2, 2, 8.0f));
    }
}
