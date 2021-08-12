package com.project.company;

import com.project.company.buttons.AddEmployeeButton;
import com.project.company.buttons.DeleteEmployeeButton;
import com.project.company.buttons.EditEmployeeButton;
import com.project.company.buttons.SearchButton;
import com.project.company.lists.EmployeeList;
import com.project.company.lists.EmployeeListModel;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@ComponentScan("com.project.company.buttons")
@Configuration
public class CompanyApp {

    private final JFrame mainWindow;
    private final JList<Employee> employeeList;
    private final EditEmployeeButton editEmployeeButton;
    private final AddEmployeeButton addEmployeeButton;
    private final SearchButton searchButton;
    private final DeleteEmployeeButton deleteEmployeeButton;

    public CompanyApp(ConnectionToDB connection, EmployeeListModel employeeListModel,
                      EmployeeList employeeList, EditEmployeeButton editEmployeeButton, AddEmployeeButton addEmployeeButton,
                      SearchButton searchButton, DeleteEmployeeButton deleteEmployeeButton) throws SQLException {
        this.employeeList = employeeList.getJList();
        this.editEmployeeButton = editEmployeeButton;
        this.addEmployeeButton = addEmployeeButton;
        this.searchButton = searchButton;
        this.deleteEmployeeButton = deleteEmployeeButton;
        mainWindow = new JFrame();
        addButtonsAndLists();
        configureMainWindow();
    }

    private void addButtonsAndLists() {
        mainWindow.add(addEmployeeButton.getAddButton());
        mainWindow.add(editEmployeeButton.getEditButton());
        mainWindow.add(deleteEmployeeButton.getDeleteButton());
        mainWindow.add(searchButton.getSearchButton());
        mainWindow.add(searchButton.getInput());
        mainWindow.add(searchButton.getOutput());
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
