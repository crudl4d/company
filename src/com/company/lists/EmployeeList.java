package com.company.lists;

import com.company.Employee;
import com.company.windows.EmployeeDetails;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Statement;

public class EmployeeList extends JList<Employee> implements MouseListener {
    private final JList<Employee> employeeList;
    private final EmployeeListModel listModel;
    private final Statement statement;

    public EmployeeList(EmployeeListModel listModel, Statement statement){
        this.listModel = listModel;
        this.statement = statement;
        employeeList = new JList<>(listModel.getListModel());
        employeeList.addMouseListener(this);
    }

    public JList<Employee> getJList() {
        return this.employeeList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() % 2 == 0) {
            EmployeeDetails employeeDetails = new EmployeeDetails(listModel, statement, employeeList.getSelectedIndex());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
