package Builder.App;

import java.util.InputMismatchException;
import java.util.Scanner;

import Builder.Builders.CarBuilder;
import Builder.Builders.CarManualBuilder;
import Builder.Cars.Car;
import Builder.Cars.Manual;
import Builder.Director.Director;

/**
 * Aplicación principal con interfaz en consola.
 */
public class ConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Cliente genera instancia del director
        Director director = new Director();

        int opcion = 0;

        do {
            mostrarMenu();

            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        construirAutoDeportivo(director);
                        break;
                    case 2:
                        construirAutoUrbano(director);
                        break;
                    case 3:
                        construirSUV(director);
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe capturar un número.");
                scanner.nextLine();
            }

        } while (opcion != 4);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n======================================");
        System.out.println("   SISTEMA DE CONSTRUCCIÓN DE AUTOS");
        System.out.println("======================================");
        System.out.println("1. Crear auto deportivo");
        System.out.println("2. Crear auto urbano");
        System.out.println("3. Crear SUV");
        System.out.println("4. Salir");
    }

    private static void construirAutoDeportivo(Director director) {
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getResult();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getResult();

        System.out.println();
        System.out.println(car);
        System.out.println();
        System.out.println(manual.print());
    }

    private static void construirAutoUrbano(Director director) {
        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car car = carBuilder.getResult();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructCityCar(manualBuilder);
        Manual manual = manualBuilder.getResult();

        System.out.println();
        System.out.println(car);
        System.out.println();
        System.out.println(manual.print());
    }

    private static void construirSUV(Director director) {
        CarBuilder carBuilder = new CarBuilder();
        director.constructSUV(carBuilder);
        Car car = carBuilder.getResult();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSUV(manualBuilder);
        Manual manual = manualBuilder.getResult();

        System.out.println();
        System.out.println(car);
        System.out.println();
        System.out.println(manual.print());
    }
}