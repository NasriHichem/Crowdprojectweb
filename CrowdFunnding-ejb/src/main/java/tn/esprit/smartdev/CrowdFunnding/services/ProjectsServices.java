package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import tn.esprit.smartdev.CrowdFunnding.persistence.Project;




@Stateless
public class ProjectsServices implements ProjectsServicesRemote,ProjectsServicesLocal {

	@PersistenceContext
    EntityManager em; 
    public ProjectsServices() {
       
    }

	@Override
	public ArrayList<Project> findProjectsByCategory(String category) {
		
		Query queryfindByCategory = em.createNamedQuery("findByCategory");
		queryfindByCategory.setParameter("category",category);
		return (ArrayList<Project>) queryfindByCategory.getResultList();
	}

	@Override
	public void addProject(Project p) {
		em.persist(p);
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Project> getListProjects() {
		return (ArrayList<Project>) em.createQuery("select p from Project p ").getResultList();
	}

	@Override
	public ArrayList<Project> getProjectsnoConfirmed(int value) {
		Query querygetprojectsnoconfirmed= em.createNamedQuery("getprojectsnoconfirmed");
		querygetprojectsnoconfirmed.setParameter("value",value);
		return (ArrayList<Project>)querygetprojectsnoconfirmed.getResultList();
	}

	@Override
	public void removeProject(Project p) {
		em.remove(em.merge(p));
		
	}

	@Override
	public int getNumberProjectsByDate(String date1,String date2) {
		Query querygetcountofprojectsbydate = em.createNamedQuery("getcountofprojectsbydate");
		querygetcountofprojectsbydate.setParameter("date1",date1);
		querygetcountofprojectsbydate.setParameter("date2",date2);
		 
		int result=((Long)querygetcountofprojectsbydate.getSingleResult()).intValue();
		return result ;
		
	}

	@Override
	public void confirmProject(Project p) {
		em.merge(p);
		
	}

	@Override
	public ArrayList<Project> findProjectByName(String name) {
		Query querygetprojectsbyname= em.createNamedQuery("getprojectsbyname");
		querygetprojectsbyname.setParameter("name",name);
		return (ArrayList<Project>)querygetprojectsbyname.getResultList();
	}

	@Override
	public int getNumberprojectByCreator(int id) {
		Query querygetcountofprojectsbycreator = em.createNamedQuery("getnumberprojectbycreator");
		querygetcountofprojectsbycreator.setParameter("value",id);		 
		int result=((Long)querygetcountofprojectsbycreator.getSingleResult()).intValue();
		return result ;
	}

	@Override
	public ArrayList<Project> findProjectsByCreator(int id) {
		Query queryfindprojectsbycreator = em.createNamedQuery("findprojectsbycreator");
		queryfindprojectsbycreator.setParameter("value",id);
		return (ArrayList<Project>) queryfindprojectsbycreator.getResultList();
	}

	@Override
	public void updateProject(Project p) {
		em.persist(em.merge(p));
		
	}

	

}
