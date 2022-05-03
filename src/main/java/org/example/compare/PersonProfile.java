package org.example.compare;

/**
 * Created by santoshsharma on 26 Apr, 2022, at 20:32
 */

public record PersonProfile(int profileId, String name) implements Comparable<PersonProfile> {
    @Override
    // Single sorting method
    public int compareTo(PersonProfile profile) {
        if (profileId == profile.profileId()) {
            return 0;
        } else if (profileId > profile.profileId()) {
            return 1;
        }

        return -1;
    }
}
