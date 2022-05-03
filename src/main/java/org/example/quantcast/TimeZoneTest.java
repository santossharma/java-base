package org.example.quantcast;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) {

        System.out.println("2. Setting UTC as default time zone");
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        //Setting UTC time zone
        TimeZone.setDefault(utcTimeZone);

        System.out.println(new Date());


        /*
        //Get default time zone
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("1. Default time zone is:");
        System.out.println(timeZone);


        Date now = new Date();
        System.out.println("Current Date in milliseconds is :" + now.getTime());
        // Display the instant in three different time zones
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        System.out.println(now);
        TimeZone.setDefault( TimeZone.getTimeZone("GMT"));
        System.out.println(now);
        TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
        System.out.println(now);

        System.out.println(Locale.getDefault());

        //Get default time zone
        TimeZone timeZone1 = TimeZone.getDefault();
        System.out.println("1. Default time zone is:");
        System.out.println(timeZone1);*/


    }
}
