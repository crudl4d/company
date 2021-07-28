package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButton extends JButton implements ActionListener {
    JButton button = new JButton("Delete book");
    DefaultListModel<String> listModel;
    JList<String> bookList;
    public DeleteButton(JFrame frame, DefaultListModel listModel, JList bookList){
        this.listModel = listModel;
        this.bookList = bookList;
        button.setBounds(150,50,200,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var index = bookList.getSelectedIndices();
        if(bookList.getSelectedIndex() != -1) {
            for (int i = 0; i < index.length; i++) {
                listModel.remove(index[i] - 1);
            }
        }
    }
}