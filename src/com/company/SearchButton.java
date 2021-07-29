package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SearchButton extends JButton implements ActionListener {
    JButton button = new JButton("Search for employee");
    JLabel output = new JLabel("Send a query");
    JTextField input = new JTextField("Search");
    DefaultListModel<String> listModel;
    public SearchButton(JFrame frame, DefaultListModel listModel){
        this.listModel = listModel;
        button.setBounds(400,400,150,50);
        output.setBounds(400,500,200,50);
        input.setBounds(400,450,50,50);
        frame.add(input);
        frame.add(output);
        frame.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<listModel.size(); i++){
            if(listModel.getElementAt(i).toLowerCase().contains(input.getText().toLowerCase())){
                output.setText(listModel.getElementAt(i));
                break;
            }
            else
                output.setText("Employee not found");
        }
    }
}
