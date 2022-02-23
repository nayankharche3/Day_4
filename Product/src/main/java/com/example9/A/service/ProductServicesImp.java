package com.example9.A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example9.A.model.Product;
import com.example9.A.repo.ProductRepository;

@Service
public class ProductServicesImp{
	@Autowired
	ProductRepository productRepo;

	public Product addProduct(Product pd) {
		return productRepo.save(pd);
	}

	public List<Product> AllProductList() {
		return (List<Product>) productRepo.findAll();
	}

	public Product getProduct(long id) {
		return productRepo.findById(id).get();
	}

	public Product deleteProduct(long pid) {
		Product tprod=productRepo.findById(pid).get();
		productRepo.deleteById(pid);
		return tprod;
	}
	
	public Product productFindByID(long pid) {
		return productRepo.findById(pid).get();	
	}
	
	public Product updateProduct(Product p,int pid) {
		return productRepo.save(p);	
	}
	
//	public List<Product> findByNameAndPrice(String pname,float price) {
//		return  productRepo.findByNameAndPrice(pname, price);	
//	}
}
