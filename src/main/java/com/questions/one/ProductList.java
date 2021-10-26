/**
 * 
 */
package com.questions.one;

import java.util.List;

/**
 * Class to implement POJO for Product List
 * 
 * @author Divyendu.Sharma
 *
 */
public class ProductList {
	private List<Product> productList;

	public ProductList() {
		super();
	}

	public ProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}
}
