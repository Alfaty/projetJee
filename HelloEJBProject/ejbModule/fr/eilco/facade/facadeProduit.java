package fr.eilco.facade;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.eilco.model.Produit;

public class facadeProduit {
	
	public Produit getProduit(int ID, EntityManager mh) {
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
		Root<Produit> produit = cq.from(Produit.class);
		cq.select(produit).where(cb.equal(produit.get("id"),ID));	
		return (Produit) mh.createQuery(cq).getSingleResult();
}

	
}