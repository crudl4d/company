package com.project.company;

import com.project.company.buttons.AddEmployeeButton;
import com.project.company.buttons.DeleteEmployeeButton;
import com.project.company.buttons.EditEmployeeButton;
import com.project.company.buttons.SearchButton;
import com.project.company.lists.EmployeeList;
import com.project.company.lists.EmployeeListModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class CompanyApp {

    private final JFrame mainWindow;
    private final JList<Employee> employeeList;
    private final EmployeeListModel employeeListModel;
    private final Statement statement;

    public CompanyApp(ConnectionToDB connection, EmployeeListModel employeeListModel, EmployeeList employeeList) throws SQLException {
        this.employeeListModel = employeeListModel;
        this.employeeList = employeeList.getJList();
        this.statement = connection.getConnection().createStatement();
        mainWindow = new JFrame();
        addButtonsAndLists();
        configureMainWindow();
    }

    private void addButtonsAndLists() {
        JList<Employee> employeeJList = employeeList;
        new EditEmployeeButton(mainWindow, employeeJList, statement);
        new AddEmployeeButton(mainWindow, employeeListModel, statement);
        new DeleteEmployeeButton(mainWindow, employeeListModel, employeeJList, statement);
        new SearchButton(mainWindow, employeeListModel);
    }

    private void configureMainWindow(){
        JScrollPane pane = new JScrollPane();
        pane.setBounds(250,50,200,200);
        pane.setViewportView(employeeList);
        JMenuBar menuBar = new Menu().getJMenuBar();
        mainWindow.add(pane);
        mainWindow.setJMenuBar(menuBar);
        mainWindow.setTitle("Employee management");
        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}
