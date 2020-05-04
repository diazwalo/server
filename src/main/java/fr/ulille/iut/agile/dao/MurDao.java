package fr.ulille.iut.agile.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import fr.ulille.iut.agile.beans.Mur;

public interface MurDao {
//CREATE TABLE `Utilisateur` ( `name` TEXT, `mdp` TEXT, `email` TEXT, `identifiant` TEXT, PRIMARY KEY(`identifiant`) );


	@SqlUpdate("CREATE TABLE Utilisateur(name TEXT, mdp TEXT, email TEXT, identifiant TEXT, PRIMARY KEY(identifiant)")
	void creationTable();
	
	@SqlUpdate("INSERT INTO Utilisateur(name,mdp, email, identifiant) VALUES(:name, :mdp, :email, :identifiant)")
	void ajouter(Mur cuve);
	
	@SqlQuery("SELECT * FROM mur")
	List<Mur>lister();
	
	@SqlQuery("SELECT * FROM mur WHERE identifiant = :mno")
	Mur getMur(@Bind("mno") String mno);
	
	@SqlQuery("DELETE FROM mur WHERE identifiant = :mno")
	void deleteMur(@Bind("mno") Mur mno);
	
	@SqlQuery("UPDATE mur SET nom = :nom WHERE id = :mno.getNom()")
	void modifierNom(@Bind("mno")Mur mno, @Bind("nom")String nom);
}
