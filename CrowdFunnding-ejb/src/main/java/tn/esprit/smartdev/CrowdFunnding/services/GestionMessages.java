package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.smartdev.CrowdFunnding.persistence.Message;



@Stateless
public class GestionMessages implements GestionMessageRemote,GestionMessageLocal{
	 @PersistenceContext
	  EntityManager em;

	@Override
	public void SendMessageByModerator(Message M) {
		//Query query = em.createQuery("select a from Administrator a where type =: 'simpleadmin'");
	
		
			em.persist(M);
		
	}
	@Override
	public void SendMessageBySubscriber(Message M) {	
		
		em.persist(em.merge(M));
		
	}

	@Override
	public ArrayList<Message> FindAllMessageofModirator() {
		ArrayList<Message>messages=new ArrayList<>();
		messages=(ArrayList<Message>) em.createQuery("select m from Message m where administrator_id= 2")
	   .getResultList();
		return messages;
	}
public ArrayList<Message> FindReceivedMessages(int id) {
		
		Query queryfindmessagesbyreceiver = em.createNamedQuery("findmessagesbyreceiver");
		queryfindmessagesbyreceiver .setParameter("value",id);
		return (ArrayList<Message>) queryfindmessagesbyreceiver.getResultList();
	}
		
	

	@Override
	public void removeMessage(Message m) {
		 em.remove(em.merge(m));
		
	}

	@Override
	public ArrayList<Message> FindAllMessageofAdmin() {
		ArrayList<Message>messages=new ArrayList<>();
		messages=(ArrayList<Message>) em.createQuery("select m from Message m where administrator_id= 1")
	.getResultList();
		return messages;
	}

	@Override
	public int getNumberofmessagesbyadminbydate(String date1, String date2) {
		Query querygetcountmessagesbydate = em.createNamedQuery("getcountofmessagesbyadminbydate");
		querygetcountmessagesbydate .setParameter("date1",date1);
		querygetcountmessagesbydate .setParameter("date2",date2);
		 
		int result=((Long)querygetcountmessagesbydate .getSingleResult()).intValue();
		return result;
	}
	@Override
	public int getNumberofmessagesbymodiratorbydate(String date1, String date2) {
		Query querygetcountmessagesbydate = em.createNamedQuery("getcountofmessagesbymodiratorbydate");
		querygetcountmessagesbydate .setParameter("date1",date1);
		querygetcountmessagesbydate .setParameter("date2",date2);
		 
		int result=((Long)querygetcountmessagesbydate .getSingleResult()).intValue();
		return result;
	}
	 

}
