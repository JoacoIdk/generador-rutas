package me.jdelg.generadorrutas.transit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import me.jdelg.generadorrutas.Point;

/*
 * Initial and final have been renamed due to
 * "final" being a keyword in Java.
 */
public class Transit {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy", Locale.of("es", "CL"));

    private int id;
    private String name;
    private Point first;
    private Point last;
    private LocalDateTime timestamp;
    private Motive motive;

    public Transit(int id, String name, Point first, Point last, LocalDateTime timestamp, Motive motive) {
        this.id = id;
        this.name = name;
        this.first = first;
        this.last = last;
        this.timestamp = timestamp;
        this.motive = motive;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Point getFirst() {
        return first;
    }

    public Point getLast() {
        return last;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Motive getMotive() {
        return motive;
    }

    public Trip toTrip() {
        return new Trip(
            id,
            first,
            last,
            timestamp,
            motive
        );
    }

    public static Transit readTransit(String[] line) {
        if (line.length != 8)
            return null;

        return new Transit(
                Integer.parseInt(line[0]),
                line[1],
                new Point(line[2], line[3]),
                new Point(line[4], line[5]),
                LocalDateTime.parse(line[6], FORMATTER),
                Motive.valueOf(line[7])
        );
    }

    public static List<Passenger> toPassengers(List<Transit> transits) {
        Map<String, List<Trip>> passengersMap = new HashMap<>();

        for (Transit transit : transits) {
            if (!passengersMap.containsKey(transit.name))
                passengersMap.put(transit.name, new ArrayList<>());

            passengersMap.get(transit.name).add(transit.toTrip());
        }

        List<Passenger> passengers = new ArrayList<>();

        for (String key : passengersMap.keySet())
            passengers.add(new Passenger(key, passengersMap.get(key)));

        return passengers;
    }
}
