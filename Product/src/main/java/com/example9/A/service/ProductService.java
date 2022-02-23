package com.example9.A.service;

import java.util.List;

import com.example9.A.model.Product;

public interface ProductService {

	public Product addProduct(Product pd);

	public List<Product> AllProductList();

	public Product updateProduct(Product p,int pid);
	
	public Product getProduct(long id);

	public Product deleteProduct(long pid) ;
	
	public Product productFindByID(long pid);
	
//	List<Product> findByNameAndPrice(String pname,float price);
}
