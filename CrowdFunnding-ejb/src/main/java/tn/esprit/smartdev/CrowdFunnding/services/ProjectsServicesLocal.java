package tn.esprit.smartdev.CrowdFunnding.services;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Project;



@Local
public interface ProjectsServicesLocal {
	
	public void  addProject(Project p);

}
