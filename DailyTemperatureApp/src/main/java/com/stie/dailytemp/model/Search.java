package com.stie.dailytemp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Search {
	
	String groupBy;
	
	String shift;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="dd-MM-yyyy")
	LocalDate startDate;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="dd-MM-yyyy")
	LocalDate endDate;

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy.trim();
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift.trim();
	}

	@Override
	public String toString() {
		return "Search [groupBy=" + groupBy + ", shift=" + shift + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
	
	
	
}
