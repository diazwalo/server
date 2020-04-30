package fr.ulille.iut.agile.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import fr.ulille.iut.agile.beans.Utilisateur;

public interface UtilisateurDao {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS utilisateur (id INTEGER PRIMARY KEY, name VARCHAR UNIQUE NOT NULL)")
	void creationTable();

	@SqlUpdate("INSERT INTO utilisateur (util) VALUES (:util)")
	void ajouter(Utilisateur util);

	@SqlQuery("SELECT * FROM utilisateur")
	@RegisterBeanMapper(Utilisateur.class)
	List<Utilisateur>lister();

	@SqlQuery("SELECT * FROM utilisateur WHERE identifiant = :uno")
	@RegisterBeanMapper(Utilisateur.class)
	Utilisateur getUtilisateur(String uno);
	
	@SqlQuery("DELETE FROM utilisateur WHERE identifiant = :uno")
	@RegisterBeanMapper(Utilisateur.class)
	void deleteUtilisateur(String uno);
}