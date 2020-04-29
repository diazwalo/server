package fr.ulille.iut.agile.dao;

import java.util.List;

import fr.ulille.iut.agile.beans.Cuve;

public interface CuveDao {
	void ajouter(Cuve cuve);
	List<Cuve>lister();
	Cuve getCuve(String uno);
	void deleteCuve(Cuve uno);
	void modifierNom(Cuve cuve, String nom);
}
