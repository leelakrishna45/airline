package com.cg.airline.AirlineReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.airline.AirlineReservation.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long>{

}
