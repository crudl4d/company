package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployeePopup extends JFrame implements ActionListener {
    JFrame addEmployee = new JFrame("Add employee");
    JLabel title = new JLabel("Provide employee information");
    JTextField firstName = new JTextField("first name");
    JTextField lastName = new JTextField("last name");
    JTextField email = new JTextField("email");
    JTextField hire_date = new JTextField("hire_date");
    Statement statement;
    public AddEmployeePopup(Statement statement) {
        this.statement = statement;

        addEmployee.add(firstName);
        addEmployee.add(lastName);
        addEmployee.add(email);
        addEmployee.add(hire_date);
        addEmployee.add(title);
        addEmployee.setLayout(null);
        addEmployee.setBounds(100, 100, 300, 300);
        addEmployee.setVisible(true);

        JButton ok = new JButton("OK");
        addEmployee.add(ok);
        ok.setBounds(50,150,100,50);
        ok.addActionListener(this);

        firstName.setBounds(50, 50, 150, 25);
        lastName.setBounds(50, 75, 150, 25);
        email.setBounds(50, 100, 150, 25);
        hire_date.setBounds(50, 125, 150, 25);
        title.setBounds(40,25,175,25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addEmployee.dispatchEvent(new WindowEvent(addEmployee, WindowEvent.WINDOW_CLOSING));
        try {
            statement.executeQuery("INSERT INTO EMPLOYEES(employee_id, first_name, last_name, email, hire_date, job_id) " +
                    "VALUES(9999, '" + firstName.getText() + "', '"+ lastName.getText() +"', '" +
                    email.getText() + "', '" + hire_date.getText() + "', 'SALESMAN')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
