package com.questions.two;

/**
 * POJO for Availability Request
 * @author Divyendu.Sharma
 *
 */
public class AvailabilityRequest {
	private String storeNo;
	private String productId;
	private String reqQty;
	private String reqDate;
	
	public AvailabilityRequest() {

	}
	
	public AvailabilityRequest(String storeNo, String productId, String reqQty, String reqDate) {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.reqQty = reqQty;
		this.reqDate = reqDate;
	}

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getReqQty() {
		return reqQty;
	}

	public void setReqQty(String reqQty) {
		this.reqQty = reqQty;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

}
