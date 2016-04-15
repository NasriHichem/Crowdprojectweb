package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    name="type"	    
	)
@NamedQueries({@NamedQuery(name = "getnumbercontributors",
query = "SELECT count(c) FROM Contribuation c WHERE c.project.id=:value"),
 @NamedQuery(name = "getcontributions",
 query = "SELECT c FROM Contribuation c WHERE c.project.id=:value"),
 @NamedQuery(name = "getmycontributions",
 query = "SELECT c FROM Contribuation c WHERE c.participant.id=:value")
 })
public class Contribuation implements Serializable{
	
	@EmbeddedId
	private ContribuationPk pk ;
	@JoinColumn(name="id_participant",insertable=false,updatable=false)
	@ManyToOne
	private Subscriber participant ;
	@JoinColumn(name="id_project",insertable=false,updatable=false)
	@ManyToOne
	private Project project ;
	
	public Contribuation(ContribuationPk pk, Subscriber participant, Project project) {
		super();
		this.pk = pk;
		this.participant = participant;
		this.project = project;
	}
	
	public Contribuation() {
		super();
	}

	public Subscriber getParticipant() {
		return participant;
	}
	public void setParticipant(Subscriber participant) {
		this.participant = participant;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	

}
