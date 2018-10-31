package com.cg.airline.AirlineReservation.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the BOOKING database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BOOKING_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long bookingId;

	@Column(name="CLASS_TYPE")
	private String classType;

	@Column(name="CREDITCARD_INFO")
	private String creditcardInfo;

	@Column(name="CUST_EMAIL")
	private String custEmail;

	@Column(name="DEST_CITY")
	private String destCity;

	@Column(name="NO_OF_PASSENGERS")
	private String noOfPassengers;

	@Column(name="SRC_CITY")
	private String srcCity;

	@Column(name="TOTAL_FARE")
	private BigDecimal totalFare;

	//bi-directional many-to-one association to Flight
	@ManyToOne()
	@JoinColumns({
		@JoinColumn(name="DEP_DATE", referencedColumnName="DEP_DATE"),
		@JoinColumn(name="DEP_TIME", referencedColumnName="DEP_TIME"),
		@JoinColumn(name="FLIGHTNO", referencedColumnName="FLIGHTNO")
		})
	private Flight flight;

	//bi-directional many-to-one association to Passenger
	@OneToMany(mappedBy="booking",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Passenger> passengers;

	public Booking() {
	}

	public long getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getClassType() {
		return this.classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getCreditcardInfo() {
		return this.creditcardInfo;
	}

	public void setCreditcardInfo(String creditcardInfo) {
		this.creditcardInfo = creditcardInfo;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getDestCity() {
		return this.destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public String getNoOfPassengers() {
		return this.noOfPassengers;
	}

	public void setNoOfPassengers(String noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getSrcCity() {
		return this.srcCity;
	}

	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}

	public BigDecimal getTotalFare() {
		return this.totalFare;
	}

	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
		for(Passenger pass:passengers){
			pass.setBooking(this);
		}
	}

	public Passenger addPassenger(Passenger passenger) {
		getPassengers().add(passenger);
		passenger.setBooking(this);

		return passenger;
	}

	public Passenger removePassenger(Passenger passenger) {
		getPassengers().remove(passenger);
		passenger.setBooking(null);

		return passenger;
	}

}