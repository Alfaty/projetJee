package fr.eilco.facade;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import fr.eilco.model.Produit;

public class facadeProduit {
	public Produit getProduit(int ID, EntityManager mh) {
		// TODO Auto-generated method stub
	    
		//Produit p = new Produit();
		//Query q = mh.createQuery("select p from Produit p where id=:id").setParameter("id", ID);
		//p = (Produit) q.getSingleResult(); 
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(Produit.class);
		Root<Produit> produit = cq.from(Produit.class);
		cq.select(produit).where(cb.equal(produit.get("id"),ID));
		
		
		return (Produit) mh.createQuery(cq).getSingleResult();
		
		
		
}

	
}