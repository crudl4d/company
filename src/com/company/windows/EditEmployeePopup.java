package com.company.windows;

import javax.swing.*;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class EditEmployeePopup {
    JFrame editEmployee = new JFrame("Edit employee");
    List<JLabel> labels = Arrays.asList(
            new JLabel("ID: "),
            new JLabel("First name: "),
            new JLabel("Last name: "),
            new JLabel("Email: "),
            new JLabel("Phone number: "),
            new JLabel("Hire date: "),
            new JLabel("Job ID: "),
            new JLabel("Commission pct: "),
            new JLabel("Manager ID: "),
            new JLabel("Department's ID: ")
    );
    List<JTextField> textFields = Arrays.asList(
            new JTextField("ID: "),
            new JTextField("First name: "),
            new JTextField("Last name: "),
            new JTextField("Email: "),
            new JTextField("Phone number: "),
            new JTextField("Hire date: "),
            new JTextField("Job ID: "),
            new JTextField("Commission pct: "),
            new JTextField("Manager ID: "),
            new JTextField("Department's ID: ")
    );
    public EditEmployeePopup(DefaultListModel listModel, Statement statement, int index){
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setBounds(10,i * 30,100,20);
            textFields.get(i).setBounds(110, i * 30, 150, 20);
            editEmployee.add(labels.get(i));
            editEmployee.add(textFields.get(i));
        }
        editEmployee.setLayout(null);
        editEmployee.setBounds(100,100,300,350);
        editEmployee.setVisible(true);
    }
}
