package com.company.buttons;

import com.company.Employee;
import com.company.lists.EmployeeListModel;
import com.company.windows.EditEmployeePopup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class EditEmployeeButton extends JButton implements ActionListener {
    private final EmployeeListModel listModel;
    private final Statement statement;
    private final JList<Employee> employeeList;

    public EditEmployeeButton(JFrame frame, EmployeeListModel listModel, JList employeeList, Statement statement) {
        this.employeeList = employeeList;
        this.listModel = listModel;
        this.statement = statement;
        JButton button = new JButton("Edit employee");
        button.setBounds(25, 125, 200, 50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new EditEmployeePopup(listModel, statement, employeeList.getSelectedIndex());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
