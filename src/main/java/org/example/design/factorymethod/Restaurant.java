package org.example.design.factorymethod;

public abstract class Restaurant {
    public Burger orderBurger(String requestFromTableNo) {
        Burger burger = createBurger();
        burger.prepare(requestFromTableNo);

        return burger;
    }

    public abstract Burger createBurger();
}
