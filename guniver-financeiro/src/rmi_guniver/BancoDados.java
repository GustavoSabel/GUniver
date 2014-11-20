package rmi_guniver;

import java.util.ArrayList;
import java.util.List;


public class BancoDados {
	public List<Mensalidade> mensalidades;
	private static BancoDados instacia;

	private BancoDados() {
		mensalidades = new ArrayList<>();
		//CargaInicial();
	}

	public static BancoDados getIntancia() {
		if (instacia == null)
			instacia = new BancoDados();
		return instacia;
	}
	
	
	private void CargaInicial()
	{

	}
}
