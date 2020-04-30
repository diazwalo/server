package fr.ulille.iut.agile.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.ulille.iut.agile.beans.Utilisateur;
import fr.ulille.iut.agile.dao.UtilisateurDao;

public class UtilisateurDaoImpl implements UtilisateurDao{

	 List<Utilisateur> listUtilisateur;
	 private static final Logger LOGGER = Logger.getLogger(UtilisateurDaoImpl.class.getName());

	   public UtilisateurDaoImpl(){
	      listUtilisateur = new ArrayList<>();
	      Utilisateur student1 = new Utilisateur("admin","admin", "admin.admin@gmail.com");
	      Utilisateur student2 = new Utilisateur("toto","toto", "toto.toto@gmail.com");
	      Utilisateur student3 = new Utilisateur("remy","estPasBeau", "remy.estPasBeau@gmail.com");
	      listUtilisateur.add(student1);
	      listUtilisateur.add(student2);
	      listUtilisateur.add(student3);
	   }
	@Override
	public void ajouter(Utilisateur util) {
		listUtilisateur.add(util);
		LOGGER.info("Ajout de l'utilisateur");
	}

	@Override
	public List<Utilisateur> lister() {
		return listUtilisateur;
	}

	@Override
	public Utilisateur getUtilisateur(String uno) {
		for(Utilisateur user: listUtilisateur) {
			if(user.getIdentifiant().equals(uno)) return user;
		}
		return null;
	}

	@Override
	public void deleteUtilisateur(Utilisateur uno) {
		listUtilisateur.remove(uno);
	}
}
