package fr.ulille.iut.agile.beans;

import java.util.UUID;

public class Cuve {

	private static final int VALEUR_ALERTE_BASE = 3/4;

	private String cno;
	private float capacite;
	private float quantiteActuelle;
	private float alerteQuantite;
	private String nom;
	
	public Cuve(float capacite, float quantiteActuelle) {
		super();
		this.cno = UUID.randomUUID().toString();
		this.capacite = capacite;
		//L'utilisateur rentre une quantité d'eau suppérieur de la capcité
		if(quantiteActuelle>capacite) {
			quantiteActuelle = capacite;
		}
		this.quantiteActuelle = quantiteActuelle;
		this.alerteQuantite = capacite * VALEUR_ALERTE_BASE;
	}

	public float getQuantiteActuelle() {
		return quantiteActuelle;
	}

	public void setQuantiteActuelle(float quantiteActuelle) {
		this.quantiteActuelle = quantiteActuelle;
	}

	public float getAlerteQuantite() {
		return alerteQuantite;
	}

	public void setAlerteQuantite(float alerteQuantite) {
		this.alerteQuantite = alerteQuantite;
	}

	public String getCno() {
		return cno;
	}

	public float getCapcite() {
		return capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
