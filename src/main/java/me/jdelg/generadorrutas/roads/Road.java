package me.jdelg.generadorrutas.roads;

public class Road {
    private int id;
    private String name;
    private double width;
    private Intersection start;
    private Intersection end;
    private double radius;
    private RoadType type;
    private int cost;
    private boolean open;

    public Road(int id, String name, double width, Intersection start, Intersection end, double radius, RoadType type, int cost, boolean open) {
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

    public Intersection getStart() {
        return start;
    }

    public Intersection getEnd() {
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
        return "Road{" +
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
