package com.company;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeList extends DefaultListModel implements ListDataListener {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    Statement statement;
    public EmployeeList(Statement statement) throws SQLException {
        this.statement = statement;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
        while(resultSet.next()){
            listModel.addElement(resultSet.getString(2) + " " + resultSet.getString(3));
        }
        listModel.addListDataListener(this);
    }
    public DefaultListModel getListModel(){return this.listModel;}

    @Override
    public void intervalAdded(ListDataEvent e) {

    }

    @Override
    public void intervalRemoved(ListDataEvent e) {

    }

    @Override
    public void contentsChanged(ListDataEvent e) {

    }
}
