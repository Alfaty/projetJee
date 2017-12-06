package fr.eilco.EJB;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.facade.facadeCategorie;
import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
public class EJBCategorie implements EJBCategorieRemote, EJBCategorieLocal {

    /**
     * Default constructor. 
     */
    public EJBCategorie() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="managerHello")
    EntityManager mh;
    
    
    void insertEntity(Categorie c) {
    	mh.persist(c);
    	mh.flush();
    	
    }

	public Categorie getCategorie(int ID) {
		// TODO Auto-generated method stub
	   facadeCategorie fc= new facadeCategorie();
	   return fc.getCategorie(ID, mh);
	}








}
