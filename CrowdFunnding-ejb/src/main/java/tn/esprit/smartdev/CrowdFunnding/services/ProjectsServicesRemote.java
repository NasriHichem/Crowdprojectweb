package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.smartdev.CrowdFunnding.persistence.Project;


@Remote
public interface ProjectsServicesRemote {
	
	
	public void removeProject(Project p);
	public ArrayList<Project> getListProjects();
	public ArrayList<Project>findProjectsByCategory(String category);
	public ArrayList<Project>findProjectByName(String name);
	public ArrayList<Project>getProjectsnoConfirmed(int value);
	public int getNumberProjectsByDate(String date1, String date2 );
	public void confirmProject(Project p);

}
