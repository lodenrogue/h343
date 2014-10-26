package com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents;

import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.managers.GameManager;

/**
 * Player field of view component. Handles view algorithm to display visible
 * tiles.
 * 
 * @author Miguel Hernandez
 *
 */

public class PlayerFieldOfView implements UpdateComponent {
	private Entity[][] map;

	@Override
	public void update(Entity entity) {
		map = GameManager.getMap();
		generateFieldOfView(entity, map);

	}

	private void generateFieldOfView(Entity entity, Entity[][] map) {
		resetMapVisibility(map);
		rightTop(entity, map);
		rightBottom(entity, map);
		leftTop(entity, map);
		leftBottom(entity, map);
		bottomLeft(entity, map);
		bottomRight(entity, map);
		topLeft(entity, map);
		topRight(entity, map);
	}

	/**
	 * Resets the alpha of discovered tiles and sets visibility to false.
	 * 
	 * @param map Map of entities.
	 */

	private void resetMapVisibility(Entity[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {

				if (!map[i][j].getId().contains("player")) {

					if (map[i][j].isDiscovered()) {
						map[i][j].getSprite().setAlpha(0.2f);
					}
					else {
						map[i][j].setVisible(false);
					}
				}
			}
		}
	}

	/**
	 * Handles right top section of field of view.
	 * 
	 * @param entity Owner of this component
	 * @param map Entity map.
	 */
	private void rightTop(Entity entity, Entity[][] map) {
		// X and Y of component owner
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		// For every X and Y on the map
		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {

				// Find the distance between this point on the
				// map and the owner entity.
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dy - dx;
				int y = y1;

				// Iterate through the view section
				for (int x = x1 + 1; x <= x2; x++) {

					/*
					 * Set the entity to discovered and if
					 * the entity is opaque break because we
					 * can't see through the entity.
					 */
					if (D > 0) {
						y += y < map.length - 1 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dy - 2 * dx);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dy);
					}
				}
			}
		}
	}

	private void rightBottom(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dy - dx;
				int y = y1;
				for (int x = x1 + 1; x <= x2; x++) {
					if (D > 0) {
						y -= y > 0 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dy - 2 * dx);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dy);
					}
				}
			}
		}
	}

	private void leftTop(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dx - dy;

				int y = y1;
				for (int x = x1 - 1; x >= 0; x--) {
					if (D > 0) {
						y += y < map.length - 1 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx - 2 * dy);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx);
					}
				}
			}
		}
	}

	private void leftBottom(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dx - dy;

				int y = y1;
				for (int x = x1 - 1; x >= 0; x--) {
					if (D > 0) {
						y -= y > 0 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx - 2 * dy);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx);
					}
				}
			}
		}
	}

	private void bottomLeft(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dx - dy;

				int x = x1;
				for (int y = y1 - 1; y >= 0; y--) {
					if (D > 0) {
						x -= x > 0 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx - 2 * dy);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx);
					}
				}
			}
		}
	}

	private void bottomRight(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dx - dy;
				int x = x1;
				for (int y = y1 - 1; y >= 0; y--) {
					if (D > 0) {
						x += x < map[0].length - 1 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx - 2 * dy);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx);
					}
				}
			}
		}
	}

	private void topLeft(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dx - dy;
				int x = x1;
				for (int y = y1 + 1; y <= y2; y++) {
					if (D > 0) {
						x -= x > 0 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx - 2 * dy);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx);
					}
				}
			}
		}
	}

	private void topRight(Entity entity, Entity[][] map) {
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		for (int x2 = 0; x2 < map[0].length; x2++) {
			for (int y2 = 0; y2 < map.length; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D = 2 * dx - dy;
				int x = x1;
				for (int y = y1 + 1; y <= y2; y++) {
					if (D > 0) {
						x += x < map[0].length - 1 ? 1 : 0;

						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx - 2 * dy);
					}
					else {
						setDiscovered(map, y, x);
						if (map[y][x].isOpaque()) {
							break;
						}
						D = D + (2 * dx);
					}
				}
			}
		}
	}

	/**
	 * Sets the entity in map at row and column to discovered, visible, and
	 * 1.0f alpha.
	 * 
	 * @param map Entity map.
	 * @param row Row containing entity.
	 * @param column Column containing entity.
	 */
	private void setDiscovered(Entity[][] map, int row, int column) {
		Entity e = map[row][column];
		e.getSprite().setAlpha(1.0f);
		e.setVisible(true);
		e.setDiscovered(true);
	}
}