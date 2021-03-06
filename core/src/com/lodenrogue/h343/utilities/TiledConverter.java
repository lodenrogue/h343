package com.lodenrogue.h343.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Converts a Tiled .lua output file into a game .map file.
 * 
 * @author Miguel Hernandez
 *
 */

public class TiledConverter {
	private ArrayList<String> lines = new ArrayList<>();

	public TiledConverter() {

	}

	public static void main(String[] args) {
		TiledConverter t = new TiledConverter();
		t.convert("assets/tiledOutput.lua", "assets/level1.map");
	}

	public void convert(String pathToFile, String targetPathName) {
		lines = readFile(pathToFile);
		lines = cleanSpaces(lines);
		lines = changeGlyphs(lines);
		export(targetPathName, lines);

		System.out.println(targetPathName + " written with the following data: ");
		for (String s : lines) {
			System.out.println(s);
		}
	}

	private void export(String targetPathName, ArrayList<String> outputLines) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(targetPathName));
			for (int i = 0; i < outputLines.size() - 2; i++) {
				out.write(outputLines.get(i) + "\n");
			}
			out.write(outputLines.get(outputLines.size() - 1));
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> changeGlyphs(ArrayList<String> array) {
		ArrayList<String> output = new ArrayList<>();

		for (String s : array) {
			String tmp = s;

			// Do double digit numbers first
			tmp = tmp.replace("12", "#");
			tmp = tmp.replace("11", "t");
			tmp = tmp.replace("10", "T");
			tmp = tmp.replace("9", " ");
			tmp = tmp.replace("8", "s");
			tmp = tmp.replace("7", "S");
			tmp = tmp.replace("6", ".");
			tmp = tmp.replace("5", "F");
			tmp = tmp.replace("4", "?");
			tmp = tmp.replace("3", "O");
			tmp = tmp.replace("2", "C");
			tmp = tmp.replace("1", "B");

			// Remove comma last
			tmp = tmp.replace(",", "");

			output.add(tmp);
		}

		return output;
	}

	private ArrayList<String> cleanSpaces(ArrayList<String> array) {
		ArrayList<String> output = new ArrayList<String>();

		for (String s : array) {
			String tmp = s;
			tmp = tmp.replace(" ", "");
			output.add(tmp);
		}

		return output;
	}

	private ArrayList<String> readFile(String pathToFile) {
		ArrayList<String> inputLines = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(pathToFile));
			String line;
			boolean record = false;

			while ((line = in.readLine()) != null) {
				if (line.contains("data =")) {
					line = in.readLine();
					record = true;
				}
				if (record) {
					if (!line.contains("}")) {
						inputLines.add(line);
					}
				}
			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return inputLines;
	}

}
