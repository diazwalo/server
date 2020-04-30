package fr.ulille.iut.agile.beans;

import java.util.UUID;

public class Cuve {

	private static final int valeurAlerteBase = 3/4;

	private String cno;
	private int capacite;
	private int quantiteActuelle;
	private int alerteQuantite;
	private String nom;
	
	public Cuve(int capacite, int quantiteActuelle) {
		super();
		this.cno = UUID.randomUUID().toString();
		this.capacite = capacite;
		//L'utilisateur rentre une quantité d'eau suppérieur de la capcité
		if(quantiteActuelle>capacite) {
			quantiteActuelle = 0;
		}
		this.quantiteActuelle = quantiteActuelle;
		this.alerteQuantite = capacite * valeurAlerteBase;
	}

	public int getQuantiteActuelle() {
		return quantiteActuelle;
	}

	public void setQuantiteActuelle(int quantiteActuelle) {
		this.quantiteActuelle = quantiteActuelle;
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
		return capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
