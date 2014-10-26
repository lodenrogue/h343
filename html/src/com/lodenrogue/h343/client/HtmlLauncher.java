package com.lodenrogue.h343.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.lodenrogue.h343.H343;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(H343.WIDTH, H343.HEIGHT);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new H343();
        }
}