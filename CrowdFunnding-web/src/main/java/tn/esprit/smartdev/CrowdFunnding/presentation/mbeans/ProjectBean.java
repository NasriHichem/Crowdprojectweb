package tn.esprit.smartdev.CrowdFunnding.presentation.mbeans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import tn.esprit.smartdev.CrowdFunnding.persistence.Category;
import tn.esprit.smartdev.CrowdFunnding.persistence.Creator;
import tn.esprit.smartdev.CrowdFunnding.persistence.Project;
import tn.esprit.smartdev.CrowdFunnding.services.ContribuationServiceLocal;
import tn.esprit.smartdev.CrowdFunnding.services.ProjectsServicesLocal;

@ManagedBean
public class ProjectBean {
	@EJB
	ProjectsServicesLocal service ;
	@EJB
	ContribuationServiceLocal servicecon ;
	private Project project =new Project() ;	
    private Project project_display=new Project(); 
	private Category category =new Category();
	private Part file1;
    private  String picture_name;
    private List<String>villes =new ArrayList<>();
    private int number_contriburos ;


    @PostConstruct
    public void init()
    {
    	villes.add("Tunis");
    	villes.add("Bizerte");
    	villes.add("Nabeul");
    	project_display.setId(1);
    	project_display.setName("Nasri societe");
    	project_display.setTitle("Nasri piece auto");
    	project_display.setShort_presentation("project important");
    	project_display.setDate_publish("2016-03-12");
    	Creator c=new Creator(1, "Hichem", "Nasri","hichem.esprit.tn", "root", "root", 1234567);
    	project_display.setCreator(c);
    	project_display.setCategory(new Category(1, "Art"));
    	number_contriburos=servicecon.getNumberContribuation(1);
    	
    }
	 
	public Project getProject()
	{
	return  project ;
	}
	
	public void setProject(Project project)
	{
		
		this.project=project ;
	}
	
	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
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
	
	
	public String doaddProject()
	{
	Date actuelle = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    String act = dateFormat.format(actuelle);
	  try {
		upload();
		project.setPicture_project(picture_name);
		project.setDate_publish(act);
		project.setCategory(category);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  service.addProject(project);
	  return "/projects/succes?faces-redirect=true" ;
	}
	public void  upload() throws IOException {
	    InputStream inputStream = file1.getInputStream();        
	    FileOutputStream outputStream = new FileOutputStream(getFilename(file1));	        
	    byte[] buffer = new byte[4096];        
	    int bytesRead = 0;
	      while(true) {                        
	        bytesRead = inputStream.read(buffer);
	        if(bytesRead > 0) {
	        outputStream.write(buffer, 0, bytesRead);
	        }else {
	        break;
	        }                       
	        }
	        outputStream.close();
	        inputStream.close();
	       
	        
	    }
	 
	 private  String getFilename(Part part) {
	     for (String cd : part.getHeader("content-disposition").split(";")) {
	     if (cd.trim().startsWith("filename")) {
         String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
         picture_name =filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	     return   picture_name ;
	     }
	     }
	     return null;
	    }
	 
	private   int doNumberContributors( )
	{
		//number_contriburos=servicecon.getNumberContribuation(1);
		return 0 ;
	}

	
	


	
    
	
}
