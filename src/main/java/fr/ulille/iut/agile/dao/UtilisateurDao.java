package fr.ulille.iut.agile.dao;

import java.util.List;

import fr.ulille.iut.agile.beans.Utilisateur;

public interface UtilisateurDao {
	void ajouter(Utilisateur util);
	List<Utilisateur>lister();
	Utilisateur getUtilisateur(String uno);
	void deleteUtilisateur(Utilisateur uno);
}