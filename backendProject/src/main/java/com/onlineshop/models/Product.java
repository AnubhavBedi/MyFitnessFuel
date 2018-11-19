package com.onlineshop.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;




@Entity
@Table(name="Prodt_tab")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productid;
	private String productname;
	private double price;
	private int quantity;
	private String productdescription;
	private int categoryid;
	private int supplierid;
	private String imgName;
	
	@Transient
	private MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="supplierid",insertable=false,updatable=false,nullable=false)
	private Supplier supplierObj;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoryid",insertable=false,updatable=false,nullable=false)
	private Category categoryObj;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	
	public Supplier getSupplierObj() {
		return supplierObj;
	}

	public void setSupplierObj(Supplier supplierObj) {
		this.supplierObj = supplierObj;
	}

	public Category getCategoryObj() {
		return categoryObj;
	}

	public void setCategoryObj(Category categoryObj) {
		this.categoryObj = categoryObj;
	}

	public Product(String productname, double price, int quantity,
			String productdescription, int categoryid, int supplierid,
			String imgName,Supplier supplierObj,
			Category categoryObj) {
		super();
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.productdescription = productdescription;
		this.categoryid = categoryid;
		this.supplierid = supplierid;
		this.imgName = imgName;
		this.supplierObj = supplierObj;
		this.categoryObj = categoryObj;
	}

	public Product() {
		super();
	}
	
	
	
}
