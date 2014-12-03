package br.furb.guniver.corba;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.StringHolder;
import br.furb.guniver.modelo.academico.Horario;
import br.furb.guniver.modelo.academico.IAcademicoPOA;
import br.furb.guniver.modelo.academico.Matricula;
import br.furb.guniver.modelo.academico.Prova;

class consulta_alunoImpl extends IAcademicoPOA {

    @Override
    public Prova[] getProvasAluno(int codigoAluno, int codigoTurma) {

	System.out.println("consulta_alunoImpl.getProvasAluno()");

	List<Prova> provasAluno = new ArrayList<>();
	for (Prova prova : BancoDados.getInstance().provas) {
	    if (prova.codigoAluno == codigoAluno) {
		if (prova.codigoTurma == codigoTurma) {
		    provasAluno.add(prova);
		}
	    }
	}

	Prova[] notas = new Prova[provasAluno.size()];
	notas = provasAluno.toArray(notas);

	return notas;
    }

    @Override
    public Prova[] getProvas() {

	System.out.println("consulta_alunoImpl.getProvas()");

	Prova[] provas = new Prova[BancoDados.getInstance().provas.size()];
	provas = BancoDados.getInstance().provas.toArray(provas);

	return provas;
    }

    @Override
    public Matricula[] getMatriculasAluno(int codigoAluno) {
	System.out.println("consulta_alunoImpl.getMatriculasAluno()");

	List<Matricula> matriculasAluno = new ArrayList<Matricula>();
	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.codigoAluno == codigoAluno) {
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
	    if (matricula.codigoTurma == codigoTurma) {
		matriculasAluno.add(matricula);
	    }
	}

	Matricula[] mats = new Matricula[matriculasAluno.size()];
	mats = matriculasAluno.toArray(mats);

	return mats;
    }

    @Override
    public int cadastrarMatricula(Matricula matricula, StringHolder mensagemErro) {
	System.out.println("matricular(Aluno aluno, Turma turma, StringHolder mensagemErro)");

	mensagemErro.value = "";
	
	if (matricula.codigo <= 0) {
	    for (Matricula matriculaBanco : BancoDados.getInstance().matriculas) {
		if (matriculaBanco.codigoTurma == matricula.codigoTurma
			&& matriculaBanco.codigoAluno == matricula.codigoAluno) {
		    mensagemErro.value = "Aluno já foi matriculado para esta turma.";
		    return 0;
		}
	    }
	    matricula.codigo = BancoDados.getInstance().ultimoIdMatricula++;
	    BancoDados.getInstance().matriculas.add(matricula);
	} else {
	    boolean encontrou = false;
	    for (Matricula matriculaBanco : BancoDados.getInstance().matriculas) {
		if (matriculaBanco.codigo == matricula.codigo) {
		    matriculaBanco.codigoAluno = matricula.codigoAluno;
		    matriculaBanco.codigoTurma = matricula.codigoTurma;
		    encontrou = true;
		}
	    }
	    if (!encontrou) {
		mensagemErro.value = "Não foi possivel encontrar nenhuma matricula com o código " + matricula.codigo;
		return 0;
	    }
	}

	return matricula.codigo;
    }

    @Override
    public Horario[] getHorarios(int codigoTurma) {
	System.out.println("getHorarios()");

	Horario[] horarios = new Horario[] { new Horario(1, "18:30-20:10", "S410"),
		new Horario(2, "20:20-22:00", "S415"), };
	return horarios;
    }

    @Override
    public int cadastrarProva(Prova prova, StringHolder mensagemErro) {
	System.out.println("cadastrarProva(Prova prova, StringHolder mensagemErro)");
	System.out.println(" - Codigo: " + prova.codigo);
	mensagemErro.value = "";
	
	if (prova.codigo <= 0) {
	    prova.codigo = BancoDados.getInstance().ultimoIdProva++;
	    BancoDados.getInstance().provas.add(prova);
	    System.out.println(" - Prova Gravada com o codigo " + prova.codigo);
	} else {
	    boolean encontrou = false;
	    for (Prova provaBanco : BancoDados.getInstance().provas) {
		if (provaBanco.codigo == prova.codigo) {
		    provaBanco.codigoAluno = prova.codigoAluno;
		    provaBanco.codigoTurma = prova.codigoTurma;
		    provaBanco.descricao = prova.descricao;
		    provaBanco.nota = prova.nota;
		    encontrou = true;

		    System.out.println(" - Prova Alterada");
		}
	    }
	    if (!encontrou) {
		System.out.println(" - Prova Não Encontrada");
		mensagemErro.value = "Não foi possivel encontrar nenhuma prova com o código " + prova.codigo;
		return 0;
	    }
	}

	return prova.codigo;
    }

}
