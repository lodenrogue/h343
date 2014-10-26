package com.lodenrogue.h343.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lodenrogue.h343.H343;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = H343.WIDTH;
		config.height = H343.HEIGHT;
		config.title = H343.TITLE;
		new LwjglApplication(new H343(), config);

	}
}
