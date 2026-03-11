# Implementación del patrón Builder en Java

## Ejemplo: Construcción de diferentes tipos de autos

## Introducción

En este ejemplo implemento el **patrón de diseño Builder** utilizando Java para construir distintos tipos de autos.

El objetivo principal es mostrar cómo se puede **separar el proceso de construcción de un objeto complejo de su representación final**, permitiendo crear diferentes variantes del mismo producto utilizando el mismo conjunto de pasos.

En este caso, el sistema puede construir:

* un **auto**
* un **manual del auto**

Ambos productos se generan **siguiendo el mismo proceso de construcción**, pero cada uno tiene una representación diferente.

---

# ¿Qué problema resuelve el patrón Builder?

Cuando un objeto tiene **muchas configuraciones posibles**, su construcción puede volverse complicada.

Por ejemplo, un auto puede tener:

* tipo de vehículo
* número de asientos
* motor
* transmisión
* computadora de viaje
* GPS

Si intentara construir estos objetos con **constructores tradicionales**, podría terminar con constructores muy largos o con muchas combinaciones posibles.

El patrón **Builder** resuelve este problema separando:

1. **Cómo se construye el objeto**
2. **Qué objeto se está construyendo**

Esto permite que el mismo proceso genere **distintos productos**.

---

# Estructura del patrón Builder

En esta implementación aparecen los siguientes participantes del patrón:

| Rol del patrón   | Clase en el proyecto | Descripción                        |
| ---------------- | -------------------- | ---------------------------------- |
| Cliente          | `ConsoleApp`         | Controla la ejecución del programa |
| Director         | `Director`           | Define el orden de construcción    |
| Builder          | `Builder`            | Define los pasos de construcción   |
| Concrete Builder | `CarBuilder`         | Construye el objeto `Car`          |
| Concrete Builder | `CarManualBuilder`   | Construye el objeto `Manual`       |
| Producto         | `Car`                | Representa el auto construido      |
| Producto         | `Manual`             | Representa el manual del auto      |

---

# Paso a paso para implementar el patrón Builder

A continuación explico **cómo fui implementando el patrón paso a paso** dentro del proyecto.

---

# Paso 1 — Identificar el objeto complejo

Primero identifico el objeto que quiero construir.

En este ejemplo el objeto principal es:

```
Car
```

Un auto tiene múltiples componentes:

* tipo de auto
* motor
* transmisión
* asientos
* GPS
* computadora de viaje

Esto lo convierte en un buen candidato para usar **Builder**.

---

# Paso 2 — Definir los pasos de construcción

Después defino una **interfaz Builder** que contiene todos los pasos necesarios para construir el objeto.

```java
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
```

Aquí no me preocupo por **qué objeto se construye**, solo defino **los pasos del proceso de construcción**.

---

# Paso 3 — Crear los Builders concretos

Después implemento los **constructores concretos**, que son las clases responsables de crear productos específicos.

En este ejemplo existen dos:

### Constructor de autos

```
CarBuilder
```

Construye objetos de tipo:

```
Car
```

---

### Constructor de manuales

```
CarManualBuilder
```

Construye objetos de tipo:

```
Manual
```

Esto demuestra una característica interesante del patrón Builder:

> El mismo proceso de construcción puede generar productos distintos.

---

# Paso 4 — Crear el Director

El **Director** define **las recetas de construcción**.

Es decir, decide:

* qué pasos ejecutar
* en qué orden ejecutarlos

Ejemplo:

```java
public void constructSportsCar(Builder builder) {
    builder.setCarType(CarType.SPORTS_CAR);
    builder.setSeats(2);
    builder.setEngine(new Engine(3.0, 0));
    builder.setTransmission(Transmission.SEMI_AUTOMATIC);
    builder.setTripComputer(new TripComputer());
    builder.setGPSNavigator(new GPSNavigator());
}
```

El Director **no sabe qué objeto se construye**.

Solo sabe que está trabajando con un **Builder**.

---

# Paso 5 — Obtener el producto final

Una vez que el Director ejecuta los pasos, el objeto final se obtiene desde el **builder concreto**.

Ejemplo:

```java
CarBuilder builder = new CarBuilder();
director.constructSportsCar(builder);

Car car = builder.getResult();
```

El Director **no conoce el tipo del objeto final**.

Solo el Builder sabe qué está construyendo.

---

# Paso 6 — Crear el cliente que utiliza el patrón

Finalmente implementé una aplicación de consola llamada:

```
ConsoleApp
```

Esta clase permite al usuario elegir qué tipo de auto desea construir.

Ejemplo del menú:

```
1. Crear auto deportivo
2. Crear auto urbano
3. Crear SUV
4. Salir
```

Dependiendo de la opción elegida:

1. El programa crea un builder
2. El director ejecuta la receta de construcción
3. Se obtiene el objeto final
4. Se muestra el resultado en pantalla

---

# Ejemplo de ejecución

```
======================================
   SISTEMA DE CONSTRUCCIÓN DE AUTOS
======================================
1. Crear auto deportivo
2. Crear auto urbano
3. Crear SUV
4. Salir
Seleccione una opción: 1
```

Salida:

```
=== AUTO CONSTRUIDO ===
Tipo: SPORTS_CAR
Asientos: 2
Motor: Volumen=3.0L
Transmisión: SEMI_AUTOMATIC
Computadora de viaje: Sí
GPS: Ruta configurada
```

---

# Ventajas del patrón Builder

En mi implementación puedo observar varias ventajas:

### 1. Código más claro

La construcción del objeto queda separada de su representación.

---

### 2. Mayor flexibilidad

Puedo crear distintos productos usando el mismo proceso de construcción.

---

### 3. Mejor mantenimiento

Si quiero agregar otro tipo de producto, solo necesito crear otro **builder concreto**.

---

### 4. Construcción paso a paso

El objeto se construye gradualmente en lugar de usar constructores gigantes.

---

# Estructura del proyecto

El proyecto se organiza de la siguiente forma:

```
src
 └── builder
      ├── app
      │    └── ConsoleApp.java
      ├── builders
      │    ├── Builder.java
      │    ├── CarBuilder.java
      │    └── CarManualBuilder.java
      ├── cars
      │    ├── Car.java
      │    ├── Manual.java
      │    └── CarType.java
      ├── components
      │    ├── Engine.java
      │    ├── GPSNavigator.java
      │    ├── Transmission.java
      │    └── TripComputer.java
      └── director
           └── Director.java
```

Esta organización facilita entender **qué responsabilidad tiene cada parte del sistema**.

---

# Conclusión

En este ejemplo utilicé el patrón **Builder** para construir distintos tipos de autos y sus manuales siguiendo un mismo proceso de construcción.

El patrón me permite:

* separar la lógica de construcción del objeto
* reutilizar el mismo proceso para crear distintos productos
* mantener el código más claro y extensible

Por estas razones, el patrón Builder es especialmente útil cuando se trabaja con **objetos complejos que pueden tener múltiples configuraciones**.
