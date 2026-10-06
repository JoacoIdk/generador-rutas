package me.jdelg.generadorrutas;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(String a, String b) {
        this(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point point) {
            return point.x == this.x && point.y == this.y;
        }

        return false;
    }
}
