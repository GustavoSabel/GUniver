package br.furb.guniver.ui.portal;

import java.util.Collection;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.sync.AlunosSynchronizer;
import br.furb.guniver.sync.SyncListener;
import br.furb.guniver.ui.utils.UIUtils;

public class PortalController {

	private String webServiceUrl;
	private LoginWindow loginWindow;
	private AlunosSynchronizer $alunosSynchronizer;
	private Aluno loggedUser;

	public PortalController() {
		// TODO Auto-generated constructor stub
	}

	public String getWebServiceUrl() {
		return webServiceUrl;
	}

	public void setWebServiceUrl(String webServiceUrl) {
		this.webServiceUrl = webServiceUrl;
	}

	public void setLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
	}

	public LoginWindow getLoginWindow() {
		return loginWindow;
	}

	private AlunosSynchronizer getAlunosSynchronizer() {
		if ($alunosSynchronizer == null) {
			throw new IllegalStateException("");
		}
		return $alunosSynchronizer;
	}

	public void login(String username, String password) {
		Aluno aluno = new Aluno();
		aluno.setNomeUsuario(username);
		aluno.setSenha(password);

		getAlunosSynchronizer().addSyncListener(loginListener);
		getAlunosSynchronizer().download(aluno);
	}

	public void setLoggedUser(Aluno loggedUser) {
		this.loggedUser = loggedUser;
	}

	public Aluno getLoggedUser() {
		return loggedUser;
	}

	private SyncListener<Aluno> loginListener = new SyncListener<Aluno>() {

		@Override
		public void downloadComplete(Aluno downloadedEntity) {
			getAlunosSynchronizer().removeSyncListener(this);
			setLoggedUser(downloadedEntity);
			getAlunosSynchronizer().addSyncListener(alunosListener);
			// TODO
		}

		@Override
		public void syncFailed(Throwable reason) {
			getAlunosSynchronizer().removeSyncListener(this);
			UIUtils.showError(getLoginWindow(), reason);
		}

		@Override
		public void downloadAllComplete(Collection<Aluno> entities) {
		}

		@Override
		public void uploadComplete(Aluno uploadedEntity) {
		}

	};

	private SyncListener<Aluno> alunosListener = new SyncListener<Aluno>() {

		@Override
		public void uploadComplete(Aluno uploadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void syncFailed(Throwable reason) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadComplete(Aluno downloadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadAllComplete(Collection<Aluno> entities) {
			// TODO Auto-generated method stub

		}
	};

}
