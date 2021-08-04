package com.company;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList extends DefaultListModel<Employee> implements ListDataListener {
    private DefaultListModel<Employee> listModel = new DefaultListModel<>();
    private Statement statement;
    private static List<Employee> employeeRepository =  new ArrayList<Employee>();

    public EmployeeList(Statement statement) throws SQLException {
        this.statement = statement;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
        while(resultSet.next()){
            Employee emp = new Employee(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getDate(6), resultSet.getString(7), resultSet.getInt(8));
            listModel.addElement(emp);
            employeeRepository.add(emp);
        }
        listModel.addListDataListener(this);
    }
    public DefaultListModel<Employee> getListModel(){return this.listModel;}

    public List<Employee> getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public void intervalAdded(ListDataEvent e) {

    }

    @Override
    public void intervalRemoved(ListDataEvent e) {

    }

    @Override
    public void contentsChanged(ListDataEvent e) {

    }
}
