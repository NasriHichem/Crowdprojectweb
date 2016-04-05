package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import tn.esprit.smartdev.CrowdFunnding.persistence.Article;


@Remote
public interface ArticleServicesRemote {

	ArrayList<Article> findArticleByDate(Date date);

	void addArticle(Article a);

	ArrayList<Article> getListArticle();

	void removeArticle(Article a);

	void updateArticle(Article a);

}
