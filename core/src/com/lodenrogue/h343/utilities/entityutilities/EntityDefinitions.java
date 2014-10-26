package com.lodenrogue.h343.utilities.entityutilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;

public class EntityDefinitions {
	private static HashMap<String, String> definitions;

	private EntityDefinitions() {

	}

	/**
	 * Initializes glyph definitions. Takes in a definition file name.
	 * 
	 * @param defFileName Definition file name.
	 */

	public static void initDefinitions(String defFileName) {
		definitions = new HashMap<String, String>();

		BufferedReader in = new BufferedReader(Gdx.files.internal(defFileName).reader());
		String line;

		try {
			while ((line = in.readLine()) != null) {
				String key = line.substring(0, 1);
				String value = line.substring(line.indexOf("=") + 1);
				definitions.put(key, value);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getElement(String key) {
		return definitions.get(key);
	}

	/**
	 * Converts all glyph keys into a single string.
	 * 
	 * @return Returns a single string containing all glyphs.
	 */

	public static String getAllGlyphs() {
		String glyphs = "";

		Object[] keys = definitions.keySet().toArray();
		for (Object k : keys) {
			glyphs += k.toString();
		}

		return glyphs;
	}
}
