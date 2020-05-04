package fr.ulille.iut.agile.request;

import java.util.UUID;

import fr.ulille.iut.agile.beans.ListConnected;

public interface Request {

	public default void update(String pUUID) {
		ListConnected.instance.update(UUID.fromString(pUUID));
	}
	
}
