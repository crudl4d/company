package com.company;

public class Employee {
    private String first_name;
    private String last_name;
    private int salary;

    public Employee(String first_name, String last_name, int salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getSalary() {
        return salary;
    }
}
