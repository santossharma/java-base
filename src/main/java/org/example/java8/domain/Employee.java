package org.example.java8.domain;

import java.util.List;

public class Employee {
    private int employeeId;
    private String employeeName;
    private int age;
    private double salary;
    private String gender;
    private String department;
    private int yearOfJoining;
    private List<String> techStack;

    public Employee(int employeeId, String employeeName, int age, double salary, String gender, String department, int yearOfJoining, List<String> techStack) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.techStack = techStack;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", techStack=" + techStack +
                '}';
    }
}
