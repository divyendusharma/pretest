package com.questions.three;

/**
 * Class to implement POJO for Availability Request
 * 
 * @author Divyendu.Sharma
 *
 */
public class AvailabilityRequest {
	private String productId;
	
	public AvailabilityRequest() {
	}
	
	public AvailabilityRequest(String productId) {
		super();
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}
