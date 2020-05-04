package fr.ulille.iut.agile.dto;

import java.util.ArrayList;
import java.util.List;
import fr.ulille.iut.agile.beans.Mur;
import fr.ulille.iut.agile.dao.MurDao;

public class MurDaoImpl implements MurDao {

	List<Mur> listMur;

	public MurDaoImpl(){
		listMur = new ArrayList<>();
		Mur mur1 = new Mur(5000, "Lille", "Mon jolie mur");
		Mur mur2 = new Mur(5000, "Paris", "IciCestParis");
		Mur mur3 = new Mur(5000, "Marseille", "Vive l'OM");
		listMur.add(mur1);
		listMur.add(mur2);
		listMur.add(mur3);
	}

	@Override
	public void ajouter(Mur cuve) {
		listMur.add(cuve);
	}

	@Override
	public List<Mur> lister() {
		return listMur;
	}

	@Override
	public Mur getMur(String uno) {
		for(Mur mur: listMur) {
			if(mur.getCno().equals(uno)) return mur;
		}
		return null;
	}

	@Override
	public void deleteMur(Mur uno) {
		listMur.remove(uno);
	}

	@Override
	public void modifierNom(Mur mur, String nom) {
		mur.setNom(nom);
	}

	@Override
	public void creationTable() {
		// TODO Auto-generated method stub

	}
}

