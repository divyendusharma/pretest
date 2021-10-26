package com.questions.one;

import java.util.Date;

/**
 * Class to implement POJO for Product
 * 
 * @author Divyendu.Sharma
 *
 */
public class Product {
	private String productId;
	private String productName;
	private String unitOfMeasure;
	private Date launchDate;

	public Product(String productId, String productName, String unitOfMeasure, Date launchDate) {
		this.productId = productId;
		this.productName = productName;
		this.unitOfMeasure = unitOfMeasure;
		this.launchDate = launchDate;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public Date getLaunchDate() {
		return launchDate;
	}
}
