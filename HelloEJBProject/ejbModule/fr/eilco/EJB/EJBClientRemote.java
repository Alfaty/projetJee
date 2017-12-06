package fr.eilco.EJB;

import javax.ejb.Remote;

import fr.eilco.model.Client;

@Remote
public interface EJBClientRemote {

	public Client getClient(int ID);
		
}