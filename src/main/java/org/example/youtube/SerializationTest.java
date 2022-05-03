package org.example.youtube;

import java.io.*;

public class SerializationTest implements Serializable {

    public static void main(String[] args) {
        SerializationDomain  serializationDomain = new SerializationDomain();
        serializationDomain.a = "A-Value";
        serializationDomain.b = "B-Value";
        serializationDomain.c = "C-Value";
        serializationDomain.d = "D-Value";
        serializationDomain.e = "E-Value";
        serializationDomain.f = "F-Value";

        // To Serialize
        String fileName = "file.ser";
         try {
             FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             objectOutputStream.writeObject(serializationDomain);
             objectOutputStream.close();
             fileOutputStream.close();
             System.out.println("Object has been serialized");

         } catch (IOException e) {
             e.printStackTrace();
         }

         // To de-serialize
        SerializationDomain deSerializationDomain = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deSerializationDomain = (SerializationDomain) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Object has been de-serialized");

            System.out.println(deSerializationDomain.a);
            System.out.println(deSerializationDomain.b);
            System.out.println(deSerializationDomain.c);
            System.out.println(deSerializationDomain.d);
            System.out.println(deSerializationDomain.e);
            System.out.println(deSerializationDomain.f);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


class SerializationDomain implements Serializable {
    public transient String a;
    public transient String b = "B";
    public static String c;
    public static String d = "D";
    public static transient String e;
    public static transient String f = "F";
}
