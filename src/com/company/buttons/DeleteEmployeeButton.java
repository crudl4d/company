package com.company.buttons;

import com.company.Employee;
import com.company.lists.EmployeeListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeeButton extends JButton implements ActionListener {
    private final EmployeeListModel listModel;
    private final JList<Employee> bookList;
    private final Statement statement;
    public DeleteEmployeeButton(JFrame frame, EmployeeListModel listModel, JList<Employee> bookList, Statement statement){
        this.listModel = listModel;
        this.bookList = bookList;
        this.statement = statement;
        JButton button = new JButton("Delete selected employees");
        button.setBounds(25,125,200,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(bookList.getSelectedIndex() != -1) {
            for (int i = bookList.getSelectedIndices().length; i > 0; i--) {
                try {
                    System.out.println(listModel.getEmployeeRepository().get(bookList.getSelectedIndex()).getEmployee_id());
                    statement.executeQuery("DELETE FROM employees WHERE employee_id=" +
                            listModel.getEmployeeRepository().get(bookList.getSelectedIndex()).getEmployee_id());
                    listModel.getEmployeeRepository().remove(bookList.getSelectedIndex());
                    listModel.getListModel().remove(bookList.getSelectedIndex());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}