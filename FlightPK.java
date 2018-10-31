package com.cg.airline.AirlineReservation.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FLIGHT database table.
 * 
 */
@Embeddable
public class FlightPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String flightno;

	@Temporal(TemporalType.DATE)
	@Column(name="DEP_DATE")
	private java.util.Date depDate;

	@Column(name="DEP_TIME")
	private String depTime;

	public FlightPK() {
	}
	public String getFlightno() {
		return this.flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public java.util.Date getDepDate() {
		return this.depDate;
	}
	public void setDepDate(java.util.Date depDate) {
		this.depDate = depDate;
	}
	public String getDepTime() {
		return this.depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FlightPK)) {
			return false;
		}
		FlightPK castOther = (FlightPK)other;
		return 
			this.flightno.equals(castOther.flightno)
			&& this.depDate.equals(castOther.depDate)
			&& this.depTime.equals(castOther.depTime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.flightno.hashCode();
		hash = hash * prime + this.depDate.hashCode();
		hash = hash * prime + this.depTime.hashCode();
		
		return hash;
	}
}