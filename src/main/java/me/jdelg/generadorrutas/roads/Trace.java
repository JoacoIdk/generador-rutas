package me.jdelg.generadorrutas.roads;

import me.jdelg.generadorrutas.Point;

public class Trace {
    private int id;
    private String name;
    private double width;
    private Point start;
    private Point end;
    private double radius;
    private RoadType type;
    private int cost;
    private boolean open;

    public Trace(int id, String name, double width, Point start, Point end, double radius, RoadType type, int cost, boolean open) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.start = start;
        this.end = end;
        this.radius = radius;
        this.type = type;
        this.cost = cost;
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getRadius() {
        return radius;
    }

    public RoadType getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Trace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", start=" + start +
                ", end=" + end +
                ", radius=" + radius +
                ", type=" + type +
                ", cost=" + cost +
                ", open=" + open +
                '}';
    }
}
