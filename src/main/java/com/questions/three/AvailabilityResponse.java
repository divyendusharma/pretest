package com.questions.three;

/**
 * POJO for Availability Response
 * 
 * @author Divyendu.Sharma
 *
 */
public class AvailabilityResponse {
	private String productId;
	private Double Availability;

	public AvailabilityResponse(String productId, Double availability) {
		super();
		this.productId = productId;
		Availability = availability;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getAvailability() {
		return Availability;
	}

	public void setAvailability(Double availability) {
		Availability = availability;
	}

}
