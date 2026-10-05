package me.jdelg.generadorrutas;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import me.jdelg.generadorrutas.transit.Passenger;
import me.jdelg.generadorrutas.transit.Transit;

public class Main {
    static void main(String[] args) {
        Arguments arguments = new Arguments(args);
        Logger logger = Logger.getLogger("Main-Thread");

        if (args.length <= 2) {
            logger.info("USAGE: generator <trips path> <city path>");
            System.exit(1);
            return;
        }

        String tripsPath = arguments.readString();
        Path path = Path.of(tripsPath);

        if (!Files.isRegularFile(path)) {
            logger.warning("Trips path provided is not a file!");
            System.exit(0);
            return;
        }

        List<Transit> transits = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int index = 0;

            while (true) {
                if (index == 0) {
                    index++;
                    continue;
                }

                String line = reader.readLine();

                if (line == null)
                    break;

                Transit transit = Transit.readTransit(line.split(","));

                transits.add(transit);

                index++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Passenger> passengers = Transit.toPassengers(transits);

        // Do something.
    }
}
