package me.jdelg.generadorrutas.transit;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private List<Trip> trips;

    public Passenger(String name, List<Trip> trips) {
        this.name = name;
        this.trips = trips;
    }

    public String getName() {
        return name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public List<Transit> toTransit() {
        List<Transit> list = new ArrayList<>();

        for (Trip trip : trips)
            list.add(trip.toTransit(this));

        return list;
    }
}
