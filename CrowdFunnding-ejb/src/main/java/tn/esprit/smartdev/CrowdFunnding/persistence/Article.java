package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "getarticlesbydate",
query = "SELECT a FROM Article a WHERE a.date=:date")

public class Article implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String title ;
	private String description;
	private String date;
	private String personal_opinion;
	@OneToOne 
	private Project project;
	@ManyToOne(cascade=CascadeType.ALL)
	private Magazine magazine;
	
	
	
	public Article() {
		super();
	}
	public Article(int id, String title, String description, String date, Project project, Magazine magazine,String personal_opinion) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.project = project;
		this.magazine = magazine;
		this.personal_opinion=personal_opinion;
	}
	public Article(String title, String description, String date, Project project, Magazine magazine,String personal_opinion) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.project = project;
		this.magazine = magazine;
		this.personal_opinion=personal_opinion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Magazine getMagazine() {
		return magazine;
	}
	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
	public String getPersonal_opinion() {
		return personal_opinion;
	}
	public void setPersonal_opinion(String personal_opinion) {
		this.personal_opinion = personal_opinion;
	}
	
	
}
