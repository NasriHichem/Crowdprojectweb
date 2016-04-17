package tn.esprit.smartdev.CrowdFunnding.services;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Subscriber;

@Local
public interface ISubscriberClaimsLocal {
	
	Subscriber findByIdSubscriber (int id);
	void  updateStateClaim(Subscriber cr);
	public void removeSubscriber(Subscriber s);

}
