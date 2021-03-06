package fr.eilco.EJB;

import java.util.List;

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

    public EJBProduit() {
    }

    @PersistenceContext(unitName="managerHello")
    EntityManager mh;
    
    
    void insertEntity(Produit p) {
    	mh.persist(p);
    	mh.flush();
    }


	public Produit getProduit(int ID) {
	   facadeProduit fp= new facadeProduit();
	   return fp.getProduit(ID, mh);
	}
	
	public List<Produit> getAllProduit(){
		facadeProduit fp= new facadeProduit();
		return fp.getAllProduit(mh);
	}
	
	public List<Produit> getProduitFromCategorie(int idC){
		facadeProduit fp= new facadeProduit();
		return fp.getProduitFromCategorie(idC,mh);
	}

}
