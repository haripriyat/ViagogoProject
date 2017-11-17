/**
 * 
 */
package com.viagogo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Event {
	int id;
	List<Ticket> tickets;

	public Event(int id) {
		super();
		this.id = id;
		tickets = new ArrayList<Ticket>();
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		Collections.sort(tickets);
		return "Event"+this.id+" - " + tickets.get(0);
	}
}
