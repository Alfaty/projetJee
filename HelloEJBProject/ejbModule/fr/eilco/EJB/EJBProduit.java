package fr.eilco.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.eilco.facade.facadeProduit;
import fr.eilco.model.Produit;
/**
 * Session Bean implementation class EJBProduit
 */
@Stateless(mappedName = "CategorieJNDI")
public class EJBProduit implements EJBProduitRemote, EJBProduitLocal {

    /**
     * Default constructor. 
     */
    public EJBProduit() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="managerHello")
    EntityManager mh;
    
    
    void insertEntity(Produit p) {
    	mh.persist(p);
    	mh.flush();
    	
    }




	@Override
	public Produit getProduit(int ID) {
		// TODO Auto-generated method stub
	   facadeProduit fp= new facadeProduit();
	   return fp.getProduit(ID, mh);
	}







	/*		*/
}
