package com.project.company.buttons;

import com.project.company.ConnectionToDB;
import com.project.company.lists.EmployeeListModel;
import com.project.company.windows.AddEmployeePopup;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
@Component
public class AddEmployeeButton extends JButton implements ActionListener {
    private final EmployeeListModel listModel;
    private final transient Statement statement;
    private final JButton addButton;
    private final AddEmployeePopup addEmployeePopup;

    public AddEmployeeButton(EmployeeListModel listModel, ConnectionToDB connection, AddEmployeePopup addEmployeePopup) throws SQLException {
        this.listModel = listModel;
        this.addEmployeePopup = addEmployeePopup;
        statement = connection.getConnection().createStatement();
        addButton = new JButton("Add employee");
        addButton.setBounds(25,50,200,50);
        addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addEmployeePopup.getAddEmployee().setVisible(true);
    }
}
