package com.cg.airline.AirlineReservation.model;

import java.math.BigDecimal;
import java.util.List;


public class BookingBean {

	private long bookingId;
	private String classType;
	private String creditcardInfo;
	private String custEmail;
	private String destCity;
	private String noOfPassengers;
	private String srcCity;
	private BigDecimal totalFare;
	private String flightno;
	private String depDate;
	private String depTime;
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getDepDate() {
		return depDate;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	private List<Passenger> passengers;
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getCreditcardInfo() {
		return creditcardInfo;
	}
	public void setCreditcardInfo(String creditcardInfo) {
		this.creditcardInfo = creditcardInfo;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	public String getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(String noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getSrcCity() {
		return srcCity;
	}
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}
	public BigDecimal getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}
	
	
}
