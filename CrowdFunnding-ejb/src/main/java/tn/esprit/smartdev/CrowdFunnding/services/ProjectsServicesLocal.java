package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Project;



@Local
public interface ProjectsServicesLocal {
	
	public void  addProject(Project p);
	public ArrayList<Project> getListProjects();
	public ArrayList<Project> getConfirmedProjects();
	public int getNumberprojectByCreator(int id );
	public ArrayList<Project>findProjectsByCreator(int id);
	public void removeProject(Project p);
	public void updateProject(Project p);
	public Project findprojectById(int id );
	

}
