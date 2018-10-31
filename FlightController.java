package com.cg.airline.AirlineReservation.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.airline.AirlineReservation.model.Flight;
import com.cg.airline.AirlineReservation.model.FlightPK;
import com.cg.airline.AirlineReservation.model.FlightBean;
import com.cg.airline.AirlineReservation.repository.FlightRepository;

@CrossOrigin
@RestController()
public class FlightController {

	@Autowired
	FlightRepository flightRepository;

	/**
	 * 
	 * @param source
	 * @param destination
	 * @param date
	 * @return
	 */
	@GetMapping(value = "/enquiry/{source}/{destination}/{date}")
	public List<FlightBean> displayFlights(
			@PathVariable("source") String source,
			@PathVariable("destination") String destination,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Flight> flights = flightRepository
				.findByDepCityAndArrCityAndIdDepDate(source, destination, date);
		List<FlightBean> flightList = new ArrayList<FlightBean>();
		FlightBean newFlight;
		for (Flight flight : flights) {
			newFlight = new FlightBean();
			if(!(flight.getFirstseats().equals(new BigDecimal(0))&&flight.getBussseats().equals(new BigDecimal(0)))){
				newFlight.setFlightno(flight.getId().getFlightno());
				newFlight.setAirline(flight.getAirline());
				newFlight.setDepCity(flight.getDepCity());
				newFlight.setArrCity(flight.getArrCity());
				newFlight.setDepDate(flight.getId().getDepDate());
				newFlight.setArrDate(flight.getArrDate());
				newFlight.setDepTime(flight.getId().getDepTime());
				newFlight.setArrTime(flight.getArrTime());
				newFlight.setFirstseats(flight.getFirstseats());
				newFlight.setFirstseatfare(flight.getFirstseatfare());
				newFlight.setBussseats(flight.getBussseats());
				newFlight.setBussseatfare(flight.getBussseatfare());
				flightList.add(newFlight);
			}
			
		}
		return flightList;

	}
	/**
	 * 
	 * @param newFlight
	 * @return
	 */
	
	@PutMapping(value="/updateFlight",headers="Accept=application/json",consumes=MediaType.APPLICATION_JSON_VALUE)
	public synchronized String[] updateFlightInformation(@RequestBody FlightBean newFlight){
		FlightPK flightPrimaryKey = new FlightPK();
		flightPrimaryKey.setFlightno(newFlight.getFlightno());
		flightPrimaryKey.setDepDate(newFlight.getDepDate());
		flightPrimaryKey.setDepTime(newFlight.getDepTime());
		Flight flight = flightRepository.findById(flightPrimaryKey).get();
		System.out.println(newFlight.getBussseats());
		if(!(newFlight.getBussseats().compareTo(new BigDecimal(0))==0)&&flight.getBussseats().compareTo(newFlight.getBussseats())>=0){
			flight.setBussseats(newFlight.getBussseats());
		}
		else if(!(newFlight.getFirstseats().compareTo(new BigDecimal(0))==0)&&flight.getFirstseats().compareTo(newFlight.getFirstseats())>=0){
			flight.setFirstseats(newFlight.getFirstseats());
		}
		flightRepository.save(flight);
		String[] message=new String[]{"Success"};
		return message;
	}
}
