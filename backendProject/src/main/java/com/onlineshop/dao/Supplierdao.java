package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.models.Supplier;

public interface Supplierdao {

	public boolean addSupplier(Supplier supplierObj);
	public boolean deleteSupplier(Supplier supplierObj);
	public boolean updateSupplier(Supplier Supplier );
	public Supplier getSupplierById(int supplierId);
	public List<Supplier> getAllSupplier();

}
