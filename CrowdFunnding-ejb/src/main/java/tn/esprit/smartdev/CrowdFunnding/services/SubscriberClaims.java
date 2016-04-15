package tn.esprit.smartdev.CrowdFunnding.services;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.smartdev.CrowdFunnding.persistence.Subscriber;



@Stateless
public class SubscriberClaims implements ISubscriberClaimsRemote,ISubscriberClaimsLocal{

	@PersistenceContext
    EntityManager em ;
    
    
    public void  updateStateClaim(Subscriber c) {
      
       em.merge(c);   		
	}

    public Subscriber findByIdSubscriber (int id){
    	return em.find(Subscriber.class,id);
    }

	@Override
	public void removeSubscriber(Subscriber s) {
		em.remove(em.merge(s));
		
	}
    

    
    
}
