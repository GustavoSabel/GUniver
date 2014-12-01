package br.furb.guniver.sync;

import java.util.Collection;

public interface SyncListener<EntityType> {

	void downloadAllComplete(Collection<EntityType> entities);

	void downloadComplete(EntityType downloadedEntity);

	void uploadComplete(EntityType uploadedEntity);
	
	void syncFailed(Throwable reason);

}
