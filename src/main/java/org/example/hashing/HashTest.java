package org.example.hashing;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by santoshsharma on 06 May, 2022
 */
public class HashTest {

    static Map<Fruit, String> fruitMap = new HashMap<>();

    public static void main(String[] args) {
        fruitMap.put(new Fruit("Apple"), "Red Apple");
        fruitMap.put(new Fruit("apple"), "Red Apple");
        fruitMap.put(new Fruit("Apple1"), "Red Apple");

        String apple = fruitMap.get(new Fruit("apple"));

        System.out.println(apple);
    }

    static class Fruit {
        private String name;

        public Fruit(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            int hash = name != null ? name.hashCode() : 0;
            System.out.println("\t Inside Hashcode '" + name + "' Calculated Hash: "+ hash);

            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Fruit fruit = (Fruit) obj;

            System.out.println("Inside equals() Old Name '"+fruit.name+"' and New Name "+name);
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            return Objects.equals(name, fruit.name);
        }
    }
}
