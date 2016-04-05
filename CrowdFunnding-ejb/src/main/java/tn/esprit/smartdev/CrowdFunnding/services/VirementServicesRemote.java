package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import tn.esprit.smartdev.CrowdFunnding.persistence.Virement;



@Remote
public interface VirementServicesRemote {

	void addVirement(Virement v);

	ArrayList<Virement> getListVirement();

	void removeVirement(Virement v);

	ArrayList<Virement> findVirementByDate(Date date);

}
