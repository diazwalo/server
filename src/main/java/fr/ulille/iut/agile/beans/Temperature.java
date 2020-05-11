package fr.ulille.iut.agile.beans;

import java.time.LocalDateTime;

public class Temperature {

	private LocalDateTime time;
	
	private double temp;
	
	public Temperature(LocalDateTime pTime, double pTempKelvin) {
		time = pTime;
		temp = pTempKelvin;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public double getTempInKelvin() {
		return temp;
	}
	
	public double getTempInCelsius() {
		return temp - 273.15;
	}
	
	@Override
	public String toString() {
		return "Temp "+temp+"K - "+time.toLocalTime();
	}
	
}
