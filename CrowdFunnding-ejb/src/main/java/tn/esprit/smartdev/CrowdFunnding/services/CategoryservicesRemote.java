package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import tn.esprit.smartdev.CrowdFunnding.persistence.Category;



@Remote
public interface CategoryservicesRemote {
	
	
	public ArrayList<Category>getList();

}
