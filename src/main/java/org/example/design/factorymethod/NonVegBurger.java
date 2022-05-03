package org.example.design.factorymethod;

public class NonVegBurger implements Burger {
    @Override
    public void prepare(String requestFromTableNo) {
        System.out.println("Preparing Non Veggie Burger for "+ requestFromTableNo);
    }
}
