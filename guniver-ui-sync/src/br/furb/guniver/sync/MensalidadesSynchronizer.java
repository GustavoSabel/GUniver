package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import br.furb.guniver.central_do_aluno.stubs.CentralAluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAlunoService;
import br.furb.guniver.central_do_aluno.stubs.Mensalidade;

public class MensalidadesSynchronizer extends EntitiesSynchronizer<Mensalidade> {

	CentralAluno port;
	
	public MensalidadesSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		super(moduleUrl, executor);
		port = new CentralAlunoService().getCentralAlunoPort();
		
	}

	@Override
	protected void doDownload(Mensalidade entityAccessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Collection<Mensalidade> doDownloadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doUpload(Mensalidade entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doUploadAll(Collection<Mensalidade> entities) {
		// TODO Auto-generated method stub
		
	}


}
