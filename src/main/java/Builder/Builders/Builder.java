package Builder.Builders;

import Builder.Cars.CarType;
import Builder.Components.Engine;
import Builder.Components.GPSNavigator;
import Builder.Components.Transmission;
import Builder.Components.TripComputer;

/**
 * Interfaz común del patrón Builder.
 * Define todos los pasos posibles para configurar un producto.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}