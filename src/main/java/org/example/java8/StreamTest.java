package org.example.java8;

import org.example.java8.domain.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Santosh", 44, 19000.00, "Male", "Software Development - Vision", 2012, null),
                new Employee(2, "Rana", 24, 17000.00,"Male", "Software Development - APS", 2018, null),
                new Employee(2, "Karthik", 23, 15000.00,"Male", "Software Development - APS", 2020, null),
                new Employee(3, "Sharaf", 34, 22000.00, "Female", "Software Development - Border", 2017, null)
        );

        Optional<Employee> employee = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        Map<String, Long> noOfMaleFemaleEmployees = employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println("\nDepartment distinct ");
        employeeList.stream()
                        .map(Employee::getDepartment)
                                .distinct()
                .forEach(System.out::println);

        System.out.println("\nSpecific Department (Like Search)");
        employeeList.stream()
                .filter(emp->emp.getDepartment().toUpperCase().contains("APS"))
                .forEach(System.out::println);

        System.out.println("\nHighest Paid Employee - " + employee);
        System.out.println("\nNo Of Male Female Employees Employee - " + noOfMaleFemaleEmployees);

        Optional<Employee> oldestJoinedEmployee = employeeList.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        System.out.println("Oldest employee as per joining date " + oldestJoinedEmployee );

        employeeList.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)))
                .stream().forEach(emp-> System.out.println("\n"+emp.getEmployeeName() + " has joined in " + emp.getYearOfJoining()));


        // Employee who has joined after 2013
        System.out.println("\nEmployee who has joined after 2013");
        employeeList.stream()
                .filter(emp -> emp.getYearOfJoining() > 2013)
                        .map(Employee::getEmployeeName)
                                .forEach(System.out::println);

        System.out.println("Count no of employee in each department");
        Map<String, Long> departmentCountMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(departmentCountMap);


        Map<String, List<Employee>> employeeByGender = employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("Group by gender " + employeeByGender);

        Map<Integer, List<String>> employeeNameByAgeMap = employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getEmployeeName, Collectors.toList())));
        System.out.println("Group by name " + employeeNameByAgeMap);

        System.out.println("Iterating Map -->");
        System.out.println("-----------------");
        departmentCountMap.forEach((k,v) -> System.out.println("DEPARTMENT : " + k + " COUNT : " + v));
        System.out.println("Iterating using map.keySet() --> ");
        departmentCountMap.keySet().forEach(k -> System.out.println("DEPARTMENT : " + k + " COUNT : " + departmentCountMap.get(k)));
        System.out.println("Iterating using map.entrySet() --> ");
        departmentCountMap.entrySet().forEach(entry -> System.out.println("DEPARTMENT : " + entry.getKey() + " COUNT : " + entry.getValue()));

        var list = List.of(2, 10, 5, 7, 8);

    }
}
