package fr.eilco.facade;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.eilco.model.Categorie;

public class facadeCategorie {
	public Categorie getCategorie(int ID, EntityManager mh) {

		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(Categorie.class);
		Root<Categorie> Categorie = cq.from(Categorie.class);
		cq.select(Categorie).where(cb.equal(Categorie.get("id"),ID));
		
		
		return (Categorie) mh.createQuery(cq).getSingleResult();
	}
}
