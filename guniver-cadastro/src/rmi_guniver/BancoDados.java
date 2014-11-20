package rmi_guniver;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {
	public List<Aluno> alunos;
	private static BancoDados instacia;

	private BancoDados() {
		alunos = new ArrayList<>();
		//CargaInicial();
	}

	public static BancoDados getIntancia() {
		if (instacia == null)
			instacia = new BancoDados();
		return instacia;
	}
	
	
	private void CargaInicial()
	{
		Aluno alunoGustavo = new Aluno(1, "Gustavo Sabel");
		alunos.add(alunoGustavo);
	}
}
