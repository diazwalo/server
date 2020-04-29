package fr.ulille.iut.agile;

import fr.ulille.iut.agile.beans.Utilisateur;
import fr.ulille.iut.agile.dao.UtilisateurDao;
import fr.ulille.iut.agile.dto.UtilisateurDaoImpl;

public class DaoPatternDemo {
	public static void main(String[] args) {
		UtilisateurDao studentDao = new UtilisateurDaoImpl();

		//print all students
		for (Utilisateur utili : studentDao.lister()) {
			System.out.println("Utilisateur: [email : " + utili.getEmail() + ", et son mdp : " + utili.getMdp() + " ]");
		}

	}
}
