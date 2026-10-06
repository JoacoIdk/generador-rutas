package me.jdelg.generadorrutas.roads;

import java.util.List;

import me.jdelg.generadorrutas.Point;

public class Intersection {
    private Point location;
    private List<Road> roads;

    public Intersection(Point location, List<Road> roads) {
        this.location = location;
        this.roads = roads;
    }

    public Point getLocation() {
        return location;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "location=" + location +
                ", roads=" + roads +
                '}';
    }
}
