package com.cg.airline.AirlineReservation.model;

import java.math.BigDecimal;
import java.util.Date;

public class FlightBean {
	private String flightno;

	private Date depDate;

	private String depTime;
	private String airline;

	private String arrCity;

	private Date arrDate;

	private String arrTime;

	private BigDecimal bussseatfare;

	private BigDecimal bussseats;

	private String depCity;

	private BigDecimal firstseatfare;

	private BigDecimal firstseats;

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public Date getArrDate() {
		return arrDate;
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public BigDecimal getBussseatfare() {
		return bussseatfare;
	}

	public void setBussseatfare(BigDecimal bussseatfare) {
		this.bussseatfare = bussseatfare;
	}

	public BigDecimal getBussseats() {
		return bussseats;
	}

	public void setBussseats(BigDecimal bussseats) {
		this.bussseats = bussseats;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public BigDecimal getFirstseatfare() {
		return firstseatfare;
	}

	public void setFirstseatfare(BigDecimal firstseatfare) {
		this.firstseatfare = firstseatfare;
	}

	public BigDecimal getFirstseats() {
		return firstseats;
	}

	public void setFirstseats(BigDecimal firstseats) {
		this.firstseats = firstseats;
	}
	
	
}
