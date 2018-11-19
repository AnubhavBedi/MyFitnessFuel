package com.onlineshop.dao;

import java.util.List;
import com.onlineshop.models.Address;
import com.onlineshop.models.User;

public interface Userdao {
	
	
	public boolean registerUser(User user);
	public User validateUser(String email,String password);
	public User getuser(String email);
	public boolean addAddress(Address address);
	public Address getAddress(int addressId);
	public boolean deleteAddress(Address address);
	public boolean updateAddress(Address address);
	public List<Address> getAllAddressForUser(String email);
	
}
