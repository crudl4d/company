package com.company.windows;

import com.company.Employee;
import com.company.JobTitles;
import com.company.lists.EmployeeListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployeePopup extends JFrame implements ActionListener {
    private final
    EmployeeListModel listModel;
    JFrame addEmployee = new JFrame("Add employee");
    JLabel title = new JLabel("Provide employee information");
    JTextField firstName = new JTextField("first name");
    JTextField lastName = new JTextField("last name");
    JTextField email = new JTextField("email");
    JTextField hire_date = new JTextField(new Date(System.currentTimeMillis()).toString());
    JComboBox<String> job_titles = new JComboBox<>();
    Statement statement;

    public AddEmployeePopup(Statement statement, EmployeeListModel listModel) {
        this.statement = statement;
        this.listModel = listModel;
        setup();
    }

    private void setup(){
        addEmployee.add(firstName);
        addEmployee.add(lastName);
        addEmployee.add(email);
        addEmployee.add(hire_date);
        addEmployee.add(title);
        addEmployee.add(job_titles);
        addEmployee.setLayout(null);
        addEmployee.setBounds(100, 100, 300, 300);
        addEmployee.setVisible(true);

        firstName.setBounds(50, 50, 150, 25);
        lastName.setBounds(50, 75, 150, 25);
        email.setBounds(50, 100, 150, 25);
        hire_date.setBounds(50, 125, 150, 25);
        title.setBounds(40,25,175,25);
        job_titles.setBounds(50, 150, 150, 25);

        JButton ok = new JButton("OK");
        addEmployee.add(ok);
        ok.setBounds(50,175,100,50);
        ok.addActionListener(this);

        for(JobTitles jt: JobTitles.values()){
            job_titles.addItem(jt.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addEmployee.dispatchEvent(new WindowEvent(addEmployee, WindowEvent.WINDOW_CLOSING));
        try {
            ResultSet resultSet = statement.executeQuery("SELECT employees_seq.nextval FROM dual");
            resultSet.next();
            int id = resultSet.getInt(1);

            statement.executeQuery("INSERT INTO EMPLOYEES(employee_id, first_name, last_name, email, hire_date, job_id) " +
                    "VALUES(" + id + ", '" + firstName.getText() + "', '"+ lastName.getText() +"', '" +
                    email.getText() + "', '" + hire_date.getText() + "', '" + job_titles.getSelectedItem() + "')");

            Employee newEmployee = new Employee(id, firstName.getText(), lastName.getText(), email.getText(),
                    Date.valueOf(hire_date.getText()), job_titles.getSelectedItem().toString(), 1000);

            listModel.getListModel().addElement(listModel.getEmployeeRepository().get(listModel.getEmployeeRepository().size() - 1));
            listModel.getEmployeeRepository().add(newEmployee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
