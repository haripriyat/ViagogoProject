/**
 * 
 */
package com.viagogo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SeedDataGenerator {

	Point[] points;
	Map<Point, Event> seedData;

	public Point[] randomPointGenerator(int minX, int maxX, int minY, int maxY, int numOfPoints) {
		Point p;
		Set<Point> pointSet = new HashSet<Point>();
		Random rand = new Random();
		while (pointSet.size() != numOfPoints) {
			p = new Point(rand.nextInt(maxX - minX + 1) + minX, rand.nextInt(maxY - minY + 1) + minY);
			pointSet.add(p);
		}
		points = pointSet.toArray(new Point[pointSet.size()]);
		return points;

	}

	public Map<Point, Event> generateSeedData(int maxTickets, int maxPrice) {
		seedData = new HashMap<Point, Event>();
		Event e;
		Random rand = new Random();
		int i = 1;
		int numOfTickets = 0;
		List<Ticket> tickets;
		for (Point p : points) {
			numOfTickets = rand.nextInt(maxTickets);
			tickets = new ArrayList<Ticket>();
			while (numOfTickets != 0) {
				tickets.add(new Ticket(rand.nextFloat()*maxPrice));
				numOfTickets--;
			}	
			e = new Event(i);
			e.setTickets(tickets);
			seedData.put(p, e);
			i++;
		}
		return seedData;
	}
}
