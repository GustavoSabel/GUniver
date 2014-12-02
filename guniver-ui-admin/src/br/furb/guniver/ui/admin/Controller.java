package br.furb.guniver.ui.admin;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

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

public class Controller {

	private static Class<?>[] ENTITIES_CLASSES = { Aluno.class, Curso.class, Disciplina.class, Prova.class, Turma.class };

	public static int THREAD_POOL_MAX_SIZE = 5;

	private Map<Class<?>, EntitiesSynchronizer<?>> synchronizers;
	private Map<Class<?>, SyncListener<?>> listeners;
	private Collection<Aluno> alunos;
	private Collection<Curso> cursos;
	private Collection<Disciplina> disciplinas;
	private Collection<Turma> turma;

	private JFrame mainWindow;

	private SyncListener<?> syncListener;

	public Controller() {
		synchronizers = new HashMap<>();
		listeners = new HashMap<>();

		listeners.put(Aluno.class, new AlunoSyncListener());
		listeners.put(Curso.class, new CursoSyncListener());
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
			registerSynchronizer(Curso.class, synchronizers);
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
		downloadTurma();
	}

	public void downloadAlunos() {
		requireSynchronizer(Aluno.class).downloadAll();
	}

	public void downloadCursos() {
		requireSynchronizer(Curso.class).downloadAll();
	}

	public void downloadDisciplinas() {
		requireSynchronizer(Disciplina.class).downloadAll();
	}

	public void downloadTurma() {
		requireSynchronizer(Turma.class).downloadAll();
	}

	private EntitiesSynchronizer<?> requireSynchronizer(Class<?> entityClass) {
		EntitiesSynchronizer<?> synchronizer;
		synchronized (synchronizers) {
			synchronizer = synchronizers.get(entityClass);
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

	public Collection<Turma> getTurma() {
		return orEmpty(turma);
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
			synchronizers.put(Aluno.class, new AlunosSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Curso.class, new CursosSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Disciplina.class, new DisciplinasSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Turma.class, new TurmasSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Prova.class, new ProvasSynchronizer(academicoUrl, executor));
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

	private class AlunoSyncListener implements SyncListener<Aluno> {

		@Override
		public void downloadAllComplete(Collection<Aluno> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadComplete(Aluno downloadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void uploadComplete(Aluno uploadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void syncFailed(Throwable reason) {
			// TODO Auto-generated method stub

		}
	}

	private class CursoSyncListener implements SyncListener<Curso> {

		@Override
		public void downloadAllComplete(Collection<Curso> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadComplete(Curso downloadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void uploadComplete(Curso uploadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void syncFailed(Throwable reason) {
			// TODO Auto-generated method stub

		}
	}

	private class DisciplinaSyncListener implements SyncListener<Disciplina> {

		@Override
		public void downloadAllComplete(Collection<Disciplina> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadComplete(Disciplina downloadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void uploadComplete(Disciplina uploadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void syncFailed(Throwable reason) {
			// TODO Auto-generated method stub

		}
	}

	private class ProvaSyncListener implements SyncListener<Prova> {

		@Override
		public void downloadAllComplete(Collection<Prova> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadComplete(Prova downloadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void uploadComplete(Prova uploadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void syncFailed(Throwable reason) {
			// TODO Auto-generated method stub

		}
	}

	private class TurmaSyncListener implements SyncListener<Turma> {

		@Override
		public void downloadAllComplete(Collection<Turma> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void downloadComplete(Turma downloadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void uploadComplete(Turma uploadedEntity) {
			// TODO Auto-generated method stub

		}

		@Override
		public void syncFailed(Throwable reason) {
			// TODO Auto-generated method stub

		}
	}

}
