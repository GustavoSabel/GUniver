package br.furb.guniver.sync;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class EntitiesSynchronizer<EntityType> {

	private ThreadPoolExecutor executor;

	private String moduleUrl;
	private Collection<SyncListener<EntityType>> syncListeners;

	public EntitiesSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
		if (moduleUrl == null || moduleUrl.trim().isEmpty()) {
			throw new IllegalArgumentException("informe uma URL para sincronizar os dados");
		}
		if (executor == null) {
			throw new NullPointerException("informe um executor");
		}
		this.executor = executor;
		this.moduleUrl = moduleUrl;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public ThreadPoolExecutor getExecutor() {
		return executor;
	}

	/**
	 * Baixa a entidade do módulo remoto, fazendo a busca por uma ou todas as
	 * características informadas na entidade {@code entityAccessor}.<br>
	 * Ao receber os dados, a entidade informada possui seus atributos
	 * atualizados e o método {@link SyncListener#downloadComplete(Object)} é
	 * invocado nos listeners, passando a entidade recebida como parâmetro.
	 * 
	 * @param entityAccessor
	 *            entidade preenchida com os dados necessários para obter a
	 *            entidade original.
	 * @return
	 */
	public Future<?> download(EntityType entityAccessor) {
		SynchronizerTask<EntityType> downloadTask = new SynchronizerTask<EntityType>(entityAccessor) {
			@Override
			void doTask(EntityType parameter) {
				doDownload(parameter);
			}
		};

		return executor.submit(downloadTask);
	}

	public Future<?> downloadAll() {
		SynchronizerTask<Void> downloadAllTask = new SynchronizerTask<Void>() {
			@Override
			void doTask(Void parameter) {
				doDownloadAll();
			}
		};

		return executor.submit(downloadAllTask);
	}

	public Future<?> upload(EntityType entity) {
		SynchronizerTask<EntityType> uploadTask = new SynchronizerTask<EntityType>() {
			@Override
			void doTask(EntityType parameter) {
				doUpload(parameter);
			}
		};

		return executor.submit(uploadTask);
	}

	public Future<?> uploadAll(Collection<EntityType> entities) {
		SynchronizerTask<Collection<EntityType>> uploadAllTask = new SynchronizerTask<Collection<EntityType>>(entities) {
			@Override
			void doTask(Collection<EntityType> parameter) {
				doUploadAll(parameter);
			}
		};

		return executor.submit(uploadAllTask);
	}

	protected abstract void doDownload(EntityType entityAccessor);

	protected abstract void doDownloadAll();

	protected abstract void doUpload(EntityType entity);

	protected abstract void doUploadAll(Collection<EntityType> entities);

	public void addSyncListener(SyncListener<EntityType> l) {
		if (l != null) {
			syncListeners.add(l);
		}
	}

	public boolean removeSyncListener(SyncListener<EntityType> l) {
		return syncListeners.remove(l);
	}

	// <<--------- event firers ---------

	protected void fireDownloadAllComplete(Collection<EntityType> entities) {
		for (SyncListener<EntityType> syncListener : syncListeners) {
			syncListener.downloadAllComplete(entities);
		}
	}

	protected void fireDownloadComplete(EntityType downloadedEntity) {
		for (SyncListener<EntityType> syncListener : syncListeners) {
			syncListener.downloadComplete(downloadedEntity);
		}
	}

	protected void fireUploadComplete(EntityType uploadedEntity) {
		for (SyncListener<EntityType> syncListener : syncListeners) {
			syncListener.uploadComplete(uploadedEntity);
		}
	}

	protected void fireSyncFailed(Throwable reason) {
		for (SyncListener<EntityType> syncListener : syncListeners) {
			syncListener.syncFailed(reason);
		}
	}

	// --------- event firers --------->>

	/**
	 * Tarefa a ser executa assíncronamente, a qual precisa apenas que uma
	 * operação seja definida sobrescrevendo o método {@link #doTask(Object)}.<br>
	 * Qualquer exceção que ocorrer na execução do método será capturada e
	 * propagada pelos listeners através do método
	 * {@link EntitiesSynchronizer#fireSyncFailed(Throwable)}.
	 * 
	 * @author William Leander Seefeld
	 *
	 * @param <ParameterType>
	 *            tipo do parâmetro necessário para executar a operação.
	 */
	private abstract class SynchronizerTask<ParameterType> implements Runnable {

		private final ParameterType parameter;

		public SynchronizerTask() {
			this(null);
		}

		public SynchronizerTask(ParameterType parameter) {
			this.parameter = parameter;
		}

		@Override
		public void run() {
			try {
				doTask(parameter);
			} catch (Throwable t) {
				fireSyncFailed(t);
			}
		}

		abstract void doTask(ParameterType parameter);

	}

}
