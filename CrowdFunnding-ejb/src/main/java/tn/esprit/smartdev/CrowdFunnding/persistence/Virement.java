package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "getvirementsbydate",
query = "SELECT v FROM Virement v WHERE v.date=:date")
public class Virement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String donneur_ordre;
	private String ville;
	private Date date;
	private String Location_agence;
	private int num_compte;
	private String nom_prenom_benif;
	private String banque;
	private int num_cmpt_benif;
	private float montant;
	private String objectif_virement;
	private String montant_ltr;
	@ManyToOne
	private Project project;
	@ManyToOne
	private Subscriber subscriber;
	
	
	
	

	public Virement() {
		super();
	}
	public Virement(int id, String donneur_ordre, String ville, Date date, String location_agence, int num_compte,
			String nom_prenom_benif, String banque, int num_cmpt_benif, float montant, String objectif_virement,
			String montant_ltr, Project project,Subscriber subscriber) {
		super();
		this.id = id;
		this.donneur_ordre = donneur_ordre;
		this.ville = ville;
		this.date = date;
		this.Location_agence = location_agence;
		this.num_compte = num_compte;
		this.nom_prenom_benif = nom_prenom_benif;
		this.banque = banque;
		this.num_cmpt_benif = num_cmpt_benif;
		this.montant = montant;
		this.objectif_virement = objectif_virement;
		this.montant_ltr = montant_ltr;
		this.project=project;
		this.subscriber=subscriber;
	}
	public Virement(String donneur_ordre, String ville, Date date, String location_agence, int num_compte,
			String nom_prenom_benif, String banque, int num_cmpt_benif, float montant, String objectif_virement,
			String montant_ltr,Project project,Subscriber subscriber) {
		super();
		this.donneur_ordre = donneur_ordre;
		this.ville = ville;
		this.date = date;
		this.Location_agence = location_agence;
		this.num_compte = num_compte;
		this.nom_prenom_benif = nom_prenom_benif;
		this.banque = banque;
		this.num_cmpt_benif = num_cmpt_benif;
		this.montant = montant;
		this.objectif_virement = objectif_virement;
		this.montant_ltr = montant_ltr;
		this.project=project;
		this.subscriber=subscriber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDonneur_ordre() {
		return donneur_ordre;
	}
	public void setDonneur_ordre(String donneur_ordre) {
		this.donneur_ordre = donneur_ordre;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation_agence() {
		return Location_agence;
	}
	public void setLocation_agence(String location_agence) {
		this.Location_agence = location_agence;
	}
	public int getNum_compte() {
		return num_compte;
	}
	public void setNum_compte(int num_compte) {
		this.num_compte = num_compte;
	}
	public String getNom_prenom_benif() {
		return nom_prenom_benif;
	}
	public void setNom_prenom_benif(String nom_prenom_benif) {
		this.nom_prenom_benif = nom_prenom_benif;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public int getNum_cmpt_benif() {
		return num_cmpt_benif;
	}
	public void setNum_cmpt_benif(int num_cmpt_benif) {
		this.num_cmpt_benif = num_cmpt_benif;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getObjectif_virement() {
		return objectif_virement;
	}
	public void setObjectif_virement(String objectif_virement) {
		this.objectif_virement = objectif_virement;
	}
	public String getMontant_ltr() {
		return montant_ltr;
	}
	public void setMontant_ltr(String montant_ltr) {
		this.montant_ltr = montant_ltr;
	}
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Subscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	
	
}
