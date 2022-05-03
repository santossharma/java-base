package org.example.design.factorymethod;

public class NonVegBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new NonVegBurger();
    }
}
