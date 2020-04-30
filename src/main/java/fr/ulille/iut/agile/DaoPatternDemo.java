package fr.ulille.iut.agile;

import fr.ulille.iut.agile.beans.Utilisateur;
import fr.ulille.iut.agile.dao.UtilisateurDao;
import fr.ulille.iut.agile.dto.UtilisateurDaoImpl;

import java.util.logging.Logger;

public class DaoPatternDemo {

	private static final Logger LOGGER = Logger.getLogger(DaoPatternDemo.class.getName());
	
	public static void main(String[] args) {
		UtilisateurDao studentDao = new UtilisateurDaoImpl();

		//print all students
		for (Utilisateur utili : studentDao.lister()) {
			LOGGER.info("Utilisateur: [email : " + utili.getEmail() + ", et son mdp : " + utili.getMdp() + " ]");
		}

	}
}
