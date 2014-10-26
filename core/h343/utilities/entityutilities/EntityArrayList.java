package com.lodenrogue.h343.utilities.entityutilities;

import java.util.ArrayList;
import java.util.HashMap;

import com.lodenrogue.h343.entities.Entity;

/**
 * ArrayList extension. Contains capabilities to call entity update methods and
 * search/return entities by id.
 * 
 * @author Miguel Hernandez
 *
 */

public class EntityArrayList extends ArrayList<Entity> {
	private HashMap<String, Entity> entityHashMap;

	private static final long serialVersionUID = -125967483749995615L;

	public EntityArrayList() {
		super();
		entityHashMap = new HashMap<>();
	}

	// Appends the specified entity to the end of this list. Also places the
	// entity in a hash map.
	@Override
	public boolean add(Entity e) {
		super.add(e);
		entityHashMap.put(e.getId(), e);
		return true;
	}

	// Calls the update method for each entity in the list.
	public void updateAll() {
		for (Entity e : this) {
			e.update();
		}
	}

	/**
	 * Removes every entity from this list.
	 */
	public void removeAll() {
		for (Entity e : this) {
			remove(e);
			entityHashMap.remove(e.getId());
		}
	}

	/**
	 * Removes a specified entity from the list.
	 * 
	 * @param e Entity to be removed.
	 */
	public void removeEntity(Entity e) {
		remove(e);
		entityHashMap.remove(e.getId());
	}

	/**
	 * Returns an entity identified by it's id.
	 * 
	 * @param id Id of the target entity.
	 * @return Returns the entity associated with the id.
	 */
	public Entity getEntityById(String id) {
		return entityHashMap.get(id);
	}
}