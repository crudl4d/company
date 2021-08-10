package com.project.company;

import com.project.company.buttons.AddEmployeeButton;
import com.project.company.buttons.DeleteEmployeeButton;
import com.project.company.buttons.EditEmployeeButton;
import com.project.company.buttons.SearchButton;
import com.project.company.lists.EmployeeList;
import com.project.company.lists.EmployeeListModel;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Main {

    private final static JFrame mainWindow = new JFrame();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionToDB.getConnection(args[0]);
        Statement statement = connection.createStatement();

        configureMainWindow(
                        addPane(
                            addButtonsAndLists(statement)));
    }

    private static JList<Employee> addButtonsAndLists(Statement statement) throws SQLException {
        EmployeeListModel employeeListModel = new EmployeeListModel(statement);
        JList<Employee> employeeList = new EmployeeList(employeeListModel, statement).getJList();
        new EditEmployeeButton(mainWindow, employeeListModel, employeeList, statement);
        new AddEmployeeButton(mainWindow, employeeListModel, statement);
        new DeleteEmployeeButton(mainWindow, employeeListModel, employeeList, statement);
        new SearchButton(mainWindow, employeeListModel);
        return employeeList;
    }

    private static JScrollPane addPane(JList<Employee> employeeList){
        JScrollPane pane = new JScrollPane();
        pane.setBounds(250,50,200,200);
        pane.setViewportView(employeeList);
        return pane;
    }

    private static void configureMainWindow(JScrollPane pane){
        JMenuBar menuBar = new Menu().getJMenuBar();
        mainWindow.add(pane);
        mainWindow.setJMenuBar(menuBar);
        mainWindow.setTitle("Employee management");
        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);

    }
}
