package com.onlineshop.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Addr_Tab")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressid;
	private int houseNumber;
	private String locality;
	private String city;
	private String country;
	private int pinCode;
	
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	public Address(){
		
	}
	public Address(int houseNumber, String locality, String city, String country,
			int pinCode, User user) {
		
		this.houseNumber = houseNumber;
		this.locality = locality;
		this.city = city;
		this.country =country;
		this.pinCode = pinCode;
		this.user = user;
	}




	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="email")
	
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
