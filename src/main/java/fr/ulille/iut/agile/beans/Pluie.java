package fr.ulille.iut.agile.beans;

import java.time.LocalDateTime;

public class Pluie {
	
	private LocalDateTime time;

	private double precipitation; //En mm
	private boolean averse;
	
	public Pluie(LocalDateTime pTime, double pPrecipitation, boolean pAverse) {
		time = pTime;
		precipitation = pPrecipitation;
		averse = pAverse;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public double getPrecipitation() {
		return precipitation;
	}
	
	public boolean isAverse() {
		return averse;
	}
	
	@Override
	public String toString() {
		return "Pluie "+precipitation+"mm - Averse "+averse+" - "+time.toLocalTime();
	}
	
}
