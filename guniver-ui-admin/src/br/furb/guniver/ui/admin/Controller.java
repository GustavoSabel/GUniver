package br.furb.guniver.ui.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Curso;
import br.furb.guniver.modelo.Disciplina;
import br.furb.guniver.modelo.Prova;
import br.furb.guniver.modelo.Turma;
import br.furb.guniver.sync.AlunosSynchronizer;
import br.furb.guniver.sync.CursosSynchronizer;
import br.furb.guniver.sync.DisciplinasSynchronizer;
import br.furb.guniver.sync.EntitiesSynchronizer;
import br.furb.guniver.sync.ProvasSynchronizer;
import br.furb.guniver.sync.SyncListener;
import br.furb.guniver.sync.TurmasSynchronizer;
import br.furb.guniver.ui.utils.UIUtils;

public class Controller {

	public static int THREAD_POOL_MAX_SIZE = 5;

	private Map<Class<?>, EntitiesSynchronizer<?>> synchronizers;
	private Map<Class<?>, SyncListener<?>> listeners;
	private Collection<Aluno> alunos = new LinkedList<>();
	private Collection<Curso> cursos = new LinkedList<>();
	private Collection<Disciplina> disciplinas = new LinkedList<>();
	private Collection<Prova> provas = new LinkedList<>();
	private Collection<Turma> turmas = new LinkedList<>();

	private AlunoFragment alunoFragment;
	private CursoFragment cursoFragment;
	private DisciplinaFragment disciplinaFragment;
	private ProvaFragment provaFragment;
	private TurmaFragment turmaFragment;

	private JFrame mainWindow;

	private SyncListener<?> syncListener;

	public Controller() {
		synchronizers = new HashMap<>();
		listeners = new HashMap<>();

		listeners.put(Aluno.class, new AlunoSyncListener());
		listeners.put(Disciplina.class, new DisciplinaSyncListener());
		listeners.put(Prova.class, new ProvaSyncListener());
		listeners.put(Turma.class, new TurmaSyncListener());
	}

	/**
	 * @param synchronizers
	 *            mapa com os sincronizadores de todos módulos do Sistema
	 *            Distribuído. A chave é a classe da entidade e o valor é o
	 *            respectivo sincronizador.
	 */
	public Controller(Map<Class<?>, EntitiesSynchronizer<?>> synchronizers) {
		setSynchronizers(synchronizers);
	}

	public void setSynchronizers(Map<Class<?>, EntitiesSynchronizer<?>> synchronizers) {
		synchronized (this.synchronizers) {
			registerSynchronizer(Aluno.class, synchronizers);
			registerSynchronizer(Disciplina.class, synchronizers);
			registerSynchronizer(Prova.class, synchronizers);
			registerSynchronizer(Turma.class, synchronizers);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> void registerSynchronizer(Class<T> entityClass, Map<Class<?>, EntitiesSynchronizer<?>> synchronizers) {
		EntitiesSynchronizer<T> synchronizer = (EntitiesSynchronizer<T>) synchronizers.get(entityClass);
		if (synchronizer != null) {
			synchronizer.addSyncListener((SyncListener<T>) listeners.get(entityClass));
		}
		this.synchronizers.put(entityClass, synchronizer);
	}

	/**
	 * Dispara requisições de download para todas as entidades, sobrescrevendo
	 * as alterações locais.<br>
	 * Este método é assíncrono.
	 */
	public void downloadAll() {
		downloadAlunos();
		downloadCursos();
		downloadDisciplinas();
		downloadProva();
		downloadTurma();
	}

	public void downloadAlunos() {
		requireSynchronizer(Aluno.class).downloadAll();
	}

	public void uploadAluno(Aluno aluno) {
		requireSynchronizer(Aluno.class).upload(aluno);
	}

	@Deprecated
	public void downloadCursos() {
		requireSynchronizer(Curso.class).downloadAll();
	}

	@Deprecated
	public void uploadCurso(Curso curso) {
		requireSynchronizer(Curso.class).upload(curso);
	}

	public void downloadDisciplinas() {
		requireSynchronizer(Disciplina.class).downloadAll();
	}

	public void uploadDisciplina(Disciplina disciplina) {
		requireSynchronizer(Disciplina.class).upload(disciplina);
	}

	public void downloadProva() {
		requireSynchronizer(Prova.class).downloadAll();
	}

	public void uploadProva(Prova prova) {
		requireSynchronizer(Prova.class).upload(prova);
	}

	public void downloadTurma() {
		requireSynchronizer(Turma.class).downloadAll();
	}

	@SuppressWarnings("unchecked")
	private <T> EntitiesSynchronizer<T> requireSynchronizer(Class<T> entityClass) {
		EntitiesSynchronizer<T> synchronizer;
		synchronized (synchronizers) {
			synchronizer = (EntitiesSynchronizer<T>) synchronizers.get(entityClass);
		}
		if (synchronizer == null) {
			throw new IllegalStateException(String.format("sincronizador da entidade %s não definido", entityClass.getSimpleName()));
		}
		return synchronizer;
	}

	public Map<Class<?>, EntitiesSynchronizer<?>> getSynchronizers() {
		return synchronizers;
	}

	public Collection<Aluno> getAlunos() {
		return orEmpty(alunos);
	}

	public Collection<Curso> getCursos() {
		return orEmpty(cursos);
	}

	public Collection<Disciplina> getDisciplinas() {
		return orEmpty(disciplinas);
	}

	public Collection<Turma> getTurmas() {
		return orEmpty(turmas);
	}

	private static <T> Collection<T> orEmpty(Collection<T> collection) {
		return collection == null ? Collections.<T> emptyList() : collection;
	}

	public JFrame getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(JFrame mainWindow) {
		this.mainWindow = mainWindow;
	}

	public void changeUrls(String academicoUrl, String cadastrosUrl) {
		stopSynchronizers();
		synchronized (synchronizers) {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_MAX_SIZE, THREAD_POOL_MAX_SIZE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
			Map<Class<?>, EntitiesSynchronizer<?>> synchronizers = new HashMap<>();
			synchronizers.put(Aluno.class, new AlunosSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Disciplina.class, new DisciplinasSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Turma.class, new TurmasSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Prova.class, new ProvasSynchronizer(academicoUrl, executor));
			setSynchronizers(synchronizers);
		}
	}

	private void stopSynchronizers() {
		synchronized (synchronizers) {
			for (EntitiesSynchronizer<?> synchronizer : synchronizers.values()) {
				synchronizer.removeSyncListener(syncListener);
				synchronizer.stop();
			}
		}
	}

	public void showError(String message, Throwable t) {
		String stackTrace;
		try (StringWriter sw = new StringWriter(); // 
				PrintWriter pw = new PrintWriter(sw)) {
			t.printStackTrace(pw);
			stackTrace = sw.toString();
		} catch (IOException e) {
			stackTrace = "";
		}
		showError(message + "\n\n" + stackTrace);
	}

	public void showError(String message) {
		UIUtils.showMessage(getMainWindow(), message, "Ops!", JOptionPane.ERROR_MESSAGE);
	}

	public AlunoFragment getAlunoFragment() {
		return alunoFragment;
	}

	public void setAlunoFragment(AlunoFragment alunoFragment) {
		this.alunoFragment = alunoFragment;
	}

	@Deprecated
	public CursoFragment getCursoFragment() {
		return cursoFragment;
	}

	@Deprecated
	public void setCursoFragment(CursoFragment cursoFragment) {
		this.cursoFragment = cursoFragment;
	}

	public DisciplinaFragment getDisciplinaFragment() {
		return disciplinaFragment;
	}

	public void setDisciplinaFragment(DisciplinaFragment disciplinaFragment) {
		this.disciplinaFragment = disciplinaFragment;
	}

	public ProvaFragment getProvaFragment() {
		return provaFragment;
	}

	public void setProvaFragment(ProvaFragment provaFragment) {
		this.provaFragment = provaFragment;
	}

	public TurmaFragment getTurmaFragment() {
		return turmaFragment;
	}

	public void setTurmaFragment(TurmaFragment turmaFragment) {
		this.turmaFragment = turmaFragment;
	}

	private class AlunoSyncListener implements SyncListener<Aluno> {

		@Override
		public void downloadAllComplete(Collection<Aluno> entities) {
			alunos.clear();
			alunos.addAll(entities);
			getAlunoFragment().setAlunos(entities);
		}

		@Override
		public void downloadComplete(Aluno downloadedEntity) {
			getAlunoFragment().updateAluno(downloadedEntity);
		}

		@Override
		public void uploadComplete(Aluno uploadedEntity) {
			getAlunoFragment().updateAluno(uploadedEntity);
		}

		@Override
		public void syncFailed(Throwable reason) {
			showError("Erro na comunicação de Alunos", reason);
		}
	}

	@Deprecated
	private class CursoSyncListener implements SyncListener<Curso> {

		@Override
		public void downloadAllComplete(Collection<Curso> entities) {
			cursos.clear();
			cursos.addAll(entities);
			getCursoFragment().setCursos(entities);
		}

		@Override
		public void downloadComplete(Curso downloadedEntity) {
			getCursoFragment().updateCurso(downloadedEntity);
		}

		@Override
		public void uploadComplete(Curso uploadedEntity) {
			getCursoFragment().updateCurso(uploadedEntity);
		}

		@Override
		public void syncFailed(Throwable reason) {
			showError("Erro na comunicação de Cursos", reason);
		}
	}

	private class DisciplinaSyncListener implements SyncListener<Disciplina> {

		@Override
		public void downloadAllComplete(Collection<Disciplina> entities) {
			disciplinas.clear();
			disciplinas.addAll(entities);
			getDisciplinaFragment().setDisciplinas(entities);
		}

		@Override
		public void downloadComplete(Disciplina downloadedEntity) {
			getDisciplinaFragment().updateDisciplina(downloadedEntity);
		}

		@Override
		public void uploadComplete(Disciplina uploadedEntity) {
			getDisciplinaFragment().updateDisciplina(uploadedEntity);
		}

		@Override
		public void syncFailed(Throwable reason) {
			showError("Erro na comunicação de Disciplinas", reason);
		}
	}

	private class ProvaSyncListener implements SyncListener<Prova> {

		@Override
		public void downloadAllComplete(Collection<Prova> entities) {
			provas.clear();
			provas.addAll(entities);
			getProvaFragment().setProvas(entities);
		}

		@Override
		public void downloadComplete(Prova downloadedEntity) {
			getProvaFragment().updateProva(downloadedEntity);
		}

		@Override
		public void uploadComplete(Prova uploadedEntity) {
			getProvaFragment().updateProva(uploadedEntity);
		}

		@Override
		public void syncFailed(Throwable reason) {
			showError("Erro na comunicação de Provas", reason);
		}
	}

	private class TurmaSyncListener implements SyncListener<Turma> {

		@Override
		public void downloadAllComplete(Collection<Turma> entities) {
			turmas.clear();
			turmas.addAll(entities);
			getTurmaFragment().setTurmas(entities);
		}

		@Override
		public void downloadComplete(Turma downloadedEntity) {
			getTurmaFragment().updateTurma(downloadedEntity);
		}

		@Override
		public void uploadComplete(Turma uploadedEntity) {
			getTurmaFragment().updateTurma(uploadedEntity);
		}

		@Override
		public void syncFailed(Throwable reason) {
			showError("Erro na comunicação de Turmas", reason);
		}
	}

	public Aluno pickAluno() {
		AlunoFragment selectionFragment = new AlunoFragment(this);
		selectionFragment.setAlunos(alunos);
		selectionFragment.setPickUpMode(true);
		JOptionPane.showOptionDialog(getMainWindow(), selectionFragment, "Seleção de Aluno", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
				"Cancelar", "Escolher" }, "Cancelar");
		return selectionFragment.getSelectedAluno();
	}

	public Turma pickTurma() {
		TurmaFragment selectionFragment = new TurmaFragment(this);
		selectionFragment.setTurmas(turmas);
		selectionFragment.setPickUpMode(true);
		JOptionPane.showOptionDialog(getMainWindow(), selectionFragment, "Seleção de Turma", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
				"Cancelar", "Escolher" }, "Cancelar");
		return selectionFragment.getSelectedTurma();
	}

	public Disciplina pickDisciplina() {
		DisciplinaFragment selectionFragment = new DisciplinaFragment(this);
		selectionFragment.setDisciplinas(disciplinas);
		selectionFragment.setPickUpMode(true);
		JOptionPane.showOptionDialog(getMainWindow(), selectionFragment, "Seleção de Disciplina", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
				"Cancelar", "Escolher" }, "Cancelar");
		return selectionFragment.getSelectedDisciplina();
	}
}
