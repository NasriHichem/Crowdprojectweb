package tn.esprit.smartdev.CrowdFunnding.services;

import javax.ejb.Remote;


import tn.esprit.smartdev.CrowdFunnding.persistence.Subscriber;



@Remote
public interface ISubscriberClaimsRemote {
	Subscriber findByIdSubscriber (int id);
	void  updateStateClaim(Subscriber cr);
	public void removeSubscriber(Subscriber s);

}
