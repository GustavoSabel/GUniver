package br.furb.guniver;

import java.util.ArrayList;
import java.util.Collection;
import br.furb.guniver.central_do_aluno.stubs.Aluno;

public class Conversor {

    public static br.furb.guniver.modelo.Aluno cast(Aluno aluno) {
	return new br.furb.guniver.modelo.Aluno(aluno.getCodigo(), aluno.getNomeUsuario(), aluno.getSenha(),
		aluno.getNome());
    }
}
