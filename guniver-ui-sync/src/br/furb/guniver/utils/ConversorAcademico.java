package br.furb.guniver.utils;

import br.furb.guniver.modelo.academico.Prova;

public class ConversorAcademico {

    public static br.furb.guniver.modelo.academico.Prova cast(br.furb.guniver.central_do_aluno.stubs.Prova entity) {
	return new Prova(entity.getDescricao(), entity.getAluno().getCodigo(), entity.getTurma().getCodigo(),
		entity.getNota());
    }

}
