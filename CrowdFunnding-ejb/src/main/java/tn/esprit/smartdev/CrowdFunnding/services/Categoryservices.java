package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	@Override
	public Category findCategoryByName(String name) {
		Category found = null;
		TypedQuery<Category> query = em.createQuery(
				"select c from Category c where c.Name_category()=:x", Category.class);
		query.setParameter("x", name);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no category with name=" + name);
		}
		return found;
	}

   

    

}
