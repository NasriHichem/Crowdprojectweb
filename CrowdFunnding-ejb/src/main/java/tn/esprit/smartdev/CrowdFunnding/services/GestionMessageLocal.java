package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Message;


@Local
public interface GestionMessageLocal {
	
	public void SendMessageByModerator( Message M);
	public ArrayList<Message> FindAllMessageofModirator();
	public void removeMessage(Message m);
	public ArrayList<Message> FindAllMessageofAdmin();
	public int  getNumberofmessagesbyadminbydate(String date1,String date2 );
	public int  getNumberofmessagesbymodiratorbydate(String date1,String date2 );

}
