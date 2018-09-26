package org.test.charttest;

import java.util.Date;

public class ExampleDTO {
	
	private Float yValue;
	private Date date;
	
	public ExampleDTO(Float yValue, Date date) {
		super();
		this.yValue = yValue;
		this.date = date;
	}
	public Float getyValue() {
		return yValue;
	}
	public void setyValue(Float yValue) {
		this.yValue = yValue;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}