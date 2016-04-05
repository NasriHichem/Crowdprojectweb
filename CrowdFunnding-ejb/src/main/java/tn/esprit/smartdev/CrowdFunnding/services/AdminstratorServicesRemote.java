package tn.esprit.smartdev.CrowdFunnding.services;

import javax.ejb.Remote;

import tn.esprit.smartdev.CrowdFunnding.persistence.Adminstrator;




@Remote
public interface AdminstratorServicesRemote {
	boolean addAdminstrator(Adminstrator adminstrator);
	Adminstrator authentificate(String login, String password);
}
