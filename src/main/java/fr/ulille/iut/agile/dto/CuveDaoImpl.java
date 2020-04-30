package fr.ulille.iut.agile.dto;

import java.util.ArrayList;
import java.util.List;

import fr.ulille.iut.agile.beans.Cuve;
import fr.ulille.iut.agile.dao.CuveDao;

public class CuveDaoImpl implements CuveDao{

	List<Cuve> listCuve;

	public CuveDaoImpl(){
		listCuve = new ArrayList<>();
		Cuve cuve1 = new Cuve(500, 10);
		Cuve cuve2 = new Cuve(25, 2);
		Cuve cuve3 = new Cuve(1000, 0);
		listCuve.add(cuve1);
		listCuve.add(cuve2);
		listCuve.add(cuve3);
	}
	@Override
	public void ajouter(Cuve cuve) {
		listCuve.add(cuve);
	}

	@Override
	public List<Cuve> lister() {
		return listCuve;
	}

	@Override
	public Cuve getCuve(String cno) {
		for(Cuve cuve: listCuve) {
			if(cuve.getCno().equals(cno)) return cuve;
		}
		return null;
	}

	@Override
	public void deleteCuve(Cuve cno) {
		listCuve.remove(cno);
	}
	@Override
	public void modifierNom(Cuve cuve, String nom) {
		cuve.setNom(nom);
	}

}
