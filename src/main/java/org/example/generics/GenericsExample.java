package org.example.generics;

public class GenericsExample {

    public static void main(String[] args) {

        IntegerPrinter integerPrinter = new IntegerPrinter(100);
        integerPrinter.print();

        Printer<String> stringPrinter = new Printer<>("Generic String");
        stringPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(12.5);
        doublePrinter.print();

        Car audiA4Car = new Car("Audi", "A4", 2004, 20000);
        Vehicle audiA4Vehicle = audiA4Car;
        audiA4Vehicle.accelerate();
        audiA4Vehicle.breaking();
        VehiclePrinter<Car> a4CarPrinter = new VehiclePrinter<>(audiA4Car);
        a4CarPrinter.print();

        Car audiTTCar = new Car("Audi", "TT", 2011, 75000);
        Vehicle audiTTVehicle = audiTTCar;
        audiTTVehicle.accelerate();
        audiTTVehicle.breaking();

        VehiclePrinter<Car> ttCarPrinter = new VehiclePrinter<>(audiTTCar);
        ttCarPrinter.print();

        genericMethod("Santosh", "Sharma");
        genericMethod(123, 456);
    }

    public static <T, V> void genericMethod(T thingsToShout, V otherThingToShout) {
        System.out.print(thingsToShout + " ");
        System.out.println(otherThingToShout);

    }
}
