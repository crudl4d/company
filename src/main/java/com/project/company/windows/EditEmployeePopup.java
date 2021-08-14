package com.project.company.windows;

import com.project.company.Employee;
import com.project.company.lists.EmployeeListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class EditEmployeePopup implements ActionListener {

    private final JFrame editEmployee = new JFrame("Edit employee");
    private final Statement statement;
    private final EmployeeListModel listModel;
    private final JList<Employee> employeeList;
    private final Employee empToEdit;

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

        empToEdit = listModel.getEmployeeRepository().get(employeeList.getSelectedIndex());

        textFields = Arrays.asList(
                new JTextField(Integer.toString(empToEdit.getEmployeeId())),
                new JTextField(empToEdit.getFirstName()),
                new JTextField(empToEdit.getLastName()),
                new JTextField(empToEdit.getEmail()),
                new JTextField(empToEdit.getPhoneNumber()),
                new JTextField(empToEdit.getHireDate().toString()),
                new JTextField(empToEdit.getJobId()),
                new JTextField(Integer.toString(empToEdit.getSalary())),
                new JTextField(Integer.toString(empToEdit.getCommissionPct())),
                new JTextField(Integer.toString(empToEdit.getManagerId())),
                new JTextField(Integer.toString(empToEdit.getDeptId()))
        );

        labels = Arrays.asList(
                new JLabel("ID: "),
                new JLabel("First name: "),
                new JLabel("Last name: "),
                new JLabel("Email: "),
                new JLabel("Phone number: "),
                new JLabel("Hire date: "),
                new JLabel("Job ID: "),
                new JLabel("Salary: "),
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
        textFields.get(0).setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Employee newEmployee = new Employee(Integer.parseInt(textFields.get(0).getText()), textFields.get(1).getText(),
                textFields.get(2).getText(), textFields.get(3).getText(), textFields.get(4).getText(),
                Date.valueOf(textFields.get(5).getText()), textFields.get(6).getText(),
                Integer.parseInt(textFields.get(7).getText()), Integer.parseInt(textFields.get(8).getText()),
                Integer.parseInt(textFields.get(9).getText()), Integer.parseInt(textFields.get(10).getText()));
        try {
            statement.executeQuery("UPDATE employees SET " +
            "first_name = '" + textFields.get(1).getText() +
            "', last_name = '" + textFields.get(2).getText() +
            "', email = '" + textFields.get(3).getText() +
            "', phone_number = '" + textFields.get(4).getText() +
            "', hire_date = '" + textFields.get(5).getText() +
            "', job_id = '" + textFields.get(6).getText() +
            "', salary = '" + textFields.get(7).getText() +
            "', commission_pct = '" + textFields.get(8).getText() +
            "', manager_id = '" + textFields.get(9).getText() +
            "', department_id = '" + textFields.get(10).getText() +
            "'WHERE employee_id = " + textFields.get(0).getText());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        listModel.getEmployeeRepository().set(employeeList.getSelectedIndex(), newEmployee);
        listModel.getListModel().set(employeeList.getSelectedIndex(), newEmployee);
        editEmployee.dispose();
    }
}
