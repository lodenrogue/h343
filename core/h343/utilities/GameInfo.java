package com.lodenrogue.h343.utilities;

public class GameInfo {
	private static boolean doPlayerMovement = true;

	private GameInfo() {

	}

	public static boolean doPlayerMovement() {
		return doPlayerMovement;
	}

	public static void setDoPlayerMovement(boolean doPlayerMovement) {
		GameInfo.doPlayerMovement = doPlayerMovement;
	}

}
