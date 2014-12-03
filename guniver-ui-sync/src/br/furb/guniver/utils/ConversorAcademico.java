package br.furb.guniver.utils;

import br.furb.guniver.modelo.academico.Prova;

public class ConversorAcademico {
    public static br.furb.guniver.modelo.academico.Prova cast(br.furb.guniver.central_do_aluno.stubs.Prova entity) {
	int codAluno = entity.getAluno() == null ? 0 : entity.getAluno().getCodigo();
	int codTurma = entity.getTurma() == null ? 0 : entity.getTurma().getCodigo();
	String descricaoProva = entity.getDescricao() == null ? "" : entity.getDescricao();
	return new Prova(entity.getCodigo(), descricaoProva, codAluno, codTurma, entity.getNota());
    }
}
