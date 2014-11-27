package rmi_guniver;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {

    public List<Aluno> alunos;
    public List<Disciplina> disciplinas;
    public List<Turma> turmas;
    private static BancoDados instacia;

    private BancoDados() {
	alunos = new ArrayList<>();
	disciplinas = new ArrayList<>();
	turmas = new ArrayList<>();
	//CargaInicial();
    }

    public static BancoDados getIntancia() {
	if (instacia == null)
	    instacia = new BancoDados();
	return instacia;
    }

    private void CargaInicial() {
	Aluno alunoGustavo = new Aluno(1, "Gustavo Sabel");
	alunos.add(alunoGustavo);
	
	Disciplina disciplinaSD = new Disciplina(1, "Sistemas Distribuidos");
	Disciplina disciplinaPS = new Disciplina(2, "Processo de Software");
	Turma turmaA = new Turma(1, "A", (short) 2014, (short) 1, disciplinaSD);
	Turma turmaB = new Turma(2, "A", (short) 2014, (short) 1, disciplinaPS);
	disciplinas.add(disciplinaSD);
	disciplinas.add(disciplinaPS);
	alunos.add(alunoGustavo);
	turmas.add(turmaA);
    }
}
