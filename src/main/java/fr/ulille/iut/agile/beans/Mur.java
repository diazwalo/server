package fr.ulille.iut.agile.beans;

import java.util.UUID;

public class Mur {
	private String cno;
	private float superficie;
	private String geolocalisation;
	private String nom;
	
	public Mur(float superficie, String geolocalisation, String nom) {
		this.cno = UUID.randomUUID().toString();
		this.superficie = superficie;
		this.geolocalisation = geolocalisation;
		this.nom = nom;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public String getGeolocalisation() {
		return geolocalisation;
	}

	public void setGeolocalisation(String geolocalisation) {
		this.geolocalisation = geolocalisation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCno() {
		return cno;
	}
	

}
