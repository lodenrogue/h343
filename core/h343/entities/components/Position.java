package com.lodenrogue.h343.entities.components;

/**
 * Position class. Contains x and y location with methods to set and get points.
 * 
 * @author Miguel Hernandez
 *
 */

public class Position {

	private int x, y;

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
