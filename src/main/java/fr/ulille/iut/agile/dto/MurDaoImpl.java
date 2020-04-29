package fr.ulille.iut.agile.dto;

import java.util.ArrayList;
import java.util.List;
import fr.ulille.iut.agile.beans.Mur;
import fr.ulille.iut.agile.dao.MurDao;

public class MurDaoImpl implements MurDao {

	 List<Mur> listMur;
	 
	 public MurDaoImpl(){
			listMur = new ArrayList<Mur>();
			Mur Mur1 = new Mur(5000, "Lille", "Mon jolie mur");
			Mur Mur2 = new Mur(5000, "Paris", "IciCestParis");
			Mur Mur3 = new Mur(5000, "Marseille", "Vive l'OM");
			listMur.add(Mur1);
			listMur.add(Mur2);
			listMur.add(Mur3);
		}
	 
	@Override
	public void ajouter(Mur cuve) {
		// TODO Auto-generated method stub
		listMur.add(cuve);
	}

	@Override
	public List<Mur> lister() {
		// TODO Auto-generated method stub
		return listMur;
	}

	@Override
	public Mur getMur(String uno) {
		// TODO Auto-generated method stub
		for(Mur mur: listMur) {
			if(mur.getCno().equals(uno)) return mur;
		}
		return null;
	}

	@Override
	public void deleteMur(Mur uno) {
		// TODO Auto-generated method stub
		listMur.remove(uno);
	}

	@Override
	public void modifierNom(Mur mur, String nom) {
		// TODO Auto-generated method stub
		mur.setNom(nom);;
	}

}
