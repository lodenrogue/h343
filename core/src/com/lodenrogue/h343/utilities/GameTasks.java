package com.lodenrogue.h343.utilities;

import com.badlogic.gdx.utils.Timer.Task;

public class GameTasks {
	private static Task playerMovementTask;

	private GameTasks() {

	}

	public static void createTasks() {
		playerMovementTask = new Task() {
			@Override
			public void run() {
				GameInfo.setDoPlayerMovement(true);
			}
		};
	}

	public static Task getPlayerMovementTask() {
		return playerMovementTask;
	}

}
