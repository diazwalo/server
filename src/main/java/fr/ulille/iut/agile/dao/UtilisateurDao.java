package fr.ulille.iut.agile.dao;

import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;


import fr.ulille.iut.agile.beans.Utilisateur;

public interface UtilisateurDao {

	@SqlUpdate("CREATE TABLE Utilisateur ( name TEXT, mdp TEXT, email TEXT, identifiant TEXT, PRIMARY KEY(identifiant)")
	void creationTable();

	@SqlUpdate("INSERT INTO Utilisateur(name,mdp, email, identifiant) VALUES(:name, :mdp, :email, :identifiant)")
	void ajouter(Utilisateur util);

	@SqlQuery("SELECT * FROM utilisateur")
	@RegisterBeanMapper(Utilisateur.class)
	List<Utilisateur>lister();

	@SqlQuery("SELECT * FROM utilisateur WHERE identifiant = :uno")
	@RegisterBeanMapper(Utilisateur.class)
	Utilisateur getUtilisateur(@Bind("uno") String uno);
	
	@SqlQuery("DELETE FROM utilisateur WHERE identifiant = :uno")
	@RegisterBeanMapper(Utilisateur.class)
	void deleteUtilisateur(@Bind("uno") String uno);
}

