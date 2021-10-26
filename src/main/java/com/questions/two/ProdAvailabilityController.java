/**
 * 
 */
package com.questions.two;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class to implement Product availability status rest service
 * 
 * @author Divyendu.Sharma
 *
 */

@RestController
public class ProdAvailabilityController {

	/**
	 * POST method to implement logic to provide product availability status.
	 * 
	 * @param request
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@PostMapping("/getProdAvailability")
	public ResponseEntity<AvailabilityResponse> getProdAvailability(@RequestBody AvailabilityRequest request)
			throws InterruptedException, ExecutionException {
		AvailabilityResponse response = new AvailabilityResponse(request.getStoreNo(), request.getProductId(),
				request.getReqQty(), request.getReqDate(), "");

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> availabilityFuture = executorService.submit(new AvailabilityDAO(request));
		Future<Integer> capacityFuture = executorService.submit(new CapacityDAO(request));

		ResponseEntity<AvailabilityResponse> responseEntity = null;

		if (availabilityFuture.get() == 1 && capacityFuture.get() == 0) {
			response.setStatus("No Capacity");
			responseEntity = new ResponseEntity<AvailabilityResponse>(response, HttpStatus.OK);
		}

		if (availabilityFuture.get() == 1 && capacityFuture.get() == 1) {
			response.setStatus("Available");
			responseEntity = new ResponseEntity<AvailabilityResponse>(response, HttpStatus.OK);
		}

		if (availabilityFuture.get() == 0 && capacityFuture.get() == 1) {
			responseEntity = new ResponseEntity<AvailabilityResponse>(HttpStatus.NO_CONTENT);
		}

		return responseEntity;

	}
}
