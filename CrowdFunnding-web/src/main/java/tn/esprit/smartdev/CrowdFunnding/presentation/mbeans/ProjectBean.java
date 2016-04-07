package tn.esprit.smartdev.CrowdFunnding.presentation.mbeans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import tn.esprit.smartdev.CrowdFunnding.persistence.Category;
import tn.esprit.smartdev.CrowdFunnding.persistence.Project;
import tn.esprit.smartdev.CrowdFunnding.services.ProjectsServicesLocal;

@ManagedBean
public class ProjectBean {
	@EJB
	ProjectsServicesLocal service ;
	private Project project =new Project() ;
	private Part file1;
    private  String picture_name;

   
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
	
	public Project getProject()
	{
	return  project ;
	}
	
	public void setProject(Project project)
	{
		
		this.project=project ;
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
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  service.addProject(project);
	  return "projects/propose_project" ;
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

	
    
	
}
