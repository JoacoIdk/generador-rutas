package me.jdelg.generadorrutas.transit;

import java.time.LocalDateTime;

import me.jdelg.generadorrutas.Point;

public class Trip {
        private int id;
        private Point first;
        private Point last;
        private LocalDateTime timestamp;
        private Motive motive;

        public Trip(int id, Point first, Point last, LocalDateTime timestamp, Motive motive) {
                this.id = id;
                this.first = first;
                this.last = last;
                this.timestamp = timestamp;
                this.motive = motive;
        }

        public int getId() {
                return id;
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

        public Transit toTransit(Passenger passenger) {
                return new Transit(id, passenger.getName(), first, last, timestamp, motive);
        }
}
