package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton extends JButton implements ActionListener {
    JButton button = new JButton("Add book");
    DefaultListModel<String> listModel;
    JList<String> bookList;
    public AddButton(JFrame frame, DefaultListModel listModel){
        this.listModel = listModel;
        button.setBounds(50,50,100,50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var book = new Book("name", "author");
        listModel.addElement(book.getName() + ", author: " + book.getAuthor());
    }
}
