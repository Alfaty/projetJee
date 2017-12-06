package fr.eilco.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.eilco.facade.facadeClient;
import fr.eilco.model.Client;

@Stateless(mappedName = "ClientJNDI")
public class EJBClient implements EJBClientRemote, EJBClientLocal {
	
	
	    public EJBClient() {
	    }

	    @PersistenceContext(unitName="managerHello")
	    EntityManager mh;
	    
	    void insertEntity(Client c) {
	    	mh.persist(c);
	    	mh.flush();
	    	
	    }

		public Client getClient(int ID) {
		   facadeClient fc= new facadeClient();
		   return fc.getClient(ID, mh);
		}
	}