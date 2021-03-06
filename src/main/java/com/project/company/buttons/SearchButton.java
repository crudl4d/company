package com.project.company.buttons;

import com.project.company.lists.EmployeeListModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Component
public class SearchButton extends JButton implements ActionListener {
    private final JLabel output = new JLabel("Send a query");
    private final JTextField input = new JTextField("Search");
    private final EmployeeListModel listModel;
    private final JButton searchButton;

    public SearchButton(EmployeeListModel listModel){
        this.listModel = listModel;
        searchButton = new JButton("Search for employee");
        searchButton.setBounds(500,50,200,50);
        output.setBounds(500,150,200,50);
        input.setBounds(500,100,200,50);
        input.setHorizontalAlignment(CENTER);
        output.setHorizontalAlignment(CENTER);
        searchButton.addActionListener(this);
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
