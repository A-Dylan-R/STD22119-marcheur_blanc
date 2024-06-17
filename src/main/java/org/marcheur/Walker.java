package org.marcheur;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

@AllArgsConstructor
public class Walker {
    private final Map map;

    public List<Location> walk(String startName, String endName) throws IllegalArgumentException {
        Location start = map.getLocations().get(startName);
        Location end = map.getLocations().get(endName);

        if (start == null || end == null) {
            throw new IllegalArgumentException("No start or end");
        }

        Stack<Location> path = new Stack<>();
        List<Location> visited = new ArrayList<>();

        Random random = new Random();
        Location current = start;

        path.push(current);
        visited.add(current);

        while (!current.equals(end)) {
            List<Location> adjacent = new ArrayList<>(current.getAdjLocations());
            adjacent.removeAll(visited);
            if (adjacent.isEmpty()) {
                if (!path.isEmpty()) {
                    current = path.pop();
                } else {
                    throw new IllegalArgumentException("No path found to the destination");
                }
            } else {
                current = adjacent.get(random.nextInt(adjacent.size()));
                path.push(current);
                visited.add(current);
            }
        }

        return path;
    }
}
