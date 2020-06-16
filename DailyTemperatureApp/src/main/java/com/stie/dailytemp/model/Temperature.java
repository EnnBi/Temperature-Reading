package com.stie.dailytemp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Temperature {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	LocalDate date;
	
	String shift;
	
	Double reading;
	
	String noReading;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	AppUser appUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift.trim();
	}


	public Double getReading() {
		return reading;
	}

	public void setReading(Double reading) {
		this.reading = reading;
	}

	public String getNoReading() {
		return noReading;
	}

	public void setNoReading(String noReading) {
		this.noReading = noReading.trim();
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	
}
