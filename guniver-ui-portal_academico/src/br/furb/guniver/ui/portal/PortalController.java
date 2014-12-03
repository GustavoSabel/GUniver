package br.furb.guniver.ui.portal;

import java.awt.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.Horario;
import br.furb.guniver.central_do_aluno.stubs.Prova;
import br.furb.guniver.central_do_aluno.stubs.Turma;
import br.furb.guniver.sync.AlunosSynchronizer;
import br.furb.guniver.sync.AuthenticationException;
import br.furb.guniver.sync.HorariosSynchronizer;
import br.furb.guniver.sync.ProvasSynchronizer;
import br.furb.guniver.sync.SyncListener;
import br.furb.guniver.sync.TurmasSynchronizer;
import br.furb.guniver.ui.utils.UIUtils;

public class PortalController {

	public static int THREAD_POOL_MAX_SIZE = 5;

	private String webServiceUrl;
	private LoginWindow loginWindow;
	private MainWindow mainWindow;

	private AlunosSynchronizer $alunosSynchronizer;
	private HorariosSynchronizer $horariosSynchronizer;
	private ProvasSynchronizer $provasSynchronizer;
	private TurmasSynchronizer $turmasSynchronizer;

	private Aluno loggedUser;
	private Collection<Turma> turmas = new LinkedList<>();

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
			$alunosSynchronizer.removeSyncListener(loginListener);
			$alunosSynchronizer.stop();
		}
		if ($horariosSynchronizer != null) {
			$horariosSynchronizer.removeSyncListener(horariosListener);
			$horariosSynchronizer.stop();
		}
		if ($provasSynchronizer != null) {
			$provasSynchronizer.removeSyncListener(provasListener);
			$provasSynchronizer.stop();
		}
		if ($turmasSynchronizer != null) {
			$turmasSynchronizer.removeSyncListener(turmasListener);
			$turmasSynchronizer.stop();
		}

		ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_MAX_SIZE, THREAD_POOL_MAX_SIZE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
		$alunosSynchronizer = new AlunosSynchronizer(webServiceUrl, executor);
		$horariosSynchronizer = new HorariosSynchronizer(webServiceUrl, executor);
		$provasSynchronizer = new ProvasSynchronizer(webServiceUrl, executor);
		$turmasSynchronizer = new TurmasSynchronizer(webServiceUrl, executor);

		$alunosSynchronizer.addSyncListener(loginListener);
		$provasSynchronizer.addSyncListener(provasListener);
		$turmasSynchronizer.addSyncListener(turmasListener);
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

	public HorariosSynchronizer getHorariosSynchronizer() {
		if ($horariosSynchronizer == null) {
			throw new IllegalStateException("sincronizador de Horários não definido");
		}
		return $horariosSynchronizer;
	}

	public ProvasSynchronizer getProvasSynchronizer() {
		if ($provasSynchronizer == null) {
			throw new IllegalStateException("sincronizador de Provas não definido");
		}
		return $provasSynchronizer;
	}

	public TurmasSynchronizer getTurmasSynchronizer() {
		if ($turmasSynchronizer == null) {
			throw new IllegalStateException("sincronizador de Turmas não definido");
		}
		return $turmasSynchronizer;
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

	public void showError(Throwable err) {
		Component parent = getMainWindow();
		if (parent == null) {
			parent = getLoginWindow();
		}
		UIUtils.showError(parent, err);
	}

	public Aluno getLoggedUser() {
		return loggedUser;
	}

	private SyncListener<Aluno> loginListener = new SyncListener<Aluno>() {

		@Override
		public void downloadComplete(Aluno downloadedEntity) {
			getAlunosSynchronizer().removeSyncListener(this);
			setLoggedUser(downloadedEntity);
			getLoginWindow().dispose();
			setLoginWindow(null);

			MainWindow mainWindow = new MainWindow(PortalController.this);
			mainWindow.setAluno(downloadedEntity);
			UIUtils.centerOnScreen(mainWindow);
			mainWindow.setVisible(true);
			getTurmasSynchronizer().downloadAllByAluno(downloadedEntity);
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

	private SyncListener<Horario> horariosListener = new SyncListener<Horario>() {

		@Override
		public void downloadAllComplete(Collection<Horario> entities) {
			getMainWindow().setHorarios(entities);
		}

		@Override
		public void downloadComplete(Horario downloadedEntity) {
		}

		@Override
		public void uploadComplete(Horario uploadedEntity) {
		}

		@Override
		public void syncFailed(Throwable reason) {
			UIUtils.showError(getLoginWindow(), reason);
		}

	};

	private SyncListener<Prova> provasListener = new SyncListener<Prova>() {

		@Override
		public void downloadAllComplete(Collection<Prova> entities) {
			getMainWindow().setProvas(entities);
		}

		@Override
		public void downloadComplete(Prova downloadedEntity) {
		}

		@Override
		public void uploadComplete(Prova uploadedEntity) {
		}

		@Override
		public void syncFailed(Throwable reason) {
			UIUtils.showError(getLoginWindow(), reason);
		}

	};

	private SyncListener<Turma> turmasListener = new SyncListener<Turma>() {

		@Override
		public void downloadAllComplete(Collection<Turma> entities) {
			turmas.clear();
			turmas.addAll(entities);
			mainWindow.setTurmas(entities);
		}

		@Override
		public void downloadComplete(Turma downloadedEntity) {
			mainWindow.updateTurma(downloadedEntity);
		}

		@Override
		public void uploadComplete(Turma uploadedEntity) {
			mainWindow.updateTurma(uploadedEntity);
		}

		@Override
		public void syncFailed(Throwable reason) {
			showError(reason);
		}
	};

	public void downloadProvas(Turma turma, Aluno aluno) {
		getProvasSynchronizer().downloadAllByTurmaAndAluno(turma, aluno);
	}

	public void downloadHorario(Turma turma) {
		getHorariosSynchronizer().downloadAllByTurma(turma);
	}

}
