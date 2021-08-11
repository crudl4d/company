package com.project.company.buttons;

import com.project.company.lists.EmployeeListModel;
import com.project.company.windows.AddEmployeePopup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class AddEmployeeButton extends JButton implements ActionListener {
    private final EmployeeListModel listModel;
    private final transient Statement statement;

    public AddEmployeeButton(JFrame frame, EmployeeListModel listModel, Statement statement){
        this.listModel = listModel;
        this.statement = statement;
        JButton button = new JButton("Add employee");
        button.setBounds(25,50,200,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AddEmployeePopup(statement, listModel);
    }
}
