package org.example.design.factorymethod;

public class VeggieBurger implements Burger {
    @Override
    public void prepare(String requestFromTableNo) {
        System.out.println("Preparing Veggie Burger for " + requestFromTableNo);
    }
}
