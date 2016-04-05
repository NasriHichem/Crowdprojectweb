package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.smartdev.CrowdFunnding.persistence.Category;



@Stateless

public class Categoryservices implements CategoryservicesRemote, CategoryservicesLocal {

	@PersistenceContext
    EntityManager em; 
    public Categoryservices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Category> getList() {
		return (ArrayList<Category>) em.createQuery("select c from Category c ").getResultList();
		
	}

   

    

}
