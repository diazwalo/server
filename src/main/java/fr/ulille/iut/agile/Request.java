package fr.ulille.iut.agile;

import java.util.UUID;

import fr.ulille.iut.agile.beans.ListConnected;

public abstract class Request {

	public void update(String pUUID) {
		ListConnected.instance.update(UUID.fromString(pUUID));
	}
	
}
