/**
 * 
 */
package com.questions.three;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class to implement availability status rest service
 * 
 * @author Divyendu.Sharma
 *
 */

@RestController
public class AvailabilityController {

	/**
	 * POST method to implement logic to provide availability status.
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/getAvailability")
	public ResponseEntity<AvailabilityResponse> getAvailability(@RequestBody AvailabilityRequest request) {
		ResponseEntity<AvailabilityResponse> responseEntity = null;

		List<Supply> supplyList = new ArrayList<>();
		supplyList.add(new Supply("Product1", 10.0));
		supplyList.add(new Supply("Product2", 5.0));

		List<Demand> demandList = new ArrayList<>();
		demandList.add(new Demand("Product1", 2.0));
		demandList.add(new Demand("Product2", 5.0));

		Double availability = null;

		String productId = request.getProductId();

		Supply supplyInstance = supplyList.stream().filter(supply -> productId.equals(supply.getProductId())).findAny()
				.orElse(null);
		Demand demandInstance = demandList.stream().filter(demand -> productId.equals(demand.getProductId())).findAny()
				.orElse(null);

		if (supplyInstance != null && demandInstance != null)
			availability = (supplyInstance.getQuantity() - demandInstance.getQuantity());

		if (availability == 0) {
			responseEntity = new ResponseEntity<AvailabilityResponse>(HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<AvailabilityResponse>(new AvailabilityResponse(productId, availability),
					HttpStatus.OK);
		}

		return responseEntity;
	}
}
