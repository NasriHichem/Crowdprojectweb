package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Category;

@Local
public interface CategoryservicesLocal {

	public ArrayList<Category>getList();
	public Category findCategoryByName(String name);
}
