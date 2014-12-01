package br.furb.guniver.sync;

import java.util.Collection;

public abstract class EntitiesSynchronizer<EntityType> {

	private String moduleUrl;
	private Collection<SyncListener<EntityType>> syncListeners;

	public EntitiesSynchronizer(String moduleUrl) {
		if (moduleUrl == null || moduleUrl.trim().isEmpty()) {
			throw new IllegalArgumentException("informe uma URL para sincronizar os dados");
		}
		this.moduleUrl = moduleUrl;
	}

	public String getModuleUrl() {
		return moduleUrl;
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
	 */
	public void download(EntityType entityAccessor) {
		try {
			// TODO: separar em outra Thread
			doDownload(entityAccessor);
		} catch (Throwable t) {
			fireSyncFailed(t);
		}
	}

	public void downloadAll() {
		try {
			// TODO: separar em outra Thread
			doDownloadAll();
		} catch (Throwable t) {
			fireSyncFailed(t);
		}
	}

	public void upload(EntityType entity) {
		try {
			// TODO: separar em outra Thread
			doUpload(entity);
		} catch (Throwable t) {
			fireSyncFailed(t);
		}
	}

	public void uploadAll(Collection<EntityType> entities) {
		try {
			// TODO: separar em outra Thread
			doUploadAll(entities);
		} catch (Throwable t) {
			fireSyncFailed(t);
		}
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

}
