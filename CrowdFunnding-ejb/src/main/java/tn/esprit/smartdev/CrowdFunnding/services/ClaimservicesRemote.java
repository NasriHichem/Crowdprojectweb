package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import tn.esprit.smartdev.CrowdFunnding.persistence.Claim;



@Remote
public interface ClaimservicesRemote {
	public void removeClaim(Claim c);
	public ArrayList<Claim> getListclaimnonconfirm();
	public void update(Claim c);
	public ArrayList<Claim> getclaimByclaiming(String txtclaiming);
	public Long getclaimbymonth(String date1, String date2);

}
