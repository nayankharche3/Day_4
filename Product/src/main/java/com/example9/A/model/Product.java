package com.example9.A.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="price")
	private float price;
	
	@Column(name="discount")
	private float discount;

	@OneToOne(cascade = CascadeType.ALL)
	private ProductSeller productSeller;
	
	
	public ProductSeller getProductSeller() {
		return productSeller;
	}

	public void setProductSeller(ProductSeller productSeller) {
		this.productSeller = productSeller;
	}

	public Product() {
		
	}
	
	public Product(int pid, String pname, float price,float discount) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.discount=discount;
	}
	
	public String getPname() {
	return pname;
	}
	public void setPname(String pname) {
	this.pname = pname;
	}
	public float getPrice() {
	return price;
	}
	public void setPrice(float price) {
	this.price = price;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", discount=" + discount + "]";
	}

}
