package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();

        DefaultListModel bookListModel = new BookList();
        JList bookList = new JList(bookListModel);
        bookList.setBounds(100,100,200,200);

        JButton addButton = new AddButton(mainWindow, bookListModel);
        JButton deleteButton = new DeleteButton(mainWindow, bookListModel, bookList);
        JButton searchButton = new SearchButton(mainWindow, bookListModel);

        mainWindow.add(bookList);
        mainWindow.setLayout(null);
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}
