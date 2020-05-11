package fr.ulille.iut.agile.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVilles implements Iterable<Ville> {

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
	
	public double getCoefOf(String pName) {
		Ville myVille = getVille(pName);
		if(myVille == null) return -1;
		
		return myVille.getCoefSecu();
	}
	
	public boolean exist(String pName) {
		return getVille(pName) != null;
	}
	
	public void addMeteoTo(String pVille, Meteo pMeteo) {
		Ville myVille = getVille(pVille);
		if(myVille == null) return;
		
		myVille.addMeteo(pMeteo);
	}
	
	public List<Meteo> getMeteoFrom(String pVille) {
		Ville myVille = getVille(pVille);
		if(myVille == null) return null;
		
		return myVille.getMeteo();
	}

	@Override
	public Iterator<Ville> iterator() {
		return new ListVillesIterator();
	}
	
	public class ListVillesIterator implements Iterator<Ville> {
		
		private int idx = 0;
		private int size = listeVilles.size();

		@Override
		public boolean hasNext() {
			return idx < size;
		}

		@Override
		public Ville next() {
			Ville myVille = listeVilles.get(idx);
			idx++;
			return myVille;
		}
		
	}
	
}
