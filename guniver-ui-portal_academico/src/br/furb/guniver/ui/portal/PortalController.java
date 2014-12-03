package br.furb.guniver.ui.portal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.sync.AlunosSynchronizer;
import br.furb.guniver.sync.AuthenticationException;
import br.furb.guniver.sync.SyncListener;
import br.furb.guniver.ui.utils.UIUtils;

public class PortalController {

	public static int THREAD_POOL_MAX_SIZE = 5;

	private String webServiceUrl;
	private LoginWindow loginWindow;
	private AlunosSynchronizer $alunosSynchronizer;
	private Aluno loggedUser;

	private MainWindow mainWindow;

	public PortalController() {
		String hostAddress;
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			hostAddress = "localhost";
		}

		setWebServiceUrl(hostAddress);
	}

	public String getWebServiceUrl() {
		return webServiceUrl;
	}

	public void setWebServiceUrl(String webServiceUrl) {
		this.webServiceUrl = webServiceUrl;
		if ($alunosSynchronizer != null) {
			$alunosSynchronizer.removeSyncListener(alunosListener);
			$alunosSynchronizer.removeSyncListener(loginListener);
			$alunosSynchronizer.stop();
		}

		ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_MAX_SIZE, THREAD_POOL_MAX_SIZE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
		$alunosSynchronizer = new AlunosSynchronizer(webServiceUrl, executor);
		$alunosSynchronizer.addSyncListener(alunosListener);
	}

	public void setLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
	}

	public LoginWindow getLoginWindow() {
		return loginWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	private AlunosSynchronizer getAlunosSynchronizer() {
		if ($alunosSynchronizer == null) {
			throw new IllegalStateException("sincronizador de Alunos não definido");
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
			getLoginWindow().dispose();
			setLoginWindow(null);

			MainWindow mainWindow = new MainWindow(PortalController.this);
			mainWindow.setAluno(downloadedEntity);
			UIUtils.centerOnScreen(mainWindow);
			mainWindow.setVisible(true);
		}

		@Override
		public void syncFailed(Throwable reason) {
			getAlunosSynchronizer().removeSyncListener(this);
			if (reason instanceof AuthenticationException) {
				UIUtils.showMessage(getLoginWindow(), reason.getMessage(), "Ops!", JOptionPane.ERROR_MESSAGE);
			} else {
				UIUtils.showError(getLoginWindow(), reason);
			}
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
