package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployeeButton extends JButton implements ActionListener {
    JButton button = new JButton("Delete selected employees");
    DefaultListModel<String> listModel;
    JList<String> bookList;
    public DeleteEmployeeButton(JFrame frame, DefaultListModel listModel, JList bookList){
        this.listModel = listModel;
        this.bookList = bookList;
        button.setBounds(150,50,200,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(bookList.getSelectedIndex() != -1) {
            for (int i = bookList.getSelectedIndices().length; i > 0; i--) {
                listModel.remove(bookList.getSelectedIndex());
            }
        }
    }
}