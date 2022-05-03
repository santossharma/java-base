package org.example.design.factorymethod;

public class Main {
    public static void main(String[] args) {
        Restaurant vegRestaurant = new VeggieBurgerRestaurant();
        Restaurant nonVegRestaurant = new NonVegBurgerRestaurant();

        Burger vegBurger = vegRestaurant.orderBurger("Table 1");
        Burger nonVegBurger = vegRestaurant.orderBurger("Table 2");

    }
}
