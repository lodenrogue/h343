package com.lodenrogue.h343.utilities.managers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SpriteManager {
	private static HashMap<String, Texture> images;

	private SpriteManager() {

	}

	public static void load() {
		images = new HashMap<>();
		images.put("bed", new Texture(Gdx.files.internal("bed.png")));
		images.put("computer", new Texture(Gdx.files.internal("computer.png")));
		images.put("door", new Texture(Gdx.files.internal("door.png")));
		images.put("empty", new Texture(Gdx.files.internal("empty.png")));
		images.put("fridge", new Texture(Gdx.files.internal("fridge.png")));
		images.put("ground", new Texture(Gdx.files.internal("ground.png")));
		images.put("opendoor", new Texture(Gdx.files.internal("opendoor.png")));
		images.put("player", new Texture(Gdx.files.internal("player.png")));
		images.put("shower", new Texture(Gdx.files.internal("shower.png")));
		images.put("sink", new Texture(Gdx.files.internal("sink.png")));
		images.put("space", new Texture(Gdx.files.internal("space.png")));
		images.put("television", new Texture(Gdx.files.internal("television.png")));
		images.put("toilet", new Texture(Gdx.files.internal("toilet.png")));
		images.put("wall", new Texture(Gdx.files.internal("wall.png")));
	}

	public static Texture getImage(String key) {
		return images.get(key);
	}

	public static void dispose() {
		Set<Entry<String, Texture>> set = images.entrySet();
		Iterator<Entry<String, Texture>> it = set.iterator();

		while (it.hasNext()) {
			Entry<String, Texture> entry = it.next();
			Texture t = entry.getValue();
			t.dispose();
		}
	}
}
