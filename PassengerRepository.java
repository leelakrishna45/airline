package com.cg.airline.AirlineReservation.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.airline.AirlineReservation.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, BigDecimal>{

}
