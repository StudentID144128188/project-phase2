package com.project.entity;

public class Amenity {
	private boolean wifi;
	private boolean parking;
	private boolean bathtub;
	private boolean restaurant;
	private boolean bar;
	private boolean spa;
	private boolean gym;
	  
	public Amenity() {
		super();
	}

	public Amenity(boolean wifi, boolean parking, boolean bathtub, boolean restaurant, boolean bar, boolean spa,
			boolean gym) {
		super();
		this.wifi = wifi;
		this.parking = parking;
		this.bathtub = bathtub;
		this.restaurant = restaurant;
		this.bar = bar;
		this.spa = spa;
		this.gym = gym;
	}
	
	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isBathtub() {
		return bathtub;
	}

	public void setBathtub(boolean bathtub) {
		this.bathtub = bathtub;
	}

	public boolean isRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isBar() {
		return bar;
	}

	public void setBar(boolean bar) {
		this.bar = bar;
	}

	public boolean isSpa() {
		return spa;
	}

	public void setSpa(boolean spa) {
		this.spa = spa;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}
	
	@Override
	public String toString() {
		return "Amenity [wifi=" + wifi + ", parking=" + parking + ", bathtub=" + bathtub + ", restaurant=" + restaurant
				+ ", bar=" + bar + ", spa=" + spa + ", gym=" + gym + "]";
	}
 
}
