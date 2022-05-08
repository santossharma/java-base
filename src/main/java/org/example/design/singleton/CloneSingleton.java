package org.example.design.singleton;

/**
 * Created by santoshsharma on 08 May, 2022
 */

public class CloneSingleton implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
