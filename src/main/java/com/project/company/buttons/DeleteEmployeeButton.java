package com.project.company.buttons;

import com.project.company.ConnectionToDB;
import com.project.company.Employee;
import com.project.company.lists.EmployeeList;
import com.project.company.lists.EmployeeListModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
@Component
public class DeleteEmployeeButton extends JButton implements ActionListener {
    private final EmployeeListModel listModel;
    private  final JList<Employee> list;
    private final transient Statement statement;
    private final JButton deleteButton;

    public DeleteEmployeeButton(EmployeeListModel listModel, EmployeeList employeeList, ConnectionToDB connection) throws SQLException {
        this.listModel = listModel;
        list = employeeList.getJList();
        statement = connection.getConnection().createStatement();
        deleteButton = new JButton("Delete selected employees");
        deleteButton.setBounds(25,200,200,50);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(list.getSelectedIndex() != -1) {
            for (int i = list.getSelectedIndices().length; i > 0; i--) {
                try {
                    statement.executeQuery("DELETE FROM employees WHERE employee_id=" +
                            listModel.getEmployeeRepository().get(list.getSelectedIndex()).getEmployee_id());
                    listModel.getEmployeeRepository().remove(list.getSelectedIndex());
                    listModel.getListModel().remove(list.getSelectedIndex());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}