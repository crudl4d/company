package com.company;

import com.company.buttons.AddEmployeeButton;
import com.company.buttons.DeleteEmployeeButton;
import com.company.buttons.SearchButton;
import com.company.lists.EmployeeList;
import com.company.lists.EmployeeListModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@155.158.112.45:1521:oltpstud", "msbd7", args[0]);
        Statement statement = connection.createStatement();

        JFrame mainWindow = new JFrame();

        EmployeeListModel employeeListModel = new EmployeeListModel(statement);
        JList<Employee> employeeList = new EmployeeList(employeeListModel).getJList();
        JScrollPane pane = new JScrollPane();
        pane.setBounds(250,25,200,200);
        pane.setViewportView(employeeList);
        mainWindow.add(pane);

        JButton addButton = new AddEmployeeButton(mainWindow, employeeListModel, statement);
        JButton deleteButton = new DeleteEmployeeButton(mainWindow, employeeListModel, employeeList, statement);
        JButton searchButton = new SearchButton(mainWindow, employeeListModel);

        JMenuBar menuBar = new Menu().getJMenuBar();
        mainWindow.setJMenuBar(menuBar);

        mainWindow.setTitle("Employee management");
        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}
