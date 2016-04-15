package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@DiscriminatorValue("funding")
@Entity

public class FundingContriubation  extends Contribuation implements Serializable{
    	
	private float value_fundings;
	
	public FundingContriubation() {
		
	}
	public FundingContriubation(ContribuationPk pk, Subscriber participant, Project project
			,float value_fundings) {
		super(pk, participant, project);
		this.value_fundings=value_fundings;
		
	}
	public float getValue_fundings() {
		return value_fundings;
	}
	public void setValue_fundings(float value_fundings) {
		this.value_fundings = value_fundings;
	}
	

}
