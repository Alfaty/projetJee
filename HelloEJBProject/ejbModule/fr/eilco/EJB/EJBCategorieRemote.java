package fr.eilco.EJB;

import javax.ejb.Remote;
import fr.eilco.model.Categorie;


public interface EJBCategorieRemote {

	
	public Categorie getCategorie(int ID);
}
