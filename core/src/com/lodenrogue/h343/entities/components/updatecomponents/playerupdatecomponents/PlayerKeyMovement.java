package com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Timer;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.GameInfo;
import com.lodenrogue.h343.utilities.GameTasks;
import com.lodenrogue.h343.utilities.managers.GameManager;

/**
 * Moves player around map based on input and solid state of entities
 * surrounding player.
 * 
 * @author Miguel Hernandez
 *
 */

public class PlayerKeyMovement implements UpdateComponent {
	private Timer movementTimer = new Timer();
	private boolean keyUp, keyDown, keyLeft, keyRight;
	private boolean moveUp, moveDown, moveLeft, moveRight;
	private boolean resetTimer = false;
	private Entity[][] map;

	@Override
	public void update(Entity entity) {
			keyUp = Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W);
			keyDown = Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S);
			keyLeft = Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
			keyRight = Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);

			moveUp = keyUp && !keyDown;
			moveDown = keyDown && !keyUp;
			moveLeft = keyLeft && !keyRight;
			moveRight = keyRight && !keyLeft;

			int column = entity.getPosition().getX();
			int row = entity.getPosition().getY();

			map = GameManager.getMap();

			// First check diagonals

			// ---SE--- //
			if (moveDown && moveRight) {
				if (!isSolid(map, row - 1, column + 1)) {
					moveEntity(entity, map, 1, -1);
				}
				else if (!isSolid(map, row - 1, column)) {
					moveEntity(entity, map, 0, -1);
				}
				else if (!isSolid(map, row, column + 1)) {
					moveEntity(entity, map, 1, 0);
				}
			}

			// ---SW--- //
			else if (moveDown && moveLeft) {
				if (!isSolid(map, row - 1, column - 1)) {
					moveEntity(entity, map, -1, -1);
				}
				else if (!isSolid(map, row - 1, column)) {
					moveEntity(entity, map, 0, -1);
				}
				else if (!isSolid(map, row, column - 1)) {
					moveEntity(entity, map, -1, 0);
				}
			}

			// ---NW--- //
			else if (moveUp && moveLeft) {
				if (!isSolid(map, row + 1, column - 1)) {
					moveEntity(entity, map, -1, 1);
				}
				else if (!isSolid(map, row + 1, column)) {
					moveEntity(entity, map, 0, 1);
				}
				else if (!isSolid(map, row, column - 1)) {
					moveEntity(entity, map, -1, 0);
				}
			}

			// ---NE--- //
			else if (moveUp && moveRight) {
				if (!isSolid(map, row + 1, column + 1)) {
					moveEntity(entity, map, 1, 1);
				}
				else if (!isSolid(map, row + 1, column)) {
					moveEntity(entity, map, 0, 1);
				}
				else if (!isSolid(map, row, column + 1)) {
					moveEntity(entity, map, 1, 0);
				}
			}

			// ---Right--- //
			else if (moveRight) {
				if (!isSolid(map, row, column + 1)) {
					moveEntity(entity, map, 1, 0);
				}
			}

			// ---Left--- //
			else if (moveLeft) {
				if (!isSolid(map, row, column - 1)) {
					moveEntity(entity, map, -1, 0);
				}
			}

			// ---Down--- //
			else if (moveDown) {
				if (!isSolid(map, row - 1, column)) {
					moveEntity(entity, map, 0, -1);
				}
			}

			// ---Up--- //
			else if (moveUp) {
				if (!isSolid(map, row + 1, column)) {
					moveEntity(entity, map, 0, 1);
				}
			}

			if (resetTimer) {
				movementTimer.scheduleTask(GameTasks.getPlayerMovementTask(), 0.1f);
				GameInfo.setDoPlayerMovement(false);
			}
	}

	private boolean isSolid(Entity[][] map, int row, int column) {
		if (row >= 0 && row < map.length) {
			if (column >= 0 && column < map[0].length) {
				if (map[row][column].isSolid()) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
		return true;
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