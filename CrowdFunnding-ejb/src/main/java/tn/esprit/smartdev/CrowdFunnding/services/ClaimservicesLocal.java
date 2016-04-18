package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Claim;



@Local
public interface ClaimservicesLocal {
	
	public void removeClaim(Claim c);
	public ArrayList<Claim> getListclaimnonconfirm();
	public void update(Claim c);
	public ArrayList<Claim> getclaimByclaiming(String txtclaiming);
	public ArrayList<Claim>findbyclaimer(int id);
	public Long getclaimbymonth(String date1, String date2);
	
	/*List<Claim> findAllClaims();
	List<Claim> findAllClaimsByClaming(String claming);
	void deleteClaim(Claim claim) throws Exception;*/
	 void  addClaim(Claim claim) throws Exception;
	


}
