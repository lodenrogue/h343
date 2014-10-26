package com.lodenrogue.h343.utilities.entityutilities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.lodenrogue.h343.entities.EmptyEntity;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.Ground;
import com.lodenrogue.h343.entities.Player;
import com.lodenrogue.h343.entities.Space;
import com.lodenrogue.h343.entities.Wall;
import com.lodenrogue.h343.entities.furniture.Bed;
import com.lodenrogue.h343.entities.furniture.Computer;
import com.lodenrogue.h343.entities.furniture.Door;
import com.lodenrogue.h343.entities.furniture.Fridge;
import com.lodenrogue.h343.entities.furniture.Shower;
import com.lodenrogue.h343.entities.furniture.Sink;
import com.lodenrogue.h343.entities.furniture.Television;
import com.lodenrogue.h343.entities.furniture.Toilet;
import com.lodenrogue.h343.utilities.managers.SpriteManager;

public class EntityFactory {
	private static long idNum = 0;

	private EntityFactory() {

	}

	public static Entity createEntity(char glyph, int x, int y) {
		String entityName = EntityDefinitions.getElement(String.valueOf(glyph));

		switch (entityName) {
		case "space":
			return createSpace(glyph, x, y);
		case "player":
			return createPlayer(glyph, x, y);
		case "wall":
			return createWall(glyph, x, y);
		case "ground":
			return createGround(glyph, x, y);
		case "bed":
			return createBed(glyph, x, y);
		case "door":
			return createDoor(glyph, x, y);
		case "television":
			return createTelevision(glyph, x, y);
		case "computer":
			return createComputer(glyph, x, y);
		case "fridge":
			return createFridge(glyph, x, y);
		case "sink":
			return createSink(glyph, x, y);
		case "toilet":
			return createToilet(glyph, x, y);
		case "shower":
			return createShower(glyph, x, y);
		default:
			return createUnknown(glyph, x, y);
		}
	}

	private static Entity createUnknown(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("empty"));
		Entity e = new EmptyEntity("testEntity" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createSpace(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("space"));
		Entity e = new Space("space" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createPlayer(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("player"));
		Entity e = new Player("player", glyph, sprite, x, y);
		return e;
	}

	private static Entity createWall(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("wall"));
		Entity e = new Wall("wall" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createGround(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("ground"));
		Entity e = new Ground("ground" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createBed(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("bed"));
		Entity e = new Bed("bed" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createDoor(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("door"));
		Entity e = new Door("door" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;

	}

	private static Entity createTelevision(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("television"));
		Entity e = new Television("television" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createComputer(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("computer"));
		Entity e = new Computer("computer" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createFridge(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("fridge"));
		Entity e = new Fridge("fridge" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createSink(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("sink"));
		Entity e = new Sink("sink" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createToilet(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("toilet"));
		Entity e = new Toilet("toilet" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

	private static Entity createShower(char glyph, int x, int y) {
		Sprite sprite = new Sprite(SpriteManager.getImage("shower"));
		Entity e = new Shower("shower" + idNum, glyph, sprite, x, y);
		idNum++;
		return e;
	}

}