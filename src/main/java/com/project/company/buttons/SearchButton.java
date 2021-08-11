package com.project.company.buttons;

import com.project.company.lists.EmployeeListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton extends JButton implements ActionListener {
    private final JLabel output = new JLabel("Send a query");
    private final JTextField input = new JTextField("Search");
    private final EmployeeListModel listModel;
    public SearchButton(JFrame frame, EmployeeListModel listModel){
        this.listModel = listModel;
        JButton button = new JButton("Search for employee");
        button.setBounds(500,50,200,50);
        output.setBounds(500,150,200,50);
        input.setBounds(500,100,200,50);
        frame.add(input);
        frame.add(output);
        frame.add(button);
        input.setHorizontalAlignment(CENTER);
        output.setHorizontalAlignment(CENTER);
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
