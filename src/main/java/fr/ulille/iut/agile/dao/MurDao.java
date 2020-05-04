package fr.ulille.iut.agile.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import fr.ulille.iut.agile.beans.Mur;

public interface MurDao {
//CREATE TABLE Utilisateur ( name TEXT, mdp TEXT, email TEXT, identifiant TEXT, PRIMARY KEY(identifiant) );


	@SqlUpdate("CREATE TABLE Mur ( mno TEXT, nom TEXT, geolocalisation TEXT, superficie INTEGER, identifianUtili TEXT, FOREIGN KEY(identifianUtili) REFERENCES Utilisateur(identifiant), PRIMARY KEY(mno)")
	void creationTable();
	
	@SqlUpdate("INSERT INTO Utilisateur(mno, nom, geolocalisation,superficie,identifianUtil) VALUES(:mno, :nom, :geolocalisation,:superficie, :identifianUtil)")
	void ajouter(Mur cuve);
	
	@SqlQuery("SELECT * FROM mur")
	List<Mur>lister();
	
	@SqlQuery("SELECT * FROM mur WHERE identifiant = :mno")
	Mur getMur(@Bind("mno") String mno);
	
	@SqlQuery("DELETE FROM mur WHERE identifiant = :mno")
	void deleteMur(@Bind("mno") Mur mno);
	
	@SqlQuery("UPDATE mur SET nom = :nom WHERE id = :mno")
	void modifierNom(@Bind("mno")Mur mno, @Bind("nom")String nom);
}
