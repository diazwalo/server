package fr.ulille.iut.agile.dao;

import java.util.List;
import fr.ulille.iut.agile.beans.Mur;

public interface MurDao {
	void ajouter(Mur cuve);
	List<Mur>lister();
	Mur getMur(String uno);
	void deleteMur(Mur uno);
	void modifierNom(Mur mur, String nom);
}
