package com.example9.A.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productSeller")
public class ProductSeller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int psID;
	

	@Column(name="sellerCompany")
	private String sellerCompany;
	
	@Column(name="sellerAddress")
	private String sellerAddress;
	
	public ProductSeller() {
	
	}
	
	public ProductSeller(int psID, String sellerCompany, String sellerAddress) {
		super();
		this.psID = psID;
		this.sellerCompany = sellerCompany;
		this.sellerAddress = sellerAddress;
	}


	public int getPsID() {
		return psID;
	}


	public void setPsID(int psID) {
		this.psID = psID;
	}
	
	public String getSellerCompany() {
		return sellerCompany;
	}
	
	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}
	
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}


	@Override
	public String toString() {
		return "ProductSeller [psID=" + psID + ", sellerCompany=" + sellerCompany + ", sellerAddress=" + sellerAddress
				+ "]";
	}
	
}
