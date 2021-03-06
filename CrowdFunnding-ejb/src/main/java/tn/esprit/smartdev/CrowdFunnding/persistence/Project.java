package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;







@Entity
@NamedQueries({@NamedQuery(name = "findByCategory",
query = "SELECT p FROM Project p ,Category c WHERE p.category.id =c.id and "
+ "p.category.name_category=:category"),
	@NamedQuery(name = "getprojectsnoconfirmed",
	query = "SELECT p FROM Project p WHERE p.is_confirmed =:value"),
	
	@NamedQuery(name = "getcountofprojectsbydate",
	query = "SELECT count(p) FROM Project p WHERE p.date_publish BETWEEN :date1 AND :date2"),
	
	@NamedQuery(name = "getprojectsbyname",
	query = "SELECT p FROM Project p WHERE p.name=:name"),

   @NamedQuery(name = "getnumberprojectbycreator",
   query = "SELECT count(p) FROM Project p WHERE p.creator.id=:value"),
   
   @NamedQuery(name = "findprojectsbycreator",
   query = "SELECT p FROM Project p WHERE p.creator.id=:value"),
   
   @NamedQuery(name = "getconfirmedprojects",
   query = "SELECT p FROM Project p WHERE p.is_confirmed=1")
})
public class Project implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String name;
	private String title ;
	private String short_presentation;
	private int  duration ;
	private float turget_funding ;
	@Column(nullable=true)
	private String picture_project ;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(length=65535)
	private byte[] picture=new byte[65535];
	private String location ;
	@Column(nullable=true)
	private int  is_confirmed ;
	@Column(nullable=true)
	private int is_validate ;
	@Column(nullable=true)
	private String date_publish ;
	@ManyToOne
	private Subscriber creator ;
	@ManyToOne
	private Category category ;
	@OneToMany(mappedBy="project",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)	
	private List<Contribuation>contribuations;
	@OneToMany(mappedBy="project")
	private List<Virement>virements;
	@ManyToOne
	private Virement virement;
	public Project() {
		super();
	}

	public Project(int id, String name, String title, String short_presentation, int duration,
			float turget_funding, String picture_project, String location,int is_confirmed,
		  String date_publish,  int is_validate,Subscriber creator,Category category,
		 List<Contribuation>contribuations,byte[]picture ) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.short_presentation = short_presentation;
		this.duration = duration;
		this.turget_funding = turget_funding;
		this.picture_project = picture_project;
		this.location = location;
		this.is_confirmed=is_confirmed ;
		this.is_validate=is_validate ;
		this.date_publish=date_publish;
		this.creator=creator ;
		this.category=category ;
		this.contribuations=contribuations;
		this.picture=picture;
	
	}
	public Project(String name, String title, String short_presentation, int duration,
	   float turget_funding, String location,
	   Subscriber creator,Category category) {
		super();		
		this.name = name;
		this.title = title;
		this.short_presentation = short_presentation;
		this.duration = duration;
		this.turget_funding = turget_funding;		
		this.location = location;	
		this.creator=creator ;
		this.category=category ; }
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShort_presentation() {
		return short_presentation;
	}
	public void setShort_presentation(String short_presentation) {
		this.short_presentation = short_presentation;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public float getTurget_funding() {
		return turget_funding;
	}
	public void setTurget_funding(float turget_funding) {
		this.turget_funding = turget_funding;
	}
	public String getPicture_project() {
		return picture_project;
	}
	public void setPicture_project(String picture_project) {
		this.picture_project = picture_project;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public int isIs_confirmed() {
		return is_confirmed;
	}

	public void setIs_confirmed(int is_confirmed) {
		this.is_confirmed = is_confirmed;
	}
	
	public int isIs_validate() {
		return is_validate;
	}

	public void setIs_validate(int is_validate) {
		this.is_validate = is_validate;
	}
    
	
	public String getDate_publish() {
		return date_publish;
	}

	public void setDate_publish(String date_publish) {
		this.date_publish = date_publish;
	}

	public Subscriber getCreator() {
		return creator;
	}
	public void setCreator(Subscriber creator) {
		this.creator = creator;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Contribuation> getContribuations() {
		return contribuations;
	}

	public void setContribuations(List<Contribuation> contribuations) {
		this.contribuations = contribuations;
	}
	public List<Virement> getVirements() {
		return virements;
	}

	public void setVirements(List<Virement> virements) {
		this.virements = virements;
	}

	public Virement getVirement() {
		return virement;
	}

	public void setVirement(Virement virement) {
		this.virement = virement;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	

	
	
	
	

}
