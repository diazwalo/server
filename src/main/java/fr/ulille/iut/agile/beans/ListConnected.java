package fr.ulille.iut.agile.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListConnected {
	
	public static final ListConnected instance = new ListConnected();
	
	private List<Connected> myListConnected;
	
	private ListConnected() {
		myListConnected = new ArrayList<>();
	}
	
	public void addConnected(UUID pUUID) {
		myListConnected.add(new Connected(pUUID));
	}
	
	public void removeConnected(UUID pUUID) {
		Connected toRemove = getConnected(pUUID);
		myListConnected.remove(toRemove);
	}
	
	public Connected getConnected(UUID pUUID) {
		Connected toReturn = null;
		for(Connected myConnected: myListConnected) {
			if(myConnected.getUUID().equals(pUUID.toString())) {
				toReturn = myConnected;
				break;
			}
		}
		return toReturn;
	}
	
	public boolean isConnected(UUID pUUID) {
		Connected myConnected = getConnected(pUUID);
		if(myConnected == null) return false;
		
		return !myConnected.isAFK();
	}

	public void update(UUID pUUID) {
		Connected myConnected = getConnected(pUUID);
		if(myConnected == null) return;
		
		myConnected.resetTimer();
	}
	
}
