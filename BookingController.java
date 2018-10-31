package com.cg.airline.AirlineReservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.airline.AirlineReservation.model.Booking;
import com.cg.airline.AirlineReservation.model.BookingBean;
import com.cg.airline.AirlineReservation.model.Flight;
import com.cg.airline.AirlineReservation.model.FlightPK;
import com.cg.airline.AirlineReservation.model.Passenger;
import com.cg.airline.AirlineReservation.repository.BookingRepository;
import com.cg.airline.AirlineReservation.repository.FlightRepository;
import com.cg.airline.AirlineReservation.repository.PassengerRepository;

@CrossOrigin
@RestController()
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private FlightRepository flightRepository;

	private static final String DATE_FORMAT="yyyy-MM-dd";
	/**
	 * 
	 * @param book
	 * @return
	 */
	@PostMapping(value = "/addbooking", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Long> addBooking(@RequestBody BookingBean book) {
		Booking booking = new Booking();
		booking.setNoOfPassengers(book.getNoOfPassengers());
		booking.setCustEmail(book.getCustEmail());
		booking.setClassType(book.getClassType());
		booking.setCreditcardInfo(book.getCreditcardInfo());
		booking.setSrcCity(book.getSrcCity());
		booking.setDestCity(book.getDestCity());
		booking.setPassengers(book.getPassengers());
		booking.setTotalFare(book.getTotalFare());
		FlightPK flightPk = new FlightPK();
		flightPk.setFlightno(book.getFlightno());
		String depDate = book.getDepDate();
		Date date = null;
		try {
			date = new SimpleDateFormat(BookingController.DATE_FORMAT).parse(depDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		flightPk.setDepDate(date);
		
		
		flightPk.setDepTime(book.getDepTime());
		Flight flight = flightRepository.findById(flightPk).get();
		booking.setFlight(flight);
		Booking bookingDetails = bookingRepository.save(booking);
		long id = bookingDetails.getBookingId();
		List<Long> bookingId = new ArrayList<Long>();
		bookingId.add(id);
		return bookingId;
	}

	/**
	 * 
	 * @param bookingId
	 * @return
	 */
	@GetMapping(value = "/viewbooking/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingBean getBooking(@PathVariable("bookingId") Long bookingId) {
		Booking booking = bookingRepository.findById(bookingId).get();
		BookingBean bookedTicket = new BookingBean();
		bookedTicket.setBookingId(booking.getBookingId());
		bookedTicket.setClassType(booking.getClassType());
		bookedTicket.setCreditcardInfo(booking.getCreditcardInfo());
		bookedTicket.setCustEmail(booking.getCustEmail());
		bookedTicket.setDepDate(booking.getFlight().getId().getDepDate()
				.toString());
		bookedTicket.setDepTime(booking.getFlight().getId().getDepTime());
		bookedTicket.setDestCity(booking.getDestCity());
		bookedTicket.setSrcCity(booking.getSrcCity());
		bookedTicket.setFlightno(booking.getFlight().getId().getFlightno());
		bookedTicket.setNoOfPassengers(booking.getNoOfPassengers());
		List<Passenger> passengerList = new ArrayList<Passenger>();
		for (Passenger passenger : booking.getPassengers()) {
			passengerList.add(new Passenger().setName(passenger.getName())
					.setAge(passenger.getAge()));
		}
		bookedTicket.setPassengers(passengerList);
		bookedTicket.setTotalFare(booking.getTotalFare());
		return bookedTicket;
	}
}
