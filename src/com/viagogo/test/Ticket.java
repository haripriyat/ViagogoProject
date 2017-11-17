/**
 * 
 */
package com.viagogo.test;

public class Ticket implements Comparable<Ticket> {

	float price;

	public Ticket(float price) {
		super();
		this.price = Math.round((price * 100) / 100);
	}

	@Override
	public String toString() {
		return "$" + String.valueOf(price);
	}

	@Override
	public int compareTo(Ticket t) {
		return Float.compare(this.price, t.price);
	}
}
