package fr.ulille.iut.agile.beans;

import java.util.ArrayList;
import java.util.List;

public class ListVilles {

	private List<Ville> listVilles;
	
	public static ListVilles instance = new ListVilles();
	
	private ListVilles() {
		listVilles = new ArrayList<Ville>();
	}
	
	public void addVille(Ville pVille) {
		listVilles.add(pVille);
	}
	
	public Ville getVille(String pName) {
		for(Ville myVille: listVilles) {
			if(myVille.getName().equalsIgnoreCase(pName)) return myVille;
		}
		return null;
	}
	
	public float getCoefOf(String pName) {
		Ville myVille = getVille(pName);
		if(myVille == null) return -1;
		
		return myVille.getCoefSecu();
	}
	
	public boolean exist(String pName) {
		return getVille(pName) != null;
	}
	
}
