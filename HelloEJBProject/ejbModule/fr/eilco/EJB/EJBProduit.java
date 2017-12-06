package fr.eilco.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
<<<<<<< HEAD
=======

>>>>>>> 34ebca0c674a5c3a1d3e5af28c607a60e4e31612
import fr.eilco.facade.facadeProduit;
import fr.eilco.model.Produit;
/**
 * Session Bean implementation class EJBProduit
 */
@Stateless(mappedName = "CategorieJNDI")
public class EJBProduit implements EJBProduitRemote, EJBProduitLocal {

    public EJBProduit() {
    }

    @PersistenceContext(unitName="managerHello")
    EntityManager mh;
    
    
    void insertEntity(Produit p) {
    	mh.persist(p);
    	mh.flush();
    }


<<<<<<< HEAD


	@Override
=======
>>>>>>> 34ebca0c674a5c3a1d3e5af28c607a60e4e31612
	public Produit getProduit(int ID) {
	   facadeProduit fp= new facadeProduit();
	   return fp.getProduit(ID, mh);
	}
}
