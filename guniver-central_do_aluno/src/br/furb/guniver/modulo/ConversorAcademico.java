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
	return new Prova(prova.descricao, ConversorAcademico.cast(prova.aluno), ConversorAcademico.cast(prova.turma),
		prova.nota);
    }

    private static Turma cast(br.furb.guniver.modelo.academico.Turma turma) {
	return new Turma(turma.codigo, ConversorAcademico.cast(turma.disciplina), turma.ano, turma.semestre);
    }

    private static Disciplina cast(br.furb.guniver.modelo.academico.Disciplina disciplina) {
	return new Disciplina(disciplina.codigo, disciplina.nome, null);
	//TODO: Verifica onde pegar a Turma
    }

    private static Aluno cast(br.furb.guniver.modelo.academico.Aluno aluno) {
	return new Aluno(aluno.codigo, aluno.nome);
    }

    private static Matricula cast(br.furb.guniver.modelo.academico.Matricula matricula) {
	return new Matricula(ConversorAcademico.cast(matricula.aluno), ConversorAcademico.cast(matricula.turma));
    }

    private static Horario cast(br.furb.guniver.modelo.academico.Horario horario) {
	return new Horario(horario.horario, horario.sala);
    }
}
