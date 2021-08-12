package com.project.company.lists;

import com.project.company.ConnectionToDB;
import com.project.company.Employee;
import com.project.company.windows.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ContextResource;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class EmployeeList extends JList<Employee> implements MouseListener {
    private final JList<Employee> employeeList;
    private final transient Statement statement;
    private EmployeeDetails employeeDetails;

    public EmployeeList(EmployeeListModel listModel, ConnectionToDB connection) throws SQLException {
        statement = connection.getConnection().createStatement();
        employeeList = new JList<>(listModel.getListModel());
        employeeList.addMouseListener(this);
    }

    public JList<Employee> getJList() {
        return this.employeeList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() % 2 == 0) {
            System.out.println(employeeDetails.getListModel().get(2));
            employeeDetails.getEmpDetails().setVisible(true);
        }
    }

    @Autowired
    public void setEmpDet(EmployeeDetails employeeDetails){
        this.employeeDetails = employeeDetails;
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
