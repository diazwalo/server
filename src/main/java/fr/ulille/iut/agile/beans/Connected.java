package fr.ulille.iut.agile.beans;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Connected {

	private String uuid;
	private LocalDateTime timer;
	
	private static final int MAX_DELAY = 30;
	
	public Connected(UUID pUUID) {
		uuid = pUUID.toString();
		timer = LocalDateTime.now();
	}
	
	public String getUUID() {
		return uuid;
	}
	
	public boolean isAFK() {
		return timer.until(LocalDateTime.now(), ChronoUnit.MINUTES) > MAX_DELAY;
	}

	public void resetTimer() {
		timer = LocalDateTime.now();
	}
	
}
