package com.company.windows;

import com.company.lists.EmployeeListModel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EmployeeDetails {
    final JFrame empDetails = new JFrame("Employee details");
    final List<JLabel> details = Arrays.asList(
            new JLabel("ID: "),
            new JLabel("First name: "),
            new JLabel("Last name: "),
            new JLabel("Email: "),
            new JLabel("Phone number: "),
            new JLabel("Hire date: "),
            new JLabel("Job ID: "),
            new JLabel("Commission pct: "),
            new JLabel("Manager ID: "),
            new JLabel("Department's ID: ")
    );
    public EmployeeDetails(EmployeeListModel listModel, Statement statement, int index) {
        var empId = listModel.getEmployeeRepository().get(index).getEmployee_id();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE employee_id = " + empId);
            resultSet.next();
            for (int i = 0; i < resultSet.getFetchSize(); i++) {
                details.get(i)
                        .setText(details.get(i).getText() +
                                Objects.requireNonNullElse(resultSet.getString(i + 1), "Unknown"));
                empDetails.add(details.get(i));
                details.get(i)
                        .setBounds(10, i * 30, 200, 20);
            }
            empDetails.setLayout(null);
            empDetails.setBounds(100, 100, 300, 350);
            empDetails.setResizable(false);
            empDetails.setVisible(true);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
