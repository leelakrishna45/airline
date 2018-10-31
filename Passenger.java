package com.cg.airline.AirlineReservation.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PASSENGER database table.
 * 
 */
@Entity
@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal age;

	private String name;

	@Id
	@Column(name="PASSENGER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigDecimal passengerId;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JoinColumn(name="BOOKING_ID")
	private Booking booking;

	public Passenger() {
	}

	public BigDecimal getAge() {
		return this.age;
	}

	public Passenger setAge(BigDecimal age) {
		this.age = age;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public Passenger setName(String name) {
		this.name = name;
		return this;
	}

	public BigDecimal getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(BigDecimal passengerId) {
		this.passengerId = passengerId;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}