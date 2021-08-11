package com.project.company.buttons;

import com.project.company.Employee;
import com.project.company.lists.EmployeeListModel;
import com.project.company.windows.EditEmployeePopup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class EditEmployeeButton extends JButton implements ActionListener {
    private final transient Statement statement;
    private final JList<Employee> employeeList;

    public EditEmployeeButton(JFrame frame, JList<Employee> employeeList, Statement statement) {
        this.employeeList = employeeList;
        this.statement = statement;
        JButton button = new JButton("Edit employee");
        button.setBounds(25, 125, 200, 50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            new EditEmployeePopup(statement, employeeList.getSelectedIndex());
    }
}
