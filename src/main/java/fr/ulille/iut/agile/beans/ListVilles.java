package fr.ulille.iut.agile.beans;

import java.util.ArrayList;
import java.util.List;

public class ListVilles {

	private List<Ville> listeVilles;
	
	public static final ListVilles instance = new ListVilles();
	
	private ListVilles() {
		listeVilles = new ArrayList<>();
	}
	
	public void addVille(Ville pVille) {
		listeVilles.add(pVille);
	}
	
	public Ville getVille(String pName) {
		for(Ville myVille: listeVilles) {
			if(myVille.getName().equalsIgnoreCase(pName)) return myVille;
		}
		return null;
	}
	
	public float getCoefOf(String pName) {
		Ville myVille = getVille(pName);
		if(myVille == null) return -1;
		
		return myVille.getCoefSecu();
	}
	
}
