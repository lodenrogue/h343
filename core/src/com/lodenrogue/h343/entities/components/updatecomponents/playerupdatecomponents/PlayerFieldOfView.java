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
	private int distance;

	/**
	 * Create a PlayerFieldOfView component with a view distance value of
	 * 11.
	 */
	public PlayerFieldOfView() {
		this(11);
	}

	/**
	 * Creates a PlayerFieldOfView component with a given view distance
	 * value.
	 * 
	 * @param viewDistance Distance used calculate for field of view.
	 */
	public PlayerFieldOfView(int viewDistance) {
		distance = viewDistance;
	}

	@Override
	public void update(Entity entity) {
		map = GameManager.getMap();
		generateFieldOfView(entity, map);

	}

	private void generateFieldOfView(Entity entity, Entity[][] map) {
		resetMapVisibility(map);
		handleFieldOfView(entity, map);
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

	private void handleFieldOfView(Entity entity, Entity[][] map) {
		// X and Y of component owner
		int x1 = entity.getPosition().getX();
		int y1 = entity.getPosition().getY();

		int targetMinX = (int) (x1 - distance);
		int targetMaxX = (int) (x1 + distance);
		int targetMinY = (int) (y1 - distance);
		int targetMaxY = (int) (y1 + distance);

		targetMinX = targetMinX < 0 ? 0 : targetMinX;
		targetMaxX = targetMaxX > map[0].length ? map[0].length : targetMaxX;
		targetMinY = targetMinY < 0 ? 0 : targetMinY;
		targetMaxY = targetMaxY > map.length ? map.length : targetMaxY;

		for (int x2 = targetMinX; x2 < targetMaxX; x2++) {
			for (int y2 = targetMinY; y2 < targetMaxY; y2++) {
				int dx = Math.abs(x2 - x1);
				int dy = Math.abs(y2 - y1);

				int D1 = 2 * dy - dx;
				int D2 = 2 * dx - dy;

				rightQuadrant(entity, map, x1, y1, x2, y2, dx, dy, D1);
				leftQuadrant(entity, map, x1, y1, x2, y2, dx, dy, D2);
				bottomQuadrant(entity, map, x1, y1, x2, y2, dx, dy, D2);
				topQuadrant(entity, map, x1, y1, x2, y2, dx, dy, D2);
			}
		}
	}

	private void rightQuadrant(Entity entity, Entity[][] map, int x1, int y1, int x2, int y2, int dx, int dy, int D) {
		int Delta = D;
		int ya = y1;
		int yb = y1;
		boolean yaDone = false;
		boolean ybDone = false;

		for (int x = x1 + 1; x <= x2; x++) {
			if (Delta > 0) {
				ya += ya < map.length - 1 ? 1 : 0;
				yb -= yb > 0 ? 1 : 0;

				if (!yaDone) {
					setDiscovered(map, ya, x);
					if (map[ya][x].isOpaque()) {
						yaDone = true;
					}
				}
				if (!ybDone) {
					setDiscovered(map, yb, x);
					if (map[yb][x].isOpaque()) {
						ybDone = true;
					}
				}

				if (yaDone && ybDone) {
					break;
				}
				Delta = Delta + (2 * dy - 2 * dx);
			}
			else {
				if (!yaDone) {
					setDiscovered(map, ya, x);
					if (map[ya][x].isOpaque()) {
						yaDone = true;
					}
				}
				if (!ybDone) {
					setDiscovered(map, yb, x);
					if (map[yb][x].isOpaque()) {
						ybDone = true;
					}
				}

				if (yaDone && ybDone) {
					break;
				}
				Delta = Delta + (2 * dy);
			}
		}
	}

	private void leftQuadrant(Entity entity, Entity[][] map, int x1, int y1, int x2, int y2, int dx, int dy, int D) {
		int Delta = D;
		int ya = y1;
		int yb = y1;
		boolean yaDone = false;
		boolean ybDone = false;

		for (int x = x1 - 1; x >= 0; x--) {
			if (Delta > 0) {
				ya += ya < map.length - 1 ? 1 : 0;
				yb -= yb > 0 ? 1 : 0;

				if (!yaDone) {
					setDiscovered(map, ya, x);
					if (map[ya][x].isOpaque()) {
						yaDone = true;
					}
				}
				if (!ybDone) {
					setDiscovered(map, yb, x);
					if (map[yb][x].isOpaque()) {
						ybDone = true;
					}
				}

				if (yaDone && ybDone) {
					break;
				}
				Delta = Delta + (2 * dx - 2 * dy);
			}
			else {
				if (!yaDone) {
					setDiscovered(map, ya, x);
					if (map[ya][x].isOpaque()) {
						yaDone = true;
					}
				}
				if (!ybDone) {
					setDiscovered(map, yb, x);
					if (map[yb][x].isOpaque()) {
						ybDone = true;
					}
				}

				if (yaDone && ybDone) {
					break;
				}
				Delta = Delta + (2 * dx);
			}
		}
	}

	private void bottomQuadrant(Entity entity, Entity[][] map, int x1, int y1, int x2, int y2, int dx, int dy, int D) {
		int Delta = D;
		int xa = x1;
		int xb = x1;
		boolean xaDone = false;
		boolean xbDone = false;

		for (int y = y1 - 1; y >= 0; y--) {
			if (Delta > 0) {
				xa -= xa > 0 ? 1 : 0;
				xb += xb < map[0].length - 1 ? 1 : 0;

				if (!xaDone) {
					setDiscovered(map, y, xa);
					if (map[y][xa].isOpaque()) {
						xaDone = true;
					}
				}
				if (!xbDone) {
					setDiscovered(map, y, xb);
					if (map[y][xb].isOpaque()) {
						xbDone = true;
					}
				}

				if (xaDone && xbDone) {
					break;
				}
				Delta = Delta + (2 * dx - 2 * dy);
			}
			else {
				if (!xaDone) {
					setDiscovered(map, y, xa);
					if (map[y][xa].isOpaque()) {
						xaDone = true;
					}
				}
				if (!xbDone) {
					setDiscovered(map, y, xb);
					if (map[y][xb].isOpaque()) {
						xbDone = true;
					}
				}

				if (xaDone && xbDone) {
					break;
				}
				Delta = Delta + (2 * dx);
			}
		}
	}

	private void topQuadrant(Entity entity, Entity[][] map, int x1, int y1, int x2, int y2, int dx, int dy, int D) {
		int Delta = D;
		int xa = x1;
		int xb = x1;
		boolean xaDone = false;
		boolean xbDone = false;

		for (int y = y1 + 1; y <= y2; y++) {
			if (Delta > 0) {
				xa -= xa > 0 ? 1 : 0;
				xb += xb < map[0].length - 1 ? 1 : 0;

				if (!xaDone) {
					setDiscovered(map, y, xa);
					if (map[y][xa].isOpaque()) {
						xaDone = true;
					}
				}
				if (!xbDone) {
					setDiscovered(map, y, xb);
					if (map[y][xb].isOpaque()) {
						xbDone = true;
					}
				}

				if (xaDone && xbDone) {
					break;
				}
				Delta = Delta + (2 * dx - 2 * dy);
			}
			else {
				if (!xaDone) {
					setDiscovered(map, y, xa);
					if (map[y][xa].isOpaque()) {
						xaDone = true;
					}
				}
				if (!xbDone) {
					setDiscovered(map, y, xb);
					if (map[y][xb].isOpaque()) {
						xbDone = true;
					}
				}

				if (xaDone && xbDone) {
					break;
				}
				Delta = Delta + (2 * dx);
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