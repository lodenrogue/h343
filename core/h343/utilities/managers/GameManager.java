package com.lodenrogue.h343.utilities.managers;

import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.utilities.GameTasks;
import com.lodenrogue.h343.utilities.entityutilities.EntityArrayList;
import com.lodenrogue.h343.utilities.map.Map;

public class GameManager {
	private static EntityArrayList entities;
	private static Map map;

	private GameManager() {

	}

	public static void init(Map map, EntityArrayList entities) {
		setMap(map);
		GameTasks.createTasks();
		setEntities(entities);
	}
	
	public static void setEntities(EntityArrayList entities){
		GameManager.entities = entities;
	}
	
	public static EntityArrayList getEntities(){
		return entities;
	}
	
	public static void setMap(Map map){
		GameManager.map = map;
	}
	
	public static Entity[][] getMap(){
		return map.getMap();
	}
	
	
}
