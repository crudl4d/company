package com.project.company;

import javax.swing.*;

public class Menu extends JMenuBar{
    JMenuBar menuBar = new JMenuBar();
    public Menu() {
        JMenu menu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem undo = new JMenuItem("Undo changes");
        JMenuItem exit = new JMenuItem("Exit");//TODO make classes for each menuItem
        menu.add(save);
        menu.add(undo);
        menu.add(exit);
        menuBar.add(menu);
    }
    public JMenuBar getJMenuBar(){
        return this.menuBar;
    }
}
