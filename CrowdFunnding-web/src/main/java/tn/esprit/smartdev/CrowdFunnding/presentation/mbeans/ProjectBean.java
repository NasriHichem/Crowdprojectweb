package tn.esprit.smartdev.CrowdFunnding.presentation.mbeans;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.StateManager.SerializedView;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import tn.esprit.smartdev.CrowdFunnding.Utils.Utils;
import tn.esprit.smartdev.CrowdFunnding.persistence.Category;
import tn.esprit.smartdev.CrowdFunnding.persistence.Contribuation;
import tn.esprit.smartdev.CrowdFunnding.persistence.FundingContriubation;
import tn.esprit.smartdev.CrowdFunnding.persistence.Project;
import tn.esprit.smartdev.CrowdFunnding.persistence.Subscriber;
import tn.esprit.smartdev.CrowdFunnding.presentation.converters.Sendmail;
import tn.esprit.smartdev.CrowdFunnding.services.ContribuationServiceLocal;
import tn.esprit.smartdev.CrowdFunnding.services.ProjectsServicesLocal;

@ManagedBean
@ApplicationScoped
public class ProjectBean {
	@EJB
	ProjectsServicesLocal service ;
	@EJB
	ContribuationServiceLocal servicecon ;
	private Project project =new Project() ;
	private List<Project>filteredProjects=new ArrayList<>();
	private List<Project>projects=new ArrayList<>();
    private Project project_display=new Project(); 
	private Category category=new Category();
    private  String picture_name;
    private List<String>villes =new ArrayList<>();
    private int number_contriburos ;
    private UploadedFile file;   
    private String date_fin ;
    private String day_left ;
    private int numberofprojects;
    private Project selectedproject=new Project(); 
    private StreamedContent picture_project;
    private List<StreamedContent>pictures=new ArrayList<>();
    
    private void RemplirVilles()
    {
    	villes.add("Tunis");
    	villes.add("Ben Arous");
    	villes.add("Ariana");
    	villes.add("Manouba");
    	villes.add("Zaghouen");
    	villes.add("Beja");
    	villes.add("Bizerte");
    	villes.add("Nabeul");
    	villes.add("Kef");
    	villes.add("Jandouba");
    	villes.add("Siliana");
    	villes.add("Gassrine");
    	villes.add("Gafsa");
    	villes.add("Sousse");
    	villes.add("Monastir");
    	villes.add("Mahdia");
    	villes.add("Kairouen");
    	villes.add("Sfax");
    	villes.add("Sidi bouzid");
    	villes.add("Touzeur");
    	villes.add("Gbeli");
    	villes.add("Gabes");
    	villes.add("Mednine");
    	villes.add("Tataouine");
    }
       
    private void verifyProject()
       {   	  
    	   Date actuelle=new Date();
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           String act = dateFormat.format(actuelle);
           Calendar cal = Calendar.getInstance();
         
    	   for(Project p:projects)
    	   {
    		 float sum =0 ;
    		 for(Contribuation c:p.getContribuations())
    			  {
    		  if(c instanceof FundingContriubation)
    			  {
    			  sum+=((FundingContriubation) c).getValue_fundings();
    			  }
    			  }
    		     		  
    	        try {
					cal.setTime(dateFormat.parse(p.getDate_publish()));
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
    	        cal.add(Calendar.DAY_OF_MONTH, p.getDuration());    	       
    			if((sum<p.getTurget_funding()&&act.equals(dateFormat.format(cal.getTime()))||
    			 (sum==p.getTurget_funding())))
    			{
    				service.removeProject(p);
    				/*Sendmail sm=new Sendmail(p.getCreator().getEmail(),
    				"You project are faild");
    				try {
						sm.send();
					} catch (AddressException e) {
					} catch (MessagingException e) {
					}*/
    			}}}
    				
    @PostConstruct
    public void init()
    {
    	verifyProject();
    	RemplirVilles();
    	projects=service.getListProjects();
    	for(Project p:projects)
    	{
    		pictures.add(new DefaultStreamedContent(new ByteArrayInputStream(p.getPicture()),
            null));
    	}   	             
    }
   
    public String dorenderDetail()
    {
    	number_contriburos=servicecon.getNumberContribuation(selectedproject.getId());
    	selectedproject.setContribuations(servicecon.getContribuation(selectedproject.getId()));
    	Date actuelle = new Date();	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String act = dateFormat.format(actuelle);       
        int difference=	selectedproject.getDuration()
        -(Integer.parseInt(act.split("-")[2])
        -Integer.parseInt(selectedproject.getDate_publish().split("-")[2]));
        day_left=String.valueOf(difference);
        numberofprojects=service.getNumberprojectByCreator(selectedproject.getCreator().getId());
        picture_project=null ;
        picture_project=new DefaultStreamedContent(new ByteArrayInputStream(selectedproject.getPicture()),
        null);   
        Calendar cal = Calendar.getInstance(); 
    	try {
			cal.setTime(dateFormat.parse(selectedproject.getDate_publish()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cal.add(Calendar.DAY_OF_MONTH, selectedproject.getDuration());
        date_fin = dateFormat.format(cal.getTime());
       return  "/projects/project?faces-redirect=true" ;
    }
    
    public String dorenderaddProject()
    {
    	 return "/projects/propose_project?faces-redirect=true" ;
    }
    public String doaddProject()
	{
	Date actuelle = new Date();	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String act = dateFormat.format(actuelle);
        project.setCreator((Subscriber)Utils.getSession().getAttribute("username"));
		project.setPicture( file.getContents());
		project.setPicture_project(file.getFileName());		
		project.setDate_publish(act);
		project.setCategory(category);	// adhiya debug ??
	    service.addProject(project);
	   
	    return "/projects/succes?faces-redirect=true" ;
	}
	public String dorenderupdateProject()
	{
	
	  return "/projects/update_project?faces-redirect=true" ;
	}
	public String doupdateProject()
	{
	  service.updateProject(selectedproject);
	  return "/projects/myprojects?faces-redirect=true" ;
	}
	public String doremoveProject()
	{
	  service.removeProject(selectedproject);
	  return "/projects/myprojects?faces-redirect=true" ;
	}
	public String dorenderListprojects()
	{
		  return "/projects/listproject?faces-redirect=true" ;
	}
	public StreamedContent findImagebyId(int id)
	{
		int index =0;
	   for(int i=0 ;i<projects.size();i++)
	   {
		   if(projects.get(i).getId()==id)
		   {
			  index=i ;
			  break ;
			  
		   }
	   }
	   return pictures.get(index);
	}
	
	 
   public float sum_findings()
	  {
		  float sum =0 ;
		  for(Contribuation c:selectedproject.getContribuations())
		  {
			  if(c instanceof FundingContriubation)
			  {
				  sum+=((FundingContriubation) c).getValue_fundings();
			  }
		  }
	   return sum ;
	  }

   public float statistic_finding()
	   {
		   return( sum_findings()/selectedproject.getTurget_funding())*100;
	   }
   public ArrayList<Project>dofindProjectsBycreator()
	 {	 
	return service.findProjectsByCreator(((Subscriber)Utils.getSession().getAttribute("username")).getId());
	 }
    
	public Project getProject()
	{
	return  project ;
	}
	
	public void setProject(Project project)
	{
		
		this.project=project ;
	}
	
	public  UploadedFile getFile() {
		return file;
	}

	public void setFile( UploadedFile file) {
		this.file = file;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public List<String> getVilles() {
		return villes;
	}
	public void setVilles(List<String> villes) {
		this.villes = villes;
	}
	
	public Project getProject_display() {
		return project_display;
	}
	public void setProject_display(Project project_display) {
		this.project_display = project_display;
	}
	public int getNumber_contriburos() {
		return number_contriburos;
	}

	public void setNumber_contriburos(int number_contriburos) {
		this.number_contriburos = number_contriburos;
	}
		
	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public String getDay_left() {
		return day_left;
	}

	public void setDay_left(String day_left) {
		this.day_left = day_left;
	}

	public int getNumberofprojects() {
		return numberofprojects;
	}

	public void setNumberofprojects(int numberofprojects) {
		this.numberofprojects = numberofprojects;
	}
	
	
	public Project getSelectedproject() {
		return selectedproject;
	}

	public void setSelectedproject(Project selectedproject) {
		this.selectedproject = selectedproject;
	}

	
	

	public StreamedContent getPicture_project() {
		return picture_project;
	}

	public void setPicture_project(StreamedContent picture_project) {
		this.picture_project = picture_project;
	}

	public List<Project> getFilteredProjects() {
		return filteredProjects;
	}

	public void setFilteredProjects(List<Project> filteredProjects) {
		this.filteredProjects = filteredProjects;
	}

	public void onRowSelect(SelectEvent event){
		FacesMessage msg = new FacesMessage("project selected", ((Project) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage("allo", msg);
		
	}
    
	public void onRowUnselect(UnselectEvent event){
		FacesMessage msg = new FacesMessage("project unselected", ((Project) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage("allo", msg);
	}

	public List<StreamedContent> getPictures() {
		return pictures;
	}

	public void setPictures(List<StreamedContent> pictures) {
		this.pictures = pictures;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	


	
    
	
}
