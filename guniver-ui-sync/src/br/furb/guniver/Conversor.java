package br.furb.guniver;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.Disciplina;
import br.furb.guniver.central_do_aluno.stubs.Turma;
import br.furb.guniver.modelo.Curso;

public class Conversor {

	public static br.furb.guniver.modelo.Aluno cast(Aluno aluno) {
		return new br.furb.guniver.modelo.Aluno(aluno.getCodigo(),
				aluno.getNomeUsuario(), aluno.getSenha(), aluno.getNome());
	}

	public static br.furb.guniver.modelo.Turma cast(Turma entity) {
		if (entity == null)
			return null;

		br.furb.guniver.modelo.Turma turma = new br.furb.guniver.modelo.Turma(
				entity.getCodigo(), Conversor.cast(entity.getDisciplina()),
				entity.getAno(), entity.getSemestre());
		return turma;
	}

	public static br.furb.guniver.modelo.Disciplina cast(Disciplina disciplina) {
		if (disciplina == null)
			return null;

		br.furb.guniver.modelo.Disciplina disc = new br.furb.guniver.modelo.Disciplina(
				disciplina.getCodigo(), disciplina.getNome(),
				Conversor.cast(disciplina.getCurso()));

		return disc;
	}

	public static Curso cast(br.furb.guniver.central_do_aluno.stubs.Curso curso) {
		if (curso == null)
			return null;
		return new Curso(curso.getCodigo(), curso.getDescricao());
	}
}
