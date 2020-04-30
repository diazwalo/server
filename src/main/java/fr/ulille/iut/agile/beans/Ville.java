package fr.ulille.iut.agile.beans;

public class Ville {

	private String name;
	private float coefSecu;
	
	public Ville(String pName, float pCoefSecu) {
		name = pName;
		coefSecu = pCoefSecu;
	}
	
	public String getName() {
		return name;
	}
	
	public float getCoefSecu() {
		return coefSecu;
	}
	
}
