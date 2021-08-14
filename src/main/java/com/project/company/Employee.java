package com.project.company;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Resource;
import java.util.Date;
@AllArgsConstructor
@Resource
@Data
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private int salary;
    private int commissionPct;
    private int managerId;
    private int deptId;

    public Employee(int employeeId, String firstName, String lastName, String email, Date hireDate, String jobId, int salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
    }

    public Employee(String firstMame, String lastName, int salary) {
        this.firstName = firstMame;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
