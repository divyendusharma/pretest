package com.questions.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

/**
 * Implementation class to get availability
 * 
 * @author Divyendu.Sharma
 *
 */

@Component
public class AvailabilityDAO implements Callable<Integer> {

	private AvailabilityRequest request;

	AvailabilityDAO() {

	}

	AvailabilityDAO(AvailabilityRequest request) {
		this.request = request;
	}

	@Override
	public Integer call() throws Exception {
		int state = 0;

		List<Availability> availabilityList = new ArrayList<>();

		try {
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 1.0));
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 3.0));
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 0.0));
		} catch (ParseException e) {

		}

		Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());
		for (Availability availability : availabilityList) {
			int result = availability.getDate().compareTo(reqDate);
			if (result == 0 && availability.getAvailQty() > 0) {
				state = 1;
				break;
			}
			if (result == 0 && availability.getAvailQty() == 0) {
				state = 0;
				break;
			}
		}
		return state;
	}
}
