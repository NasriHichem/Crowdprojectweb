package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("sourcing")
public class SourcingContribuation extends Contribuation implements Serializable {

	private String idea ;
	
	
	public SourcingContribuation() {
		
	}
	public SourcingContribuation(ContribuationPk pk, Subscriber participant, Project project,String idea) {
		super(pk, participant, project);
		this.idea=idea ;
		
	}
	public String getIdea() {
		return idea;
	}
	public void setIdea(String idea) {
		this.idea = idea;
	}
	
	
	

}
