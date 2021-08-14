package com.project.company.windows;

import com.project.company.Employee;
import com.project.company.lists.EmployeeListModel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EmployeeDetails extends JFrame {
    private final JList<Employee> employeeList;
    private final EmployeeListModel listModel;
    private final transient Statement statement;
    private final JFrame empDetails = new JFrame("Employee details");

    private final List<JLabel> details = Arrays.asList(
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

    public EmployeeDetails(JList<Employee> employeeList, EmployeeListModel listModel, Statement statement) throws SQLException {
        this.employeeList = employeeList;
        this.listModel = listModel;
        this.statement = statement;
        empDetails.setBounds(100,100,400,600);
        empDetails.setVisible(true);
        setup();

    }

    private void setup(){
        for(int i = 0; i < details.size(); i++){
            details.get(i).setBounds(10,i * 30,100,20);
            empDetails.add(details.get(i));
        }
        if(employeeList.getSelectedIndex()==-1)
            return;
        var empId = listModel.getEmployeeRepository().get(employeeList.getSelectedIndex()).getEmployeeId();
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
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
