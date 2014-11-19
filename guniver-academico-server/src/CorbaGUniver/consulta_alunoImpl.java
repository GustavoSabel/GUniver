package CorbaGUniver;

import java.util.List;

import org.omg.CORBA.StringHolder;

import academico.Aluno;
import academico.Disciplina;
import academico.DisciplinaHolder;
import academico.IAcademicoPOA;
import academico.Matricula;
import academico.Ocorrencia;
import academico.Prova;
import academico.Turma;

class consulta_alunoImpl extends IAcademicoPOA {

	@Override
	public float[] getNotasAluno(Aluno aluno, Turma turma) {
		List<Prova> provas = BancoDados.getInstance().getProvasAluno(aluno,
				turma);
		float[] notas = new float[provas.size()];
		for (int i = 0; i < provas.size(); i++) {
			notas[i] = provas.get(i).nota;
		}
		return notas;
	}

	@Override
	public Ocorrencia[] getOcorrencias(Aluno aluno) {
		System.out.println("getOcorrencias");
		return new Ocorrencia[] { new Ocorrencia("Sei lá :D") };
	}

	@Override
	public Matricula getMatricula(Aluno aluno, Disciplina disciplina) {
		System.out.println("getMatricula");
		return new Matricula(new Aluno(1, "a"), new Turma(1, "x", (short) 2014,
				(short) 1, new Disciplina(10, "Sistemas Distribuidos")));
	}

	@Override
	public Matricula[] getMatriculas(Aluno aluno) {
		System.out.println("getMatriculas");
		return new Matricula[] { new Matricula(new Aluno(1, "a"), new Turma(1,
				"x", (short) 2014, (short) 1, new Disciplina(10,
						"Sistemas Distribuidos"))) };
	}

	@Override
	public boolean matricular(Aluno aluno, Turma turma,
			StringHolder mensagemErro) {
		for (Matricula matricula : BancoDados.getInstance().matriculas) {
			if (matricula.turma.codigo == turma.codigo
					&& matricula.aluno.codigo == aluno.codigo) {
				mensagemErro.value = "Aluno já foi matriculado para esta turma.";
				return false;
			}
		}
		BancoDados.getInstance().matriculas.add(new Matricula(aluno, turma));
		return true;
	}

	@Override
	public boolean cadastrarTurma(Turma turma, StringHolder mensagemErro) {
		for (Turma turmaCadastrada : BancoDados.getInstance().turmas) {
			if (turmaCadastrada.ano == turma.ano
					&& turmaCadastrada.semestre == turma.semestre
					&& turmaCadastrada.codigo == turma.codigo) {
				mensagemErro.value = "Turma já cadastrada";
				return false;
			}
		}
		BancoDados.getInstance().turmas.add(turma);
		return true;
	}

	@Override
	public boolean cadastrarDisciplina(Disciplina disciplina,
			StringHolder mensagemErro) {

		for (Disciplina disci : BancoDados.getInstance().disciplinas) {
			if (disci.codigo == disciplina.codigo) {
				mensagemErro.value = "Disciplina já cadastrada com o código "
						+ disciplina.codigo;
				return false;
			}
		}

		BancoDados.getInstance().disciplinas.add(disciplina);
		return true;
	}

	@Override
	public boolean cadastrarProva(Prova prova, StringHolder mensagemErro) {
		BancoDados.getInstance().provas.add(prova);
		return true;
	}

	@Override
	public boolean getDisciplina(int codigo, DisciplinaHolder disciplina) {
		for (Disciplina disc : BancoDados.getInstance().disciplinas) {
			if (disc.codigo == codigo) {
				disciplina.value = disc;
				return true;
			}
		}
		disciplina.value = new Disciplina(0, "");
		return false;
	}

	@Override
	public Disciplina[] getDisciplinas() {
		Disciplina[] disciplinas = new Disciplina[BancoDados.getInstance().disciplinas.size()];
		disciplinas = BancoDados.getInstance().disciplinas.toArray(disciplinas);
		return disciplinas;
	}

}