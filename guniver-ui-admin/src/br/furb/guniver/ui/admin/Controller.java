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
import br.furb.guniver.modelo.Turma;
import br.furb.guniver.sync.AlunosSynchronizer;
import br.furb.guniver.sync.CursosSynchronizer;
import br.furb.guniver.sync.DisciplinasSynchronizer;
import br.furb.guniver.sync.EntitiesSynchronizer;
import br.furb.guniver.sync.SyncListener;
import br.furb.guniver.sync.TurmasSynchronizer;

public class Controller {

	private static Class<?>[] ENTITIES_CLASSES = { Aluno.class, Curso.class, Disciplina.class, Turma.class };

	public static int THREAD_POOL_MAX_SIZE = 4;

	private Map<Class<?>, EntitiesSynchronizer<?>> synchronizers = new HashMap<>(5);
	private Collection<Aluno> alunos;
	private Collection<Curso> cursos;
	private Collection<Disciplina> disciplinas;
	private Collection<Turma> turma;

	private JFrame mainWindow;

	private SyncListener<?> syncListener;

	public Controller() {
		synchronizers = new HashMap<Class<?>, EntitiesSynchronizer<?>>();
	}

	/**
	 * 
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
			for (Class<?> entityClass : ENTITIES_CLASSES) {
				EntitiesSynchronizer<?> synchronizer = synchronizers.get(entityClass);
				if (synchronizer != null) {
					// TODO: adicionar listener
				}
				this.synchronizers.put(entityClass, synchronizer);
			}
		}
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
			throw new IllegalStateException(String.format("sincronizador da entidade %s não definido", entityClass.getName()));
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

	public void changeUrls(String academicoUrl, String cadastrosUrl, String centralDoAlunoUrl, String financeiroUrl) {
		stopSynchronizers();
		synchronized (synchronizers) {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_MAX_SIZE, THREAD_POOL_MAX_SIZE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
			// TODO: rever URLs
			synchronizers.put(Aluno.class, new AlunosSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Curso.class, new CursosSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Disciplina.class, new DisciplinasSynchronizer(cadastrosUrl, executor));
			synchronizers.put(Turma.class, new TurmasSynchronizer(cadastrosUrl, executor));
		}
		// TODO Auto-generated method stub

	}

	private void stopSynchronizers() {
		synchronized (synchronizers) {
			for (EntitiesSynchronizer<?> synchronizer : synchronizers.values()) {
				synchronizer.removeSyncListener(syncListener);
				synchronizer.stop();
			}
		}
	}

}
