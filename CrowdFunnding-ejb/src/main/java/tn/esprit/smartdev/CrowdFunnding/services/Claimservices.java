package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.smartdev.CrowdFunnding.persistence.Claim;



@Stateless
public class Claimservices implements ClaimservicesRemote,ClaimservicesLocal  {

	@PersistenceContext
	   EntityManager em;
	    public Claimservices() {
	        
	    }

		@Override
		public void removeClaim(Claim c) {
			em.remove(em.merge(c));
			
		}

		

		@Override
		public ArrayList<Claim> getListclaimnonconfirm() {
			
			return (ArrayList<Claim>) em.createQuery("select c from Claim c ").getResultList();
		}

		@Override
		public void update(Claim c) {
			em.merge(c);
			
		}

		@Override
		public ArrayList<Claim> getclaimByclaiming(String txtclaiming) {
			Query querygetclaimbyclaiming=em.createNamedQuery("Findbyclaiming");
			txtclaiming="%"+txtclaiming+"%";
			querygetclaimbyclaiming.setParameter("txtclaiming", txtclaiming);
			return (ArrayList<Claim>) querygetclaimbyclaiming.getResultList();
		}

		@Override
		public Long getclaimbymonth(String date1, String date2) {
			Query querygetclaimbymonth=em.createNamedQuery("Findbymonth");
			querygetclaimbymonth.setParameter("date1", date1);
			querygetclaimbymonth.setParameter("date2", date2);
			return (Long) querygetclaimbymonth.getSingleResult();
		}
	


	
}
