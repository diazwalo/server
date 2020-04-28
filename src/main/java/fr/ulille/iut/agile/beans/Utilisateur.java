package fr.ulille.iut.agile.beans;

public class Utilisateur {
	
	private String name;
	private String mdp;
	private String email;

	public Utilisateur(String pName, String pMdp, String pEmail) {
		name = pName;
		mdp = pMdp;
		email = pEmail;
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

	
}
