package fr.eilco.EJB;

import java.util.List;

import javax.ejb.Remote;

import fr.eilco.model.Produit;

@Remote
public interface EJBProduitRemote {

	public Produit getProduit(int ID);
	public List<Produit> getAllProduit();
		
}
