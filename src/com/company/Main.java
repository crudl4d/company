package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");
        Scanner sc = new Scanner(System.in); //placeholder, i dont want to hardcode password to DB
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@155.158.112.45:1521:oltpstud", "msbd7", sc.next());

        //test statement
        Statement statement = connection.createStatement();
        ResultSet cust = statement.executeQuery("select * from employees");

        JFrame mainWindow = new JFrame();

        DefaultListModel employeeListModel = new EmployeeList();
        JList employeeList = new JList(employeeListModel);
        employeeList.setBounds(100,100,200,200);

        JButton addButton = new AddEmployeeButton(mainWindow, employeeListModel, statement);
        JButton deleteButton = new DeleteEmployeeButton(mainWindow, employeeListModel, employeeList);
        JButton searchButton = new SearchButton(mainWindow, employeeListModel);

        //test, prints IDs
        while(cust.next()) {
            System.out.println(cust.getString(1));
        }

        mainWindow.add(employeeList);
        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}
