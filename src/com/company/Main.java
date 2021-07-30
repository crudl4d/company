package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@155.158.112.45:1521:oltpstud", "msbd7", args[0]);

        //test statement
        Statement statement = connection.createStatement();

        JFrame mainWindow = new JFrame();

        DefaultListModel employeeListModel = new EmployeeList(statement).getListModel();
        JList employeeList = new JList(employeeListModel);
        employeeList.setBounds(100,100,200,200);

        JButton addButton = new AddEmployeeButton(mainWindow, employeeListModel, statement);
        JButton deleteButton = new DeleteEmployeeButton(mainWindow, employeeListModel, employeeList);
        JButton searchButton = new SearchButton(mainWindow, employeeListModel);

        mainWindow.add(employeeList);
        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}
