package com.project.company.buttons;

import com.project.company.ConnectionToDB;
import com.project.company.Employee;
import com.project.company.lists.EmployeeList;
import com.project.company.lists.EmployeeListModel;
import com.project.company.windows.EditEmployeePopup;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
@Component
public class EditEmployeeButton extends JButton implements ActionListener {
    private final transient Statement statement;
    private final JButton editButton;
    private final JList<Employee> employeeList;
    private final EmployeeListModel listModel;

    public EditEmployeeButton(EmployeeList employeeList, ConnectionToDB connection, EmployeeListModel listModel) throws SQLException {
        this.employeeList = employeeList.getJList();
        this.listModel = listModel;
        statement = connection.getConnection().createStatement();
        editButton = new JButton("Edit employee");
        editButton.setBounds(25, 125, 200, 50);
        editButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            new EditEmployeePopup(statement, employeeList, listModel);
    }
}
