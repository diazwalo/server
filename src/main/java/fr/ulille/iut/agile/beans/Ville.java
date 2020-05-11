package fr.ulille.iut.agile.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;

public class Ville {

	private String name;
	private double coefSecu;
	private String url_api;
	
	private List<Meteo> listMeteo;
	
	public Ville(String pName) {
		name = pName;
		listMeteo = new ArrayList<Meteo>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setCoefSecu(double coef) {
		coefSecu = coef;
	}
	
	public double getCoefSecu() {
		return coefSecu;
	}

	public String getUrl_api() {
		return url_api;
	}

	public void setUrl_api(String url_api) {
		this.url_api = url_api;
	}
	
	public Meteo getCloserMeteo() {
		if(listMeteo.size() == 0) return null;
		
		Meteo res = listMeteo.get(0);
		for(Meteo m: listMeteo) {
			if(m.getDate().isBefore(res.getDate())) res = m;
		}
		return res;
	}
	
	public List<Meteo> getMeteo() {
		return listMeteo;
	}
	
	public Meteo getFartherMeteo() {
		if(listMeteo.size() == 0) return null;
		
		Meteo res = listMeteo.get(0);
		for(Meteo m: listMeteo) {
			if(m.getDate().isAfter(res.getDate())) res = m;
		}
		return res;
	}
	
	public void addMeteo(Meteo pMeteo) {
		if(pMeteo == null) return;
		if(pMeteo.getDate().isBefore(LocalDate.now())) return;
		
		Meteo closer = getCloserMeteo();
		if(closer != null && closer.getDate().isBefore(LocalDate.now())) listMeteo.remove(closer);
		
		Meteo farther = getFartherMeteo();
		if(farther != null && pMeteo.getDate().isBefore(farther.getDate())) return;
			
		listMeteo.add(pMeteo);
	}
	
	public Meteo getMeteo(LocalDate pDate) {
		for(Meteo m: listMeteo) {
			if(m.getDate().equals(pDate)) return m;
		}
		return null;
	}
	
}
