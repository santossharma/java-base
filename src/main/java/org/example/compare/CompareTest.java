package org.example.compare;

import java.util.*;

/**
 * Created by santoshsharma on 26 Apr, 2022, at 20:37
 */

public class CompareTest {
    public static void main(String[] args) {
        Set<PersonProfile> personProfiles = new HashSet<>();

        personProfiles.add(new PersonProfile(102, "Santosh"));
        personProfiles.add(new PersonProfile(103, "Kumar"));
        personProfiles.add(new PersonProfile(101, "Sharma"));
        personProfiles.add(new PersonProfile(101, "Santosh"));

        // Sorting a Set
        List<PersonProfile> personProfileList = new ArrayList<>(personProfiles);
        //Collections.sort(personProfileList);

        Collections.sort(personProfileList, new ProfileIdComparator());
        System.out.println(personProfileList);
    }
}
