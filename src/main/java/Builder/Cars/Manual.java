package Builder.Cars;

import Builder.Components.Engine;
import Builder.Components.GPSNavigator;
import Builder.Components.Transmission;
import Builder.Components.TripComputer;

/**
 * Producto concreto: Manual del auto.
 */
public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(CarType carType, int seats, Engine engine, Transmission transmission,
                  TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "=== MANUAL DEL AUTO ===\n";
        info += "Tipo de auto: " + carType + "\n";
        info += "Cantidad de asientos: " + seats + "\n";
        info += "Motor: volumen = " + engine.getVolume() + "L; kilometraje = " + engine.getMileage() + "\n";
        info += "Transmisión: " + transmission + "\n";

        if (this.tripComputer != null) {
            info += "Computadora de viaje: Funcional\n";
        } else {
            info += "Computadora de viaje: No incluida\n";
        }

        if (this.gpsNavigator != null) {
            info += "GPS: Funcional\n";
            info += "Ruta del GPS: " + gpsNavigator.getRoute() + "\n";
        } else {
            info += "GPS: No incluido\n";
        }

        return info;
    }
}