package com.interview.design.parking;

public abstract class Vehicle {

	private int id;
	
	public int getId() {
		return id;
	}

	public Vehicle(int id) throws IllegalArgumentException {
		if(id<=0 ) throw new IllegalArgumentException();
		this.id  = id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
