package fr.eilco.EJB;

import javax.ejb.Remote;

import fr.eilco.model.Categorie;

@Remote
public interface EJBCategorieRemote {

	public Categorie getCategorie(int ID);
		
}
