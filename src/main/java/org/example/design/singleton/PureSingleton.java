package org.example.design.singleton;

import java.io.Serializable;

/**
 * Created by santoshsharma on 08 May, 2022
 */

public class PureSingleton extends CloneSingleton implements Serializable {

    private static volatile PureSingleton instance;

    private PureSingleton() throws IllegalAccessException {
        if(instance != null) {
            throw new IllegalAccessException("Reflection not supported to create an object!");
        }
    }

    public static PureSingleton getInstance() throws IllegalAccessException {
        if(instance == null) {
            synchronized (PureSingleton.class) {
                instance = new PureSingleton();
            }
        }

        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //throw new CloneNotSupportedException("Clone not allowed!");
        return instance;
    }

    /* readResolve() method is called when ObjectInputStream has read an object from stream
    * and is preparing to return it to the caller. */
    protected Object readResolve() {
        return instance;
    }

}
