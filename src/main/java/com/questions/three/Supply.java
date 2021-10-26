package com.questions.three;

/**
 * POJO for Supply
 * 
 * @author Divyendu.Sharma
 *
 */
public class Supply {
	private String productId;
	private Double quantity;
	
	public Supply(String productId, Double quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
