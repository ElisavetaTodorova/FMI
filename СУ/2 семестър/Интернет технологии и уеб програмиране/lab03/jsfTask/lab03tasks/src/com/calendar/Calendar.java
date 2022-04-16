package com.calendar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "calendar")
public class Calendar {

	@ManagedProperty(value = "#{date}")
	private Date date;
	@ManagedProperty(value = "#{age}")
	private int age;

 

	public void click() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		
	this.age = age;	
		
		
	}

	public void calculateAge() {
		if(this.date != null) {
			java.util.Calendar c = java.util.Calendar.getInstance();
			c.setTime(date);
			int year = c.get(java.util.Calendar.YEAR);
			int month = c.get(java.util.Calendar.MONTH) + 1;
			int day = c.get(java.util.Calendar.DATE);
			LocalDate l1 = LocalDate.of(year, month, day);
			LocalDate now1 = LocalDate.now();
			Period diff1 = Period.between(l1, now1);

			this.age = diff1.getYears();
		}
		
		// System.out.println("age:" + diff1.getYears() + "years");
	}

}
