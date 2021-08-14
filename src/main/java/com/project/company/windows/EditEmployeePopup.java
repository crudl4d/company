package com.project.company.windows;

import com.project.company.Employee;
import com.project.company.lists.EmployeeList;
import com.project.company.lists.EmployeeListModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class EditEmployeePopup implements ActionListener {

    private final JFrame editEmployee = new JFrame("Edit employee");
    private final Statement statement;
    private final EmployeeListModel listModel;
    private final JList<Employee> employeeList;

    private final List<JLabel> labels;
    List<JTextField> textFields;
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");

    public EditEmployeePopup(Statement statement, JList<Employee> employeeList, EmployeeListModel listModel) {
        this.statement = statement;
        this.employeeList = employeeList;
        this.listModel = listModel;
        ok.setBounds(10,300,100,30);
        ok.addActionListener(this);
        editEmployee.add(ok);

        Employee emp = listModel.getEmployeeRepository().get(employeeList.getSelectedIndex());

        System.out.println(emp.getDeptId());
        textFields = Arrays.asList(
                new JTextField(Integer.toString(emp.getEmployeeId())),
                new JTextField(emp.getFirstName()),
                new JTextField(emp.getLastName()),
                new JTextField(emp.getEmail()),
                new JTextField(emp.getPhoneNumber()),
                new JTextField(emp.getHireDate().toString()),
                new JTextField(emp.getJobId()),
                new JTextField(Integer.toString(emp.getCommissionPct())),
                new JTextField(Integer.toString(emp.getManagerId())),
                new JTextField(Integer.toString(emp.getDeptId()))
        );

        labels = Arrays.asList(
                new JLabel("ID: "),
                new JLabel("First name: "),
                new JLabel("Last name: "),
                new JLabel("Email: "),
                new JLabel("Phone number: "),
                new JLabel("Hire date: "),
                new JLabel("Job ID: "),
                new JLabel("Commission pct: "),
                new JLabel("Manager ID: "),
                new JLabel("Department's ID: ")
        );

        setup(statement, employeeList.getSelectedIndex());
    }//TODO add ok/cancel, possibly merge edit/show popups

    private void setup(Statement statement, int index) {
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setBounds(10,i * 30,100,20);
            textFields.get(i).setBounds(110, i * 30, 150, 20);
            editEmployee.add(labels.get(i));
            editEmployee.add(textFields.get(i));
        }
        editEmployee.setLayout(null);
        editEmployee.setBounds(100,100,300,400);
        editEmployee.setVisible(true);
        var values = "";
        for(int i = 0; i < labels.size(); i++){
            values = values.concat(textFields.get(i).getText());
        }
        textFields.get(0).setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //textFields.forEach(x -> System.out.println(x.getText()));
//        System.out.println("UPDATE employees SET " +
//                "first_name = '" + textFields.get(1).getText() +
//                "', last_name = '" + textFields.get(2).getText() +
//                "'WHERE employee_id = " + textFields.get(0).getText());
//        try {
//            statement.executeQuery("UPDATE employees SET " +
//            "first_name = '" + textFields.get(1).getText() +
//            "', last_name = '" + textFields.get(2).getText() +
//            "'WHERE employee_id = " + textFields.get(0).getText());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
