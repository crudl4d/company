package com.company;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class EmployeeList extends DefaultListModel implements ListDataListener {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    public EmployeeList(){
        listModel.addListDataListener(this);
    }

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
