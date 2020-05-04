package fr.ulille.iut.agile.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import fr.ulille.iut.agile.beans.Cuve;


public interface CuveDao {
	
	@SqlUpdate("CREATE TABLE Cuve (cno TEXT, capacite INTEGER, quantitéActuel INTEGER, nom TEXT, mno INTEGER, FOREIGN KEY(mno) REFERENCES Mur(mno), PRIMARY KEY(cno) ")
	void creationTable();
	
	@SqlUpdate("INSERT INTO Utilisateur(cno,capacite, quantitéActuel, nom, mno) VALUES(:cno,:capacite, :quantitéActuel, :nom, :mno)")
	void ajouter(Cuve cuve);
	
	@SqlQuery("SELECT * FROM cuve")
	List<Cuve>lister();
	
	@SqlQuery("SELECT * FROM utilisateur WHERE identifiant = :cno")
	Cuve getCuve(@Bind("cno") String cno);
	
	@SqlQuery("DELETE FROM cuve WHERE identifiant = :cno")
	void deleteCuve(@Bind("cno") Cuve uno);
	
	@SqlQuery("UPDATE cuve SET nom = :nom WHERE id = :cuve")
	void modifierNom(@Bind("cuve")Cuve cuve, @Bind("nom")String nom);
}
