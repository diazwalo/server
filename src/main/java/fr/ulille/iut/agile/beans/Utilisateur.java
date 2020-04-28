package fr.ulille.iut.agile.beans;

import java.util.UUID;

public class Utilisateur {
	
	private String name;
	private String mdp;
	private String email;
	private UUID identifiant;
	
	public Utilisateur(String pName, String pMdp, String pEmail) {
		name = pName;
		mdp = pMdp;
		email = pEmail;
		identifiant = UUID.randomUUID();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID getIdentifiant() {
		return identifiant;
	}

	
}
