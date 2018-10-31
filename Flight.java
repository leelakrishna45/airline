package com.cg.airline.AirlineReservation.model;

import java.io.Serializable;

import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FLIGHT database table.
 * 
 */
@Entity
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FlightPK id;

	private String airline;

	@Column(name="ARR_CITY")
	private String arrCity;

	@Temporal(TemporalType.DATE)
	@Column(name="ARR_DATE")
	private Date arrDate;

	@Column(name="ARR_TIME")
	private String arrTime;

	private BigDecimal bussseatfare;

	private BigDecimal bussseats;

	@Column(name="DEP_CITY")
	private String depCity;

	private BigDecimal firstseatfare;

	private BigDecimal firstseats;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="flight",fetch=FetchType.LAZY)
	private List<Booking> bookings;

	public Flight() {
	}

	public FlightPK getId() {
		return this.id;
	}

	public void setId(FlightPK id) {
		this.id = id;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getArrCity() {
		return this.arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public Date getArrDate() {
		return this.arrDate;
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public String getArrTime() {
		return this.arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public BigDecimal getBussseatfare() {
		return this.bussseatfare;
	}

	public void setBussseatfare(BigDecimal bussseatfare) {
		this.bussseatfare = bussseatfare;
	}

	public BigDecimal getBussseats() {
		return this.bussseats;
	}

	public void setBussseats(BigDecimal bussseats) {
		this.bussseats = bussseats;
	}

	public String getDepCity() {
		return this.depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public BigDecimal getFirstseatfare() {
		return this.firstseatfare;
	}

	public void setFirstseatfare(BigDecimal firstseatfare) {
		this.firstseatfare = firstseatfare;
	}

	public BigDecimal getFirstseats() {
		return this.firstseats;
	}

	public void setFirstseats(BigDecimal firstseats) {
		this.firstseats = firstseats;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setFlight(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setFlight(null);

		return booking;
	}

}