package fr.ulille.iut.agile.beans;

import java.util.UUID;

public class Cuve {
	private final int valeurAlerteBase = 3/4;
	private String cno;
	private int capcite;
	private int qunatitéActuel;
	private int alerteQuantite;
	private String nom;
	
	public Cuve(int capacite, int qunatitéActuel) {
		super();
		this.cno = UUID.randomUUID().toString();
		this.capcite = capacite;
		//L'utilisateur rentre une quantité d'eau suppérieur de la capcité
		if(qunatitéActuel>capacite) {
			qunatitéActuel = 0;
		}
		this.qunatitéActuel = qunatitéActuel;
		this.alerteQuantite = capacite * valeurAlerteBase;
	}

	public int getQunatitéActuel() {
		return qunatitéActuel;
	}

	public void setQunatitéActuel(int qunatitéActuel) {
		this.qunatitéActuel = qunatitéActuel;
	}

	public int getAlerteQuantite() {
		return alerteQuantite;
	}

	public void setAlerteQuantite(int alerteQuantite) {
		this.alerteQuantite = alerteQuantite;
	}

	public String getCno() {
		return cno;
	}

	public int getCapcite() {
		return capcite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
