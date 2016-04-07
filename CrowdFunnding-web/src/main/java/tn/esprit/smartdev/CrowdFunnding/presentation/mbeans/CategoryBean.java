package tn.esprit.smartdev.CrowdFunnding.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.smartdev.CrowdFunnding.persistence.Category;
import tn.esprit.smartdev.CrowdFunnding.services.CategoryservicesLocal;

@ManagedBean
public class CategoryBean {
	
	@EJB
	public CategoryservicesLocal service ;
    
	private List<Category> categorys ;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
	@PostConstruct
	public void init()
	{
	  categorys=service.getList();
	}

}
