package fr.eilco.facade;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.eilco.model.Client;

public class facadeClient {
	public Client getClient(int ID, EntityManager mh) {
		
		
		CriteriaBuilder cb = mh.getCriteriaBuilder();
		CriteriaQuery<Client> cq = cb.createQuery(Client.class);
		Root<Client> client = cq.from(Client.class);
		cq.select(client).where(cb.equal(client.get("id"),ID));
		
		
		return (Client) mh.createQuery(cq).getSingleResult();
		
		
		
}
}
