/**
 * 
 */
package com.questions.one;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class to implement sort products rest service
 * 
 * @author Divyendu.Sharma
 *
 */

@RestController
public class SortProductsController {

	/**
	 * POST method to implement logic to sort product list.
	 *
	 * @param unsortedProdList
	 * @return
	 */
	@PostMapping("/sortProducts")
	public ProductList sortProducts(@RequestBody ProductList productList) {

		// Below implementation can be written in another DAO class.

		// Compare products based on product id and then launch date using Comparator
		Comparator<Product> compareIdANdDate = Comparator.comparing(Product::getProductId)
				.thenComparing(Product::getLaunchDate);

		// Sort product list in reverse
		List<Product> sortedProductList = productList.getProductList().stream().sorted(compareIdANdDate.reversed())
				.collect(Collectors.toList());

		// Return sorted product list
		return new ProductList(sortedProductList);
	}
}
