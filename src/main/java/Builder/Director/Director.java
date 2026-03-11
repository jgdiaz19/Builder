package Builder.Director;

import Builder.Builders.Builder;
import Builder.Cars.CarType;
import Builder.Components.Engine;
import Builder.Components.GPSNavigator;
import Builder.Components.Transmission;
import Builder.Components.TripComputer;

/**
 * El Director conoce las recetas de construcción.
 */
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator("Ruta deportiva: autopista -> circuito"));
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(4);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator("Ruta urbana: casa -> trabajo"));
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(5);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator("Ruta SUV: ciudad -> montaña"));
    }
}