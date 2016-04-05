package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Virement;

@Local
public interface VirementServicesLocal {
	
	void addVirement(Virement v);

	ArrayList<Virement> getListVirement();

	void removeVirement(Virement v);

	ArrayList<Virement> findVirementByDate(Date date);

}
