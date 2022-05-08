package org.example.design.singleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by santoshsharma on 08 May, 2022
 */

public class SingletonTest {

    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        PureSingleton pureSingleton = PureSingleton.getInstance();
        PureSingleton pureSingleton2 = (PureSingleton) pureSingleton.clone(); // handled through overriding clone() and returning the same instance obj

        System.out.println("Single Original Obj : \t" + pureSingleton.hashCode());
        System.out.println("Using Clone : \t\t\t" + pureSingleton2.hashCode());

        /*LazySingleton reflectionBasedSinglton = null;
        Constructor[] declaredConstructors = LazySingleton.class.getDeclaredConstructors();
        for(Constructor constructor: declaredConstructors) {
            constructor.setAccessible(true);
            reflectionBasedSinglton = (LazySingleton) constructor.newInstance();
        }
        System.out.println("reflectionBasedSinglton "+ reflectionBasedSinglton.hashCode());*/

        // using serialization
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("serialize.ser"));
        objectOutput.writeObject(pureSingleton);
        objectOutput.close();

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("serialize.ser"));
        PureSingleton serializedLazyObj = (PureSingleton) objectInput.readObject();
        System.out.println("Using Serialization :\t" + serializedLazyObj.hashCode());
    }
}
