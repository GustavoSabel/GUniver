package br.furb.guniver.utils;

import br.furb.guniver.modelo.academico.*;

public class ConversorAcademico {

    public static Prova cast(br.furb.guniver.central_do_aluno.stubs.Prova prova) {
	if (prova == null)
	    return new br.furb.guniver.modelo.academico.Prova("", new Aluno(0, ""), new Turma(0, (short)0, (short)0, new Disciplina(0, "")), 0);
	
	return new br.furb.guniver.modelo.academico.Prova(prova.getDescricao(), ConversorAcademico.cast(prova
		.getAluno()), ConversorAcademico.cast(prova.getTurma()), prova.getNota());
    }

    private static Turma cast(br.furb.guniver.central_do_aluno.stubs.Turma turma) {
	if (turma == null)
	    return new Turma(0, (short)0, (short)0, new Disciplina(0, ""));
	    
	return new Turma(turma.getCodigo(), (short) turma.getAno(), (short) turma.getSemestre(),
		ConversorAcademico.cast(turma.getDisciplina()));
    }

    private static Disciplina cast(br.furb.guniver.central_do_aluno.stubs.Disciplina disciplina) {
	if (disciplina == null)
	    return new Disciplina(0, "");

	return new Disciplina(disciplina.getCodigo(), disciplina.getNome());
    }

    private static Aluno cast(br.furb.guniver.central_do_aluno.stubs.Aluno aluno) {
	if (aluno == null)
	    return new Aluno(0, "");

	return new Aluno(aluno.getCodigo(), aluno.getNome());
    }

}
