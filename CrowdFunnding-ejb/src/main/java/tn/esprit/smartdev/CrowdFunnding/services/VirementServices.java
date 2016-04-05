package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.smartdev.CrowdFunnding.persistence.Virement;



@Stateless
public class VirementServices implements VirementServicesRemote,VirementServicesLocal {

	@PersistenceContext
    EntityManager em; 
	
    public VirementServices() {  
    }
    
    @Override
	public void addVirement(Virement v) {
		em.persist(v);
		
	}
    @SuppressWarnings("unchecked")
	@Override
	public ArrayList<Virement> getListVirement() {
		return (ArrayList<Virement>) em.createQuery("select v from Virement v").getResultList();
	}
	@Override
	public void removeVirement (Virement v) {
		em.remove(em.merge(v));
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Virement> findVirementByDate(Date date) {
		Query querygetVirementsbydate = em.createNamedQuery("getVirementsbydate");
		querygetVirementsbydate.setParameter("date", date);
		return (ArrayList<Virement>) querygetVirementsbydate.getResultList();
	}

}
