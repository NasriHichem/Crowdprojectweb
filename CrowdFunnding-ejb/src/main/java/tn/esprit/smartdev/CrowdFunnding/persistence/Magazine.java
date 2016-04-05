package tn.esprit.smartdev.CrowdFunnding.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity

@NamedQuery(name = "getmagazinesbydate",
query = "SELECT m FROM Magazine m WHERE m.date=:date")
public class Magazine implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String title ;
	private String description;
	private String date;
	@ManyToOne
	private Article article;
	@OneToMany(mappedBy="magazine")
	private List<Article>articles;
	
	
	
	
	public Magazine() {
		super();
	}
	public Magazine(int id, String title, String description, String date, Article article, List<Article> articles) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.article = article;
		this.articles = articles;
	}
	public Magazine(String title, String description, String date, Article article, List<Article> articles) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.article = article;
		this.articles = articles;
	}
	public Magazine(Article article2) {
		this.article=article2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
