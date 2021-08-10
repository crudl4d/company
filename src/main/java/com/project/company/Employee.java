package com.project.company;

import java.util.Date;

public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private Date hire_date;
    private String job_id;
    private int salary;

    public Employee(int employee_id, String first_name, String last_name, String email, Date hire_date, String job_id, int salary) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
    }

    public Employee(String first_name, String last_name, int salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.first_name + " " + this.last_name;
    }
}
