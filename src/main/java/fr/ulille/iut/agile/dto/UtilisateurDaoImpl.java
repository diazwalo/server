package fr.ulille.iut.agile.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fr.ulille.iut.agile.beans.Utilisateur;
import fr.ulille.iut.agile.dao.UtilisateurDao;

public class UtilisateurDaoImpl implements UtilisateurDao{

	 List<Utilisateur> listUtilisateur;

	   public UtilisateurDaoImpl(){
	      listUtilisateur = new ArrayList<Utilisateur>();
	      Utilisateur student1 = new Utilisateur("admin","admin", "admin.admin@gmail.com");
	      Utilisateur student2 = new Utilisateur("toto","toto", "toto.toto@gmail.com");
	      Utilisateur student3 = new Utilisateur("remy","estPasBeau", "remy.estPasBeau@gmail.com");
	      listUtilisateur.add(student1);
	      listUtilisateur.add(student2);
	      listUtilisateur.add(student3);
	   }
	@Override
	public void ajouter(Utilisateur util) {
		// TODO Auto-generated method stub
		listUtilisateur.add(util);
		System.out.println("Ajout de l'utilisateur");
	}

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		return listUtilisateur;
	}

	@Override
	public Utilisateur getUtilisateur(String uno) {
		// TODO Auto-generated method stub
		for(Utilisateur user: listUtilisateur) {
			if(user.getIdentifiant().equals(uno)) return user;
		}
		return null;
	}

	@Override
	public void deleteUtilisateur(Utilisateur uno) {
		// TODO Auto-generated method stub
		listUtilisateur.remove(uno);
	}
}
