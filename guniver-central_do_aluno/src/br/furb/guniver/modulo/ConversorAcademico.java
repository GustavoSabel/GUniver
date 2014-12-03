package br.furb.guniver.modulo;

import java.util.ArrayList;
import java.util.Collection;
import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Horario;
import br.furb.guniver.modelo.Matricula;
import br.furb.guniver.modelo.Prova;
import br.furb.guniver.modelo.Turma;

public class ConversorAcademico {

    public static Collection<Prova> castProvas(Collection<br.furb.guniver.modelo.academico.Prova> provas) {
	Collection<Prova> provasCast = new ArrayList<Prova>();
	for (br.furb.guniver.modelo.academico.Prova prova : provas) {
	    provasCast.add(ConversorAcademico.cast(prova));
	}
	return provasCast;
    }

    public static Collection<Matricula> castMatriculas(
	    Collection<br.furb.guniver.modelo.academico.Matricula> matriculasAluno) {
	Collection<Matricula> matriculasCast = new ArrayList<Matricula>();

	for (br.furb.guniver.modelo.academico.Matricula matricula : matriculasAluno) {
	    matriculasCast.add(ConversorAcademico.cast(matricula));
	}

	return matriculasCast;
    }

    public static Collection<Horario> castHorarios(Collection<br.furb.guniver.modelo.academico.Horario> horarios) {

	Collection<Horario> horariosCast = new ArrayList<Horario>();

	for (br.furb.guniver.modelo.academico.Horario horario : horarios) {
	    horariosCast.add(ConversorAcademico.cast(horario));
	}

	return horariosCast;
    }

    public static Prova cast(br.furb.guniver.modelo.academico.Prova prova) {
	return new Prova(prova.descricao, new Aluno(prova.codigoAluno), new Turma(prova.codigoTurma), prova.nota);
    }

    private static Matricula cast(br.furb.guniver.modelo.academico.Matricula matricula) {
	return new Matricula(new Aluno(matricula.codigoAluno), new Turma(matricula.codigoTurma));
    }

    private static Horario cast(br.furb.guniver.modelo.academico.Horario horario) {
	return new Horario(horario.horario, horario.sala);
    }
}
