package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import tn.esprit.smartdev.CrowdFunnding.persistence.Article;

@Local
public interface ArticileServicesLocal {

	
	ArrayList<Article> findArticleByDate(Date date);

	void addArticle(Article a);

	ArrayList<Article> getListArticle();

	void removeArticle(Article a);

	void updateArticle(Article a);
}
