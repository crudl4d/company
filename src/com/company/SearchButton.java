package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SearchButton extends JButton implements ActionListener {
    JButton button = new JButton("Search for employee");
    JLabel output = new JLabel("Send a query");
    JTextField input = new JTextField("Search");
    EmployeeList listModel;
    public SearchButton(JFrame frame, EmployeeList listModel){
        this.listModel = listModel;
        button.setBounds(500,50,200,50);
        output.setBounds(500,150,200,50);
        input.setBounds(500,100,200,50);
        frame.add(input);
        frame.add(output);
        frame.add(button);
        input.setHorizontalAlignment(JTextField.CENTER);
        output.setHorizontalAlignment(JTextField.CENTER);
        button.addActionListener(this);
        input.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<listModel.getListModel().size(); i++){
            if(listModel.getListModel().getElementAt(i).toString().toLowerCase().contains(input.getText().toLowerCase())){
                output.setText(listModel.getListModel().getElementAt(i).toString());
                break;
            }
            else
                output.setText("Employee not found");
        }
    }
}
