package fr.eilco.facade;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.eilco.model.Categorie;

public class facadeCategorie {
	
	public Categorie getCategorie(int ID, EntityManager mh) {
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery<Categorie> cq = cb.createQuery(Categorie.class);
		Root<Categorie> categorie = cq.from(Categorie.class);
		cq.select(categorie).where(cb.equal(categorie.get("id"),ID));	
		return (Categorie) mh.createQuery(cq).getSingleResult();
}
	
	public ArrayList<Categorie> getAllCategorie(EntityManager mh) {
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery<Categorie> cq = cb.createQuery(Categorie.class);
		Root<Categorie> categorie = cq.from(Categorie.class);
		cq.select(categorie);	
		return (ArrayList<Categorie>) mh.createQuery(cq);
}

	
}