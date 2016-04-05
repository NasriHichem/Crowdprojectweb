package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Claim;
import tn.esprit.smartdev.CrowdFunnding.persistence.Subscriber;


@Local
public interface IProjectsClaimsLocal {
	
	
void update(Claim c);
	
	public ArrayList<Claim> getListclaim();
	public ArrayList<Claim>findClaimById(int id);
	public ArrayList<Claim>findClaimByClamingId(int claming_id);
	public ArrayList<Claim> getListclaimconfirmed(int value);
	public ArrayList<Claim> getListAccountActivate(int value);
	public ArrayList<Claim> getListAccountDeactivate(int value);
	public void  validateSubscriber (Subscriber s,int  state_claim);
	public Long getNumberClaimsnoconfirmed(int value);

}
