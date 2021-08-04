package com.company.lists;

import com.company.Employee;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmployeeList extends JList<Employee> implements MouseListener {
    JList<Employee> employeeList;

    public EmployeeList(EmployeeListModel listModel){
        employeeList = new JList<>(listModel.getListModel());
        employeeList.addMouseListener(this);
    }

    public JList<Employee> getJList() {
        return this.employeeList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() % 2 == 0)
            System.out.println("double click");//TODO show window with employee details on double click
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
