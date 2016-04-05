package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Magazine;

@Local
public interface MagazineServicesLocal {
	
	public void addMagazine(Magazine m);

	public ArrayList<Magazine> getListMagazine();

	public void removeMagazine(Magazine m);

	public ArrayList<Magazine> findMagazineByDate(Date date);

	public void updateMagazine(Magazine m);

}
