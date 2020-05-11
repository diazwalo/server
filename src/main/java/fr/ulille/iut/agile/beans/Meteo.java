package fr.ulille.iut.agile.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Meteo {
	
	private LocalDate date;
	
	private List<Temperature> listTemp;
	private List<Pluie> listPluie;

	public Meteo(LocalDate pDate) {
		date = pDate;
		listTemp = new ArrayList<Temperature>();
		listPluie = new ArrayList<Pluie>();
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void addTemperature(Temperature pTemp) {
		if(!pTemp.getTime().toLocalDate().equals(date)) return;
		listTemp.add(pTemp);
	}
	
	public void addTemperature(LocalDateTime pDate, double pTempKelvin) {
		addTemperature(new Temperature(pDate, pTempKelvin));
	}
	
	public void addPluie(Pluie pPluie) {
		if(!pPluie.getTime().toLocalDate().equals(date)) return;
		listPluie.add(pPluie);
	}
	
	public void addPluie(LocalDateTime pDate, double pPrecipipation, boolean pAverse) {
		addPluie(new Pluie(pDate, pPrecipipation, pAverse));
	}
	
	public List<Temperature> getTemperatures() {
		return listTemp;
	}
	
	private Temperature getTempAt(LocalTime pTime) {
		for(Temperature temp: listTemp) {
			if(temp.getTime().toLocalTime().equals(pTime)) return temp;
		}
		return null;
	}
	
	public Temperature getTempAt2am() {
		return getTempAt(LocalTime.of(2, 0));
	}
	
	public Temperature getTempAt5am() {
		return getTempAt(LocalTime.of(5, 0));
	}
	
	public Temperature getTempAt8am() {
		return getTempAt(LocalTime.of(8, 0));
	}
	
	public Temperature getTempAt11am() {
		return getTempAt(LocalTime.of(2, 0));
	}
	
	public Temperature getTempAt2pm() {
		return getTempAt(LocalTime.of(14, 0));
	}
	
	public Temperature getTempAt5pm() {
		return getTempAt(LocalTime.of(17, 0));
	}
	
	public Temperature getTempAt8pm() {
		return getTempAt(LocalTime.of(20, 0));
	}
	
	public Temperature getTempAt11pm() {
		return getTempAt(LocalTime.of(23, 0));
	}
	
	public List<Pluie> getPluies() {
		return listPluie;
	}
	
	private Pluie getPluieAt(LocalTime pTime) {
		for(Pluie pluie: listPluie) {
			if(pluie.getTime().toLocalTime().equals(pTime)) return pluie;
		}
		return null;
	}
	
	public Pluie getPluieAt2am() {
		return getPluieAt(LocalTime.of(2, 0));
	}
	
	public Pluie getPluieAt5am() {
		return getPluieAt(LocalTime.of(5, 0));
	}
	
	public Pluie getPluieAt8am() {
		return getPluieAt(LocalTime.of(8, 0));
	}
	
	public Pluie getPluieAt11am() {
		return getPluieAt(LocalTime.of(2, 0));
	}
	
	public Pluie getPluieAt2pm() {
		return getPluieAt(LocalTime.of(14, 0));
	}
	
	public Pluie getPluieAt5pm() {
		return getPluieAt(LocalTime.of(17, 0));
	}
	
	public Pluie getPluieAt8pm() {
		return getPluieAt(LocalTime.of(20, 0));
	}
	
	public Pluie getPluieAt11pm() {
		return getPluieAt(LocalTime.of(23, 0));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Meteo_"+date+"[{");
		for(Temperature temp: listTemp) {
			sb.append(temp+", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("},\n");
		
		for(Pluie pluie: listPluie) {
			sb.append(pluie+", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("}]");
		return sb.toString();
	}
	
}
