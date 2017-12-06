package fr.eilco.EJB;

import javax.ejb.Remote;

import fr.eilco.model.Client;
import fr.eilco.model.Produit;

@Remote
public interface EJBProduitRemote {

	public Produit getProduit(int ID);
		
}
