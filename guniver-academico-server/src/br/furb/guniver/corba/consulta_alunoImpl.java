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
    public boolean cadastrarMatricula(int codigoAluno, int codigoTurma, StringHolder mensagemErro) {
	System.out.println("matricular(Aluno aluno, Turma turma, StringHolder mensagemErro)");

	for (Matricula matricula : BancoDados.getInstance().matriculas) {
	    if (matricula.codigoTurma == codigoTurma && matricula.codigoAluno == codigoAluno) {
		mensagemErro.value = "Aluno já foi matriculado para esta turma.";
		return false;
	    }
	}
	BancoDados.getInstance().matriculas.add(new Matricula(codigoAluno, codigoTurma));
	mensagemErro.value = "";
	return true;
    }

    @Override
    public Horario[] getHorarios(int codigoTurma) {
	System.out.println("getHorarios()");

	Horario[] horarios = new Horario[] { new Horario("18:30-20:10", "S410"), new Horario("20:20-22:00", "S415"), };
	return horarios;
    }

    @Override
    public boolean cadastrarProva(Prova prova, StringHolder mensagemErro) {
	System.out.println("cadastrarProva(Prova prova, StringHolder mensagemErro)");
	BancoDados.getInstance().provas.add(prova);
	mensagemErro.value = "";
	return true;
    }
 
}
