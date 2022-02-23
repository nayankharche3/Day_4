package com.example9.A.controller;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example9.A.model.Product;
import com.example9.A.service.ProductService;
import com.example9.A.service.ProductServicesImp;

@RestController
public class ProductController {

	@Autowired
	ProductServicesImp myService;

	 @Value("${companyName}")
	  private String companyName;
	 
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product pd) {
		return myService.addProduct(pd);
	}

	@GetMapping("/products")
	public List<Product> getProduct() {
		return myService.AllProductList();
	}

	@GetMapping("/product/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable int pid) throws ProductIDInvalidException {
	if(pid < 0) {
		throw new ProductIDInvalidException(LocalDateTime.now(), "/product/pid", "permanent");
	}
		Product prod= myService.getProduct(pid);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}

	@DeleteMapping("/deleteProduct")
		public Product deleteProduct(@RequestParam int pid) {
		 return myService.deleteProduct(pid);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product pd) {
		Product p= myService.productFindByID(pd.getPid());
		if(p==null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);	
		}
		myService.updateProduct(pd,pd.getPid());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
//	@GetMapping("/productnameprice/{pname}/{price}")
//	public List<Product> getByNameAndPrice(@PathVariable String pname, @PathVariable float price){
//		List<Product> task=myService.findByNameAndPrice(pname, price);
//		return task;
//	}
	
	@GetMapping("/product/companyName")
	public String  getCompanyName() {
		return companyName;
	}
}
