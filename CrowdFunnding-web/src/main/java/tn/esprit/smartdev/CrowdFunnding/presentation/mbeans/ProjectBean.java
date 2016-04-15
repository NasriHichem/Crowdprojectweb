package tn.esprit.smartdev.CrowdFunnding.presentation.mbeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import tn.esprit.smartdev.CrowdFunnding.persistence.Category;
import tn.esprit.smartdev.CrowdFunnding.persistence.Contribuation;
import tn.esprit.smartdev.CrowdFunnding.persistence.FundingContriubation;
import tn.esprit.smartdev.CrowdFunnding.persistence.Project;
import tn.esprit.smartdev.CrowdFunnding.persistence.Subscriber;
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
    private Project project_display=new Project(); 
	private Category category =new Category();
    private  String picture_name;
    private List<String>villes =new ArrayList<>();
    private int number_contriburos ;
    private UploadedFile file;
    private File file_uploaded;
    private String library ;
    private String date_fin ;
    private String day_left ;
    private int numberofprojects;
    private Project selectedproject=new Project();  
   
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

    @PostConstruct
    public void init()
    {
    	RemplirVilles();
    	project_display.setId(1);
    	project_display.setName("Nasri societe");
    	project_display.setTitle("Nasri piece auto");
    	project_display.setShort_presentation("project important");
    	project_display.setDate_publish("2016-04-12");
    	project_display.setDuration(30);
    	project_display.setTurget_funding(100000);
    	Subscriber c=new Subscriber(1, "Hichem", "Nasri","hichem.esprit.tn", "root", "root", 1234567);
    	project_display.setCreator(c);
    	project_display.setCategory(new Category(1, "Art"));
    	number_contriburos=servicecon.getNumberContribuation(project_display.getId());
    	project_display.setContribuations(servicecon.getContribuation(project_display.getId()));
    	Date actuelle = new Date();	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String act = dateFormat.format(actuelle);       
        int difference=	project_display.getDuration()
        -(Integer.parseInt(act.split("-")[2])
        -Integer.parseInt(project_display.getDate_publish().split("-")[2]));
        day_left=String.valueOf(difference);
        numberofprojects=service.getNumberprojectByCreator(project_display.getCreator().getId());
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
	

	public File getFile_uploaded() {
		return file_uploaded;
	}

	public void  setFile_uploaded(File file_uploaded) {
		this.file_uploaded = file_uploaded;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
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

	public String doaddProject()
	{
	Date actuelle = new Date();	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    String act = dateFormat.format(actuelle);
       
		//project.setPicture( file.getContents());
		project.setPicture_project(file.getFileName());
		
		project.setDate_publish(act);
		//project.setCategory(category);	
	    service.addProject(project);
	    return null ;
	   // return "/projects/succes?faces-redirect=true" ;
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
	
	
	 public void upload() {
	        if(file != null) {
	            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	    }
	 
	  public float sum_findings()
	  {
		  float sum =0 ;
		  for(Contribuation c:project_display.getContribuations())
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
		   return( sum_findings()/project_display.getTurget_funding())*100;
	   }
	   public ArrayList<Project>dofindProjectsBycreator()
	   {
		   return service.findProjectsByCreator(1);
	   }

	
	


	
    
	
}
