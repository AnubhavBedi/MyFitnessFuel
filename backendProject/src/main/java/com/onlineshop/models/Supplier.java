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
@Table(name="Supl_tab")
public class Supplier {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int supplierid;
		private String suppliername;
		
		@OneToMany(fetch=FetchType.EAGER,mappedBy="supplierObj",cascade=CascadeType.ALL)
		private Set<Product> products=new HashSet<Product>();
		
		
		
		public String getSuppliername() {
			return suppliername;
		}
		public void setSuppliername(String suppliername) {
			this.suppliername = suppliername;
		}
		public int getSupplierid() {
			return supplierid;
		}
		public void setSupplierid(int supplierid) {
			this.supplierid = supplierid;
		}
		public Set<Product> getProducts() {
			return products;
		}
		public void setProducts(Set<Product> products) {
			this.products = products;
		}
		
		

}
