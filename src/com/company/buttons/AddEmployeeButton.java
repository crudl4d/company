package com.company.buttons;

import com.company.windows.AddEmployeePopup;
import com.company.lists.EmployeeListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class AddEmployeeButton extends JButton implements ActionListener {
    JButton button = new JButton("Add employee");
    EmployeeListModel listModel;
    Statement statement;
    JFrame frame;
    public AddEmployeeButton(JFrame frame, EmployeeListModel listModel, Statement statement){
        this.frame = frame;
        this.listModel = listModel;
        this.statement = statement;
        button.setBounds(25,50,200,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddEmployeePopup add = new AddEmployeePopup(statement, listModel);
    }
}
