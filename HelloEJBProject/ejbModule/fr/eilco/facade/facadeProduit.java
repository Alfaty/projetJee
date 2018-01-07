package fr.eilco.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

	public List<Produit> getAllProduit(EntityManager mh) {
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
		Root<Produit> Produit = cq.from(Produit.class);
		cq.select(Produit);	
		TypedQuery<Produit> q = mh.createQuery(cq);
		List<Produit> allProduits = q.getResultList();
		return allProduits;	
}
	
	public List<Produit> getProduitFromCategorie(int idC,EntityManager mh) {
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
		Root<Produit> produit = cq.from(Produit.class);
		cq.select(produit).where(cb.equal(produit.get("id_categorie"), idC));	
		TypedQuery<Produit> q = mh.createQuery(cq);
		List<Produit> allProduits = q.getResultList();
		return allProduits;	
}
	
	
	
}