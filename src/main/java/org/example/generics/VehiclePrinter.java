package org.example.generics;

public class VehiclePrinter <T> {
    T thingsToPrint;

    public VehiclePrinter(T thingsToPrint) {
        this.thingsToPrint = thingsToPrint;
    }

    public void print() {
        System.out.println(thingsToPrint);
    }
}
