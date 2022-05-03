package org.example.compare;

import java.util.Comparator;

/**
 * Created by santoshsharma on 26 Apr, 2022, at 20:47
 */

public class ProfileIdComparator implements Comparator<PersonProfile> {
    @Override
    public int compare(PersonProfile personProfile1, PersonProfile personProfile2) {
        if(personProfile1.profileId() == personProfile2.profileId()) {
            // Once profile ids are equal then sorting based on name
            return personProfile1.name().compareTo(personProfile2.name());
        } else if(personProfile1.profileId() > personProfile2.profileId()) {
            return 1;
        }
        return -1;
    }
}
