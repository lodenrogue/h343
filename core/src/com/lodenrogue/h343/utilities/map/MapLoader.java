package com.lodenrogue.h343.utilities.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.utilities.entityutilities.EntityArrayList;
import com.lodenrogue.h343.utilities.entityutilities.EntityFactory;

public class MapLoader {

	private MapLoader() {

	}

	public static Entity[][] load(String fileName, EntityArrayList entities) {
		return parseArrayList(getLines(fileName), entities);

	}

	private static ArrayList<String> getLines(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();

		try {
			BufferedReader in = new BufferedReader(Gdx.files.internal(fileName).reader());
			String line;

			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		lines = reverseArrayList(lines);

		return lines;
	}

	private static ArrayList<String> reverseArrayList(ArrayList<String> lines) {
		ArrayList<String> tmp = new ArrayList<String>();

		for (int i = lines.size(); i > 0; i--) {
			tmp.add(lines.get(i - 1));
		}

		return tmp;
	}

	private static Entity[][] parseArrayList(ArrayList<String> lines, EntityArrayList entities) {
		int rows = lines.size();
		int columns = lines.get(0).length();
		Entity[][] map = new Entity[rows][columns];

		for (int i = 0; i < rows; i++) {
			char[] glyphs = lines.get(i).toCharArray();
			for (int j = 0; j < columns; j++) {
				map[i][j] = EntityFactory.createEntity(glyphs[j], j, i);
				entities.add(map[i][j]);
			}
		}
		return map;
	}
}
