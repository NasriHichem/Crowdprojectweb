package tn.esprit.smartdev.CrowdFunnding.services;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.esprit.smartdev.CrowdFunnding.persistence.Article;






@Stateless
public class ArticleServices implements ArticleServicesRemote,ArticileServicesLocal {


	@PersistenceContext
	EntityManager em;

	

	@Override
	public void addArticle(Article a) {
		em.persist(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Article> getListArticle() {
		return (ArrayList<Article>) em.createQuery("select a from Article a").getResultList();
	}

	@Override
	public void removeArticle(Article a) {

		em.remove(em.merge(a));

	}

	@Override
	public void updateArticle(Article a) {
		em.merge(a);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Article> findArticleByDate(Date date) {
		Query querygetArticlesbydate = em.createNamedQuery("getArticlesbydate");
		querygetArticlesbydate.setParameter("date", date);
		return (ArrayList<Article>) querygetArticlesbydate.getResultList();
	}


	
}
