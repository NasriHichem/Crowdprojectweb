package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.smartdev.CrowdFunnding.persistence.Magazine;



@Stateless
public class MagazineServices implements MagazineServicesRemote,MagazineServicesLocal {

	@PersistenceContext
    EntityManager em; 
    public MagazineServices() {
       
    }
	@Override
	public void addMagazine(Magazine m) {
		em.persist(m);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Magazine> getListMagazine() {
		return (ArrayList<Magazine>) em.createQuery("select m from Magazine m ").getResultList();
	}
	@Override
	public void removeMagazine(Magazine m) {
		em.remove(em.find(Magazine.class,m.getId()));	
	}
	@Override
	public void updateMagazine(Magazine m){
		em.merge(m);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Magazine> findMagazineByDate(Date date) {
		Query querygetmagazinesbydate= em.createNamedQuery("getmagazinesbydate");
		querygetmagazinesbydate.setParameter("date",date);
		return (ArrayList<Magazine>)querygetmagazinesbydate.getResultList();
	}
	

}
