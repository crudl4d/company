package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@155.158.112.45:1521:oltpstud", "msbd7", args[0]);
        Statement statement = connection.createStatement();

        JFrame mainWindow = new JFrame();

        EmployeeList employeeListModel = new EmployeeList(statement);
        JList<Employee> employeeList = new JList<Employee>(employeeListModel.getListModel());
        JScrollPane pane = new JScrollPane();
        pane.setBounds(100,100,200,200);
        pane.setViewportView(employeeList);
        mainWindow.add(pane);

        JButton addButton = new AddEmployeeButton(mainWindow, employeeListModel, statement);
        JButton deleteButton = new DeleteEmployeeButton(mainWindow, employeeListModel, employeeList, statement);
        JButton searchButton = new SearchButton(mainWindow, employeeListModel);

        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}
