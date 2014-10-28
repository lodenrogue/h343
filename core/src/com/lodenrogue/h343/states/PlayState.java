package com.lodenrogue.h343.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.H343;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.Position;
import com.lodenrogue.h343.utilities.GameCamera;
import com.lodenrogue.h343.utilities.entityutilities.EntityArrayList;
import com.lodenrogue.h343.utilities.entityutilities.EntityDefinitions;
import com.lodenrogue.h343.utilities.entityutilities.EntityFactory;
import com.lodenrogue.h343.utilities.managers.GameManager;
import com.lodenrogue.h343.utilities.map.Map;
import com.lodenrogue.h343.utilities.map.MapLoader;

/**
 * Game play state. Handles all main game play logic and graphics.
 * 
 * @author Miguel Hernandez
 *
 */

public class PlayState extends State {
	private BitmapFont font;
	private Map map;
	private EntityArrayList entities = new EntityArrayList();
	private boolean debug = true;
	private GameCamera camera;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void create() {
		EntityDefinitions.initDefinitions("GlyphDefinitions.def");
		initCamera();
		initFont();
		initMap();
		initPlayer();
		GameManager.init(map, entities);
	}

	@Override
	public void update() {
		// Fill map needs to be called before entities get updated and
		// before map gets rendered.
		map.fillMap();
		entities.updateAll();
		camera.updatePosistion(GameManager.getEntities().getEntityById("player"));

		// Call camera update and batch.setProjectionMatrix AFTER all
		// logic has been updated
		camera.update();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		map.render(batch);
		if (debug) {
			debugRender(batch);
		}
	}

	@Override
	public void dispose() {
		font.dispose();
	}

	private void debugRender(SpriteBatch batch) {
		Entity player = entities.getEntityById("player");
		Position pPos = player.getPosition();
		float x = camera.position.x - H343.WIDTH/2;
		float y = camera.position.y + H343.HEIGHT / 2;
		font.draw(batch, "Player position: (" + pPos.getX() + ", " + pPos.getY() + ") fps: " + Gdx.graphics.getFramesPerSecond(), x, y);
		font.draw(batch, "Arrow keys to move. E to open doors. (O)", x, y - 20f);
	}

	private void initCamera() {
		camera = new GameCamera();
		camera.setToOrtho(false, H343.WIDTH, H343.HEIGHT);
		H343.viewport.setCamera(camera);
		GameManager.setCamera(camera);
	}

	private void initFont() {
		font = new BitmapFont();
		// font.setFixedWidthGlyphs(EntityDefinitions.getAllGlyphs());
	}

	private void initMap() {
		map = new Map(MapLoader.load("level1.map", entities));
	}

	private void initPlayer() {
		entities.add(EntityFactory.createEntity('@', 22, 12));
	}
}
