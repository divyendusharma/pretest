package com.questions.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Implementation class to get capacity
 * 
 * @author Divyendu.Sharma
 *
 */
@Component
public class CapacityDAO implements Callable<Integer> {

	private AvailabilityRequest request;

	CapacityDAO() {

	}

	CapacityDAO(AvailabilityRequest request) {
		this.request = request;
	}

	@Override
	public Integer call() throws Exception {
		List<Capacity> capacityList = new ArrayList<>();

		try {
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 0.0));
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 2.0));
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 2.0));
			capacityList.add(new Capacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22"), 0.0));
		} catch (ParseException e) {

		}
		Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());
		List<Capacity> cap = capacityList.stream().filter(capacity -> capacity.getDate().compareTo(reqDate) == 0)
				.filter(capacity -> capacity.getNoOfOrdersAccepted() > 0).collect(Collectors.toList());
		return cap.size();
	}

}
