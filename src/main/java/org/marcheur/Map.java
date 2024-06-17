package org.marcheur;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class Map {
    private final HashMap<String, Location> locations;

    public Map() {
        this.locations = new HashMap<>();
    }

    public void addLocation(String name) {
        locations.putIfAbsent(name, new Location(name));
    }

    public void addStreet(String from, String to) {
        Location fromLocation = locations.get(from);
        Location toLocation = locations.get(to);
        if (fromLocation != null && toLocation != null) {
            fromLocation.addAdjLocation(toLocation);
            toLocation.addAdjLocation(fromLocation);
        }
    }

}
