package fr.eilco.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.eilco.facade.facadeCategorie;
import fr.eilco.model.Categorie;
/**
 * Session Bean implementation class EJBCategorie
 */
@Stateless(mappedName = "CategorieJNDI")
public class EJBCategorie implements EJBCategorieRemote, EJBCategorieLocal {

    public EJBCategorie() {
    }

    @PersistenceContext(unitName="managerHello")
    EntityManager mh;
    
    
    void insertEntity(Categorie p) {
    	mh.persist(p);
    	mh.flush();
    }


	public Categorie getCategorie(int ID) {
	   facadeCategorie fc= new facadeCategorie();
	   return fc.getCategorie(ID, mh);
	}
}

