package com.lodenrogue.h343.utilities;

import com.lodenrogue.h343.entities.Entity;

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
	
	/**
	 * Checks if the target is adjacent to this entity.
	 * 
	 * @param entity First entity to check position.
	 * @param target Target entity to check if adjacent to first entity.
	 * @return Returns true if target is adjacent to entity. Else, false.
	 */
	public static boolean isTargetAdjacent(Entity entity, Entity target) {
		int eX = entity.getPosition().getX();
		int eY = entity.getPosition().getY();
		int tX = target.getPosition().getX();
		int tY = target.getPosition().getY();

		if (eX - 1 == tX && eY == tY) {
			return true;
		}

		if (eX + 1 == tX && eY == tY) {
			return true;
		}

		if (eX == tX && eY - 1 == tY) {
			return true;
		}

		if (eX == tX && eY + 1 == tY) {
			return true;
		}
		return false;
	}

}
