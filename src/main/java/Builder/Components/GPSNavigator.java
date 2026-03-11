package Builder.Components;

/**
 * Componente del auto: navegador GPS.
 */
public class GPSNavigator {
    private final String route;

    public GPSNavigator() {
        this.route = "Ruta predeterminada: centro de la ciudad -> destino principal";
    }

    public GPSNavigator(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return "Ruta configurada: " + route;
    }
}