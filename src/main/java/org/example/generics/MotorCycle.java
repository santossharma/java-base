package org.example.generics;

public class MotorCycle extends Vehicle {

    private double price;
    private String make;
    private String model;
    private int modelYear;

    public MotorCycle(String make, String model, int modelYear, double price) {
        this.price = price;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "MotorCycle{" +
                "price=" + price +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }

    @Override
    public void accelerate() {
        System.out.println("MotorCycle " + make + "'s " + model + " is accelerating.");
    }

    @Override
    public void breaking() {
        System.out.println("MotorCycle " + make + "'s " + model + " is breaking.");
    }
}
