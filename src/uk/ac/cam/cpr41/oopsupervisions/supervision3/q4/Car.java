package uk.ac.cam.cpr41.oopsupervisions.supervision3.q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    private String manufacturer;
    private int age;

    public Car(String manufacturer, int age) {
        this.manufacturer = manufacturer;
        this.age = age;
    }

    @Override
    public String toString() {
        return "manufacturer: " + manufacturer + " age: " + age + "\n";
    }

    static final Comparator<Car> MANUFACTURER_THEN_AGE = new Comparator<Car>() {
        @Override
        public int compare(Car c1, Car c2) {
            int byManufacturer = c1.manufacturer.compareTo(c2.manufacturer);
            if (byManufacturer == 0) {
                return ((Integer)c1.age).compareTo(c2.age);
            }
            return byManufacturer;
        }
    };

    public static void main(String args[]) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("BMW",5));
        cars.add(new Car("BMW",2));
        cars.add(new Car("Audi",1));
        cars.add(new Car("Honda",3));
        cars.add(new Car("Honda",13));

        Collections.sort(cars, MANUFACTURER_THEN_AGE);
        System.out.println(cars);
    }
}
