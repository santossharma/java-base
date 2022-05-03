package org.example.java8;

import org.example.java8.domain.LegalityStatusType;
import org.example.java8.domain.Profile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByTest {

    public static void main(String[] args) {
        List<Profile> profileList = Arrays.asList(
                new Profile("Sharma", 1L, LegalityStatusType.RESIDENCE),
                new Profile("Santosh", 1L, LegalityStatusType.RESIDENCE),
                new Profile("Darwish", 1L, LegalityStatusType.UAE_LOCAL)
        );

        Map<LegalityStatusType, List<Profile>> postsPerType = profileList.stream()
                .collect(groupingBy(Profile::getLegalityStatusType));

        Map<LegalityStatusType, Map<Long, List<Profile>>> postsPerTypes = profileList.stream()
                .collect(groupingBy(Profile::getLegalityStatusType, groupingBy(Profile::getGenderId)));


        System.out.println(postsPerType);
        System.out.println(postsPerTypes);
    }
}
