package com.company.lists;

import com.company.Employee;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListModel extends DefaultListModel<Employee> {
    private final DefaultListModel<Employee> listModel = new DefaultListModel<>();
    private final static List<Employee> employeeRepository =  new ArrayList<Employee>();

    public EmployeeListModel(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
        while(resultSet.next()){
            Employee emp = new Employee(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getDate(6), resultSet.getString(7), resultSet.getInt(8));
            listModel.addElement(emp);
            employeeRepository.add(emp);
        };
    }
    public DefaultListModel<Employee> getListModel(){return this.listModel;}

    public List<Employee> getEmployeeRepository() {
        return employeeRepository;
    }

}
