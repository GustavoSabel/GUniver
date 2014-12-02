package br.furb.guniver.corba;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.StringHolder;
import br.furb.guniver.modelo.academico.Aluno;
import br.furb.guniver.modelo.academico.Disciplina;
import br.furb.guniver.modelo.academico.Horario;
import br.furb.guniver.modelo.academico.IAcademicoPOA;
import br.furb.guniver.modelo.academico.Matricula;
import br.furb.guniver.modelo.academico.Prova;
import br.furb.guniver.modelo.academico.Turma;

class consulta_alunoImpl extends IAcademicoPOA {

    @Override
    public Prova[] getNotasAluno(int codigoAluno, int codigoTurma) {

	System.out.println("Executado getNotasAluno(Aluno aluno, Turma turma)");
	
	List<Prova> provasAluno = new ArrayList<>();
	for (Prova prova : BancoDados.getInstance().provas) {
	    if (prova.aluno.codigo == codigoAluno) {
		if (prova.turma.codigo == codigoTurma) {
		    provasAluno.add(prova);
		}
	    }
	}

	Prova[] notas = new Prova[provasAluno.size()];
	notas = provasAluno.toArray(notas);

	return notas;
    }

    @Override
    public Matricula getMatricula(int codigoAluno, int codigoDisciplina) {

	System.out.println("Executado getMatricula(Aluno aluno, Disciplina disciplina)");
	
	// Não pode retorna NULL se não encontrar a matricula
	Matricula matriculaDisci = new Matricula(new Aluno(0, ""), new Turma(0, (short) 0, (short) 0,
		new Disciplina(0, "")));

	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.aluno.codigo == codigoAluno) {
		if (matricula.turma.disciplina.codigo == codigoDisciplina) {
		    matriculaDisci = matricula;
		    break;
		}
	    }
	}

	return matriculaDisci;
    }

    @Override
    public Matricula[] getMatriculasAluno(int codigoAluno) {
	System.out.println("getMatriculasAluno(Aluno aluno)");
	
	List<Matricula> matriculasAluno = new ArrayList<Matricula>();
	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.aluno.codigo == codigoAluno) {
		matriculasAluno.add(matricula);
	    }
	}

	Matricula[] mats = new Matricula[matriculasAluno.size()];
	mats = matriculasAluno.toArray(mats);

	return mats;
    }

    @Override
    public Matricula[] getMatriculasTurma(int codigoTurma) {
	System.out.println("getMatriculasTurma(Turma turma)");
	
	List<Matricula> matriculasAluno = new ArrayList<Matricula>();
	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.turma.codigo == codigoTurma) {
		matriculasAluno.add(matricula);
	    }
	}

	Matricula[] mats = new Matricula[matriculasAluno.size()];
	mats = matriculasAluno.toArray(mats);

	return mats;
    }

   /* @Override
    public Matricula[] getMatriculasSemestre(int codigoAluno, short ano, short semestre) {
	System.out.println("getMatriculasSemestre(Aluno aluno, short ano, short semestre)");
	
	List<Matricula> matriculasSemestre = new ArrayList<>();
	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.turma.ano == ano && matricula.turma.semestre == semestre) {
		matriculasSemestre.add(matricula);
	    }
	}
	Matricula[] mats = new Matricula[matriculasSemestre.size()];
	mats = matriculasSemestre.toArray(mats);
	return mats;
    }
*/
    @Override
    public boolean matricular(Aluno aluno, Turma turma, StringHolder mensagemErro) {
	System.out.println("matricular(Aluno aluno, Turma turma, StringHolder mensagemErro)");
	
	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.turma.codigo == turma.codigo && matricula.aluno.codigo == aluno.codigo) {
		mensagemErro.value = "Aluno já foi matriculado para esta turma.";
		return false;
	    }
	}
	BancoDados.getInstance().matriculas.add(new Matricula(aluno, turma));
	mensagemErro.value = "";
	return true;
    }

    @Override
    public Horario[] getHorarios(int codigoTurma) {
	System.out.println("getHorarios()");
	
	Horario[] horarios = new Horario[] { new Horario("18:30-20:10", "S410"), new Horario("20:20-22:00", "S415"), };
	return horarios;
    }

    private static void alert(String msg) {
	System.out.println(msg);
    }

    @Override
    public boolean cadastrarProva(Prova prova, StringHolder mensagemErro) {
	System.out.println("cadastrarProva(Prova prova, StringHolder mensagemErro)");
	BancoDados.getInstance().provas.add(prova);
	mensagemErro.value = "";
	return true;
    }

    /*
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
    */
}
