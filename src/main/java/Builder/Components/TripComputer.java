package Builder.Components;

import Builder.Cars.Car;

/**
 * Componente del auto: computadora de viaje.
 */
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Nivel de combustible: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("El auto está encendido.");
        } else {
            System.out.println("El auto está apagado.");
        }
    }
}