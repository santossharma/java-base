package org.example.java8;

import org.example.java8.domain.Employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Santosh", 44, 19000.00, "Male", "Software Development - Vision", 2012, Arrays.asList("Java", "Spring", "JPA", "Camunda", "React")),
                new Employee(2, "Rana", 24, 17000.00,"Male", "Software Development - APS", 2018, Arrays.asList("Java", "Spring", "JPA", "Python", "Angular")),
                new Employee(2, "Karthik", 23, 15000.00,"Male", "Software Development - APS", 2020, Arrays.asList("CSS", "Typescript", "Javascript", "Angular", "React")),
                new Employee(3, "Sharaf", 34, 22000.00, "Female", "Software Development - Border", 2017, Arrays.asList("Java", "Spring", "JPA", "Design Pattern", "React", "Angular"))
        );

        List<String> techStacks = employeeList.stream()
                //.map(Employee::getTechStack)
                .flatMap((Employee employee) -> employee.getTechStack().stream())
                .collect(Collectors.toList());

        System.out.println(techStacks);

        // maps and removes duplicate
        Set<String> techSet = employeeList.stream()
                //.map(Employee::getTechStack)
                .flatMap((Employee employee) -> employee.getTechStack().stream())
                .collect(Collectors.toSet());
        // sorts the output
        List<String> techList = techSet.stream().sorted().collect(Collectors.toList());

        System.out.println(techList);
    }
}
