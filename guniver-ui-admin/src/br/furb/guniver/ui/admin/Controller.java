package br.furb.guniver.ui.admin;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import modulo.cadastro.Aluno;
import modulo.cadastro.Curso;
import modulo.cadastro.Disciplina;
import modulo.cadastro.Turma;
import br.furb.guniver.sync.EntitiesSynchronizer;

public class Controller {

	private static Class<?>[] ENTITIES_CLASSES = { Aluno.class, Curso.class, Disciplina.class, Turma.class };

	private Map<Class<?>, EntitiesSynchronizer<?>> synchronizers = new HashMap<>(5);
	private Collection<Aluno> alunos;
	private Collection<Curso> cursos;
	private Collection<Disciplina> disciplinas;
	private Collection<Turma> turma;

	/**
	 * 
	 * @param synchronizers
	 *            mapa com os sincronizadores de todos módulos do Sistema
	 *            Distribuído. A chave é a classe da entidade e o valor é o
	 *            respectivo sincronizador.
	 */
	public Controller(Map<Class<?>, EntitiesSynchronizer<?>> synchronizers) {
		for (Class<?> entityClass : ENTITIES_CLASSES) {
			EntitiesSynchronizer<?> synchronizer = synchronizers.get(entityClass);
			if (synchronizer == null) {
				throw new IllegalArgumentException(String.format("sincronizador para a entidade %s não informado", entityClass.getName()));
			}
			// TODO: adicionar listener
			this.synchronizers.put(entityClass, synchronizer);
		}
	}

	/**
	 * Dispara requisições de sincronização para todos as entidades.<br>
	 * Este método é assíncrono.
	 */
	public void synchronizeAll() {
		downloadAlunos();
		downloadCursos();
		downloadDisciplinas();
		downloadTurma();
	}

	public void downloadAlunos() {
		synchronizers.get(Aluno.class).downloadAll();
	}

	public void downloadCursos() {
		synchronizers.get(Curso.class).downloadAll();
	}

	public void downloadDisciplinas() {
		synchronizers.get(Disciplina.class).downloadAll();
	}

	public void downloadTurma() {
		synchronizers.get(Turma.class).downloadAll();
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

}
