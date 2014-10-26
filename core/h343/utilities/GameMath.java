package com.lodenrogue.h343.utilities;

public class GameMath {

	private GameMath() {
	}

	public static double findDistance(int x1, int y1, int x2, int y2) {
		int xDistance = Math.abs((x2 - x1));
		int yDistance = Math.abs((y2 - y1));

		double xSquared = Math.pow(xDistance, 2);
		double ySquared = Math.pow(yDistance, 2);

		double distance = Math.sqrt(xSquared + ySquared);
		return distance;
	}
}
