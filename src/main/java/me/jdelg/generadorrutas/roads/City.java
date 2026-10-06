package me.jdelg.generadorrutas.roads;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Road> roads = new ArrayList<>();

    public City(List<Trace> traces) {
        for (Trace trace : traces) {
            Intersection start = new Intersection(trace.getStart(), new ArrayList<>());
            Intersection end = new Intersection(trace.getStart(), new ArrayList<>());

            Road road = new Road(
                    trace.getId(),
                    trace.getName(),
                    trace.getWidth(),
                    start,
                    end,
                    trace.getRadius(),
                    trace.getType(),
                    trace.getSense(),
                    trace.getCost(),
                    trace.isOpen()
            );

            start.addRoad(road);
            end.addRoad(road);

            roads.add(road);
        }
    }

    public List<Road> getRoads() {
        return roads;
    }

    public List<Intersection> getIntersections() {
        List<Intersection> intersections = new ArrayList<>();

        for (Road road : roads) {
            if (!intersections.contains(road.getStart()))
                intersections.add(road.getStart());

            if (!intersections.contains(road.getEnd()))
                intersections.add(road.getEnd());
        }

        return intersections;
    }

    @Override
    public String toString() {
        return "City{" +
                "roads=" + roads +
                '}';
    }
}
