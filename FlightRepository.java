package com.cg.airline.AirlineReservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.airline.AirlineReservation.model.Flight;
import com.cg.airline.AirlineReservation.model.FlightPK;

public interface FlightRepository extends JpaRepository<Flight, FlightPK> {

	List<Flight> findByDepCityAndArrCityAndIdDepDate(String source,
			String destination,Date date);


}
