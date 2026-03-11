package Builder.Cars;

import Builder.Components.Engine;
import Builder.Components.GPSNavigator;
import Builder.Components.Transmission;
import Builder.Components.TripComputer;

/**
 * Producto concreto: Auto.
 */
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;

        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }

        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "=== AUTO CONSTRUIDO ===\n" +
                "Tipo: " + carType + "\n" +
                "Asientos: " + seats + "\n" +
                "Motor: " + engine + "\n" +
                "Transmisión: " + transmission + "\n" +
                "Computadora de viaje: " + (tripComputer != null ? "Sí" : "No") + "\n" +
                "GPS: " + (gpsNavigator != null ? gpsNavigator : "No incluido") + "\n" +
                "Combustible: " + fuel;
    }
}