package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeeButton extends JButton implements ActionListener {
    JButton button = new JButton("Delete selected employees");
    EmployeeList listModel;
    JList<Employee> bookList;
    Statement statement;
    public DeleteEmployeeButton(JFrame frame, EmployeeList listModel, JList<Employee> bookList, Statement statement){
        this.listModel = listModel;
        this.bookList = bookList;
        this.statement = statement;
        button.setBounds(150,50,200,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(bookList.getSelectedIndex() != -1) {
            for (int i = bookList.getSelectedIndices().length; i > 0; i--) {
                try {
                    statement.executeQuery("DELETE FROM employees WHERE employee_id=" +
                            listModel.getEmployeeRepository().get(bookList.getSelectedIndex()).getEmployee_id());
                    listModel.getListModel().remove(bookList.getSelectedIndex());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}