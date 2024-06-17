package org.marcheur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Location {
    private String name;
    private List<Location> adjLocations = new ArrayList<>();

    public Location(String name) {
        this.name = name;
        this.adjLocations = new ArrayList<>();
    }

    public void addAdjLocation(Location location) {
        adjLocations.add(location);
    }
}
