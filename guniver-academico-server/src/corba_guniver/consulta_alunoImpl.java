package corba_guniver;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.StringHolder;

import academico.Aluno;
import academico.Disciplina;
import academico.DisciplinaHolder;
import academico.IAcademicoPOA;
import academico.Matricula;
import academico.Prova;
import academico.Turma;

class consulta_alunoImpl extends IAcademicoPOA {

	@Override
	public float[] getNotasAluno(Aluno aluno, Turma turma) {

		List<Prova> provasAluno = new ArrayList<>();
		for (Prova prova : BancoDados.getInstance().provas) {
			if (prova.aluno.codigo == aluno.codigo) {
				if (prova.turma.codigo == turma.codigo) {
					provasAluno.add(prova);
				}
			}
		}

		float[] notas = new float[provasAluno.size()];

		for (int i = 0; i < provasAluno.size(); i++) {
			notas[i] = provasAluno.get(i).nota;
		}
		return notas;
	}

	@Override
	public Matricula getMatricula(Aluno aluno, Disciplina disciplina) {

		// Não pode retornal NULL se não encontrar a matricula
		Matricula matriculaDisci = new Matricula(new Aluno(0, ""), new Turma(0,
				"", (short) 0, (short) 0, new Disciplina(0, "")));

		for (Matricula matricula : BancoDados.getInstance().matriculas) {
			if (matricula.aluno.codigo == aluno.codigo) {
				if (matricula.turma.disciplina.codigo == disciplina.codigo) {
					matriculaDisci = matricula;
					break;
				}
			}
		}
		
		return matriculaDisci;
	}

	@Override
	public Matricula[] getMatriculas(Aluno aluno) {
		Matricula[] mats = new Matricula[BancoDados.getInstance().matriculas
				.size()];
		mats = BancoDados.getInstance().matriculas.toArray(mats);
		return mats;
	}

	@Override
	public Matricula[] getMatriculasSemestre(Aluno aluno, short ano,
			short semestre) {
		List<Matricula> matriculasSemestre = new ArrayList<>();
		for (Matricula matricula : BancoDados.getInstance().matriculas) {
			if (matricula.turma.ano == ano
					&& matricula.turma.semestre == semestre) {
				matriculasSemestre.add(matricula);
			}
		}
		Matricula[] mats = new Matricula[matriculasSemestre.size()];
		mats = matriculasSemestre.toArray(mats);
		return mats;
	}

	@Override
	public boolean matricular(Aluno aluno, Turma turma,
			StringHolder mensagemErro) {
		alert("1");
		for (Matricula matricula : BancoDados.getInstance().matriculas) {
			alert("2");
			if (matricula.turma.codigo == turma.codigo
					&& matricula.aluno.codigo == aluno.codigo) {
				alert("3");
				mensagemErro.value = "Aluno já foi matriculado para esta turma.";
				return false;
			}
		}
		alert("4");
		BancoDados.getInstance().matriculas.add(new Matricula(aluno, turma));
		mensagemErro.value = "";
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
		mensagemErro.value = "";
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
		mensagemErro.value = "";
		return true;
	}

	@Override
	public boolean cadastrarProva(Prova prova, StringHolder mensagemErro) {
		BancoDados.getInstance().provas.add(prova);
		mensagemErro.value = "";
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
		Disciplina[] disciplinas = new Disciplina[BancoDados.getInstance().disciplinas
				.size()];
		disciplinas = BancoDados.getInstance().disciplinas.toArray(disciplinas);
		return disciplinas;
	}

	private static void alert(String msg) {
		System.out.println(msg);
	}
}