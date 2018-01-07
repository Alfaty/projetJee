package fr.eilco.EJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import fr.eilco.model.Categorie;

@Remote
public interface EJBCategorieRemote {

	public Categorie getCategorie(int ID);
	public List<Categorie> getAllCategorie();

		
}
