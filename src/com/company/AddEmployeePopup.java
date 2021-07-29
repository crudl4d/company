package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployeePopup extends JFrame implements ActionListener {
    JFrame addEmployee = new JFrame();
    JTextField firstName = new JTextField("first name");
    Statement statement;
    public AddEmployeePopup(Statement statement) {
        this.statement = statement;

        addEmployee.add(firstName);
        addEmployee.setLayout(null);
        addEmployee.setBounds(100, 100, 300, 250);
        addEmployee.setVisible(true);

        JButton ok = new JButton("OK");
        addEmployee.add(ok);
        ok.setBounds(50,100,100,50);
        ok.addActionListener(this);

        firstName.setBounds(50, 50, 150, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addEmployee.dispatchEvent(new WindowEvent(addEmployee, WindowEvent.WINDOW_CLOSING));
        try {
            statement.executeQuery("INSERT INTO EMPLOYEES(employee_id, first_name, last_name, email, hire_date, job_id) " +
                    "VALUES(9999, '" + firstName.getText() + "', 'last_name', 'myEmail', '31-may-98', 3)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
