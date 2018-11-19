package com.onlineshop.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Cat_tab")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryid;
	private String categoryname;
	private String categorydescription;
	

	@OneToMany(fetch=FetchType.EAGER,mappedBy="categoryObj",cascade=CascadeType.ALL)
	private Set<Product> products=new HashSet<Product>();
	
	public Category(){
}

	
	

public Category( String categoryname,String categorydescription){
	super();
	
	this.categoryname = categoryname;
	this.categorydescription = categorydescription;
	
}



public int getCategoryid() {
	return categoryid;
}




public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}




public Set<Product> getProducts() {
	return products;
}




public void setProducts(Set<Product> products) {
	this.products = products;
}




public String getCategoryname() {
	return categoryname;
}

public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}

public String getCategorydescription() {
	return categorydescription;
}

public void setCategorydescription(String categorydescription) {
	this.categorydescription = categorydescription;
}


public String toString() {
	return "Category [ categoryName="+ categoryname + ", categoryDescription=" + categorydescription+ "]";

}
}


