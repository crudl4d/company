package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeButton extends JButton implements ActionListener {
    JButton button = new JButton("Add employee");
    DefaultListModel<String> listModel;
    JList<String> bookList;
    public AddEmployeeButton(JFrame frame, DefaultListModel listModel){
        this.listModel = listModel;
        button.setBounds(50,50,100,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //placeholder
        //TODO add popup to create an employee
        var employee = new Employee("Adam", "Null", 3500);
        listModel.addElement(employee.getFirst_name() + " " + employee.getLast_name());
    }
}
