
package com.viagogo.test;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {

	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SeedDataGenerator gen = new SeedDataGenerator();
		Point[] points = gen.randomPointGenerator(-10, 10, -10, 10, 10);
		Map<Point, Event> events = gen.generateSeedData(10, 100);

		// Please uncomment the following to see what are the random points and
		// the random events that got generated.
		// System.out.println(Arrays.toString(points));
		// System.out.println(events);

		// Read input reference point
		sc = new Scanner(System.in);
		System.out.println("Please Input Coordinates:");
		int x = sc.nextInt();
		int y = sc.nextInt();
		Point referencePoint = new Point(x, y);

		Map<Integer, Point> distanceMap = sortOnDistance(points, referencePoint);

		System.out.println("Closest Events to " + referencePoint);
		//Number of closest events to be printed
		int limit = 5;
		for (Integer i : distanceMap.keySet()) {
			System.out.println(events.get(distanceMap.get(i)) + " Distance " + i);
			limit--;
			if (limit == 0)
				break;
		}
	}

	/**
	 * @param points - seedData of points
	 * @param ref - Input reference point
	 * @return Map of distance from each point with respect to reference point
	 */
	public static Map<Integer, Point> sortOnDistance(Point[] points, Point ref) {
		Map<Integer, Point> distanceMap = new TreeMap<Integer, Point>();
		for (Point p : points) {
			distanceMap.put(distance(p, ref), p);
		}
		return distanceMap;
	}

	/**
	 * @param p - A given Point
	 * @param ref - Reference Point
	 * @return Manhattan distance between the two points
	 */
	public static int distance(Point p, Point ref) {
		return Math.abs(p.x - ref.x) + Math.abs(p.y - ref.y);
	}
}