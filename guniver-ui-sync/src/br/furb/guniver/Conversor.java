package br.furb.guniver;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.Disciplina;
import br.furb.guniver.central_do_aluno.stubs.Turma;

public class Conversor {

    public static br.furb.guniver.modelo.Aluno cast(Aluno aluno) {
	return new br.furb.guniver.modelo.Aluno(aluno.getCodigo(), aluno.getNomeUsuario(), aluno.getSenha(),
		aluno.getNome());
    }

    public static Disciplina cast(br.furb.guniver.modelo.Disciplina disciplina) {
	// TODO Auto-generated method stub
	return null;
    }

    public static Turma cast(br.furb.guniver.modelo.Turma turmaWS) {
	Turma turma = new Turma();
	turma.setAno(turmaWS.getAno());
	turma.setCodigo(turmaWS.getCodigo());
	turma.setSemestre(turmaWS.getSemestre());

	turma.setDisciplina(Conversor.cast(turmaWS.getDisciplina()));
	return turma;
    }
}
