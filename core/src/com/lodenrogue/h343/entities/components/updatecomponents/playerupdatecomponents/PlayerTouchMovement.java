package com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.GameInfo;
import com.lodenrogue.h343.utilities.GameTasks;
import com.lodenrogue.h343.utilities.managers.GameManager;

public class PlayerTouchMovement implements UpdateComponent {
	private Entity[][] map;
	private Timer movementTimer = new Timer();
	private boolean resetTimer = false;

	@Override
	public void update(Entity entity) {
		map = GameManager.getMap();

		Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		GameManager.getCamera().unproject(touchPos);

		float cameraX = GameManager.getCamera().position.x;

		if (touchPos.x < cameraX) {
			moveEntity(entity, map, -1, 0);
		}
		else {
			moveEntity(entity, map, 1, 0);
		}

		if (resetTimer) {
			movementTimer.scheduleTask(GameTasks.getPlayerMovementTask(), 0.1f);
			GameInfo.setDoPlayerMovement(false);
		}

	}

	private void moveEntity(Entity entity, Entity[][] map, int xOffset, int yOffset) {
		int column = entity.getPosition().getX();
		int row = entity.getPosition().getY();

		int newX = column + xOffset;
		int newY = row + yOffset;

		boolean xMovementInBounds = newX < map[0].length && newX >= 0;
		boolean yMovementInBounds = newY < map.length && newY >= 0;
		boolean moveInBounds = xMovementInBounds && yMovementInBounds;

		if (moveInBounds) {
			entity.getPosition().setX(newX);
			entity.getPosition().setY(newY);
			resetTimer = true;
		}
	}

}
