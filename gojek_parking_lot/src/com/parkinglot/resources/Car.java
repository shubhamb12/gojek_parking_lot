package com.parkinglot.resources;

public class Car implements Comparable<Car> {
	private String carId;
	private String color;
	
	
	public Car(String carId, String color) {
		super();
		this.carId = carId;
		this.color = color;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public int compareTo(Car other) {
		 int res = carId.compareTo(other.getCarId());
	        if (res != 0)
				return res;
			else
				return color.compareTo(other.getColor());
	}
	
}
