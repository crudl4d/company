package com.project.company.windows;

import com.project.company.ConnectionToDB;
import com.project.company.Employee;
import com.project.company.JobTitles;
import com.project.company.lists.EmployeeListModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
@Component
public class AddEmployeePopup extends JFrame implements ActionListener {
    private final EmployeeListModel listModel;
    private final JFrame addEmployee = new JFrame("Add employee");
    private final JLabel titleText = new JLabel("Provide employee details:");
    private final JTextField firstName = new JTextField("first name");
    private final JTextField lastName = new JTextField("last name");
    private final JTextField email = new JTextField("email");
    private final JTextField hireDate = new JTextField(new Date(System.currentTimeMillis()).toString());
    private final JComboBox<String> jobTitles = new JComboBox<>();
    private final transient Statement statement;

    public AddEmployeePopup(ConnectionToDB connection, EmployeeListModel listModel) throws SQLException {
        statement = connection.getConnection().createStatement();
        this.listModel = listModel;
        setup();
    }

    private void setup(){
        addEmployee.add(firstName);
        addEmployee.add(lastName);
        addEmployee.add(email);
        addEmployee.add(hireDate);
        addEmployee.add(titleText);
        addEmployee.add(jobTitles);
        addEmployee.setLayout(null);
        addEmployee.setBounds(100, 100, 300, 300);

        firstName.setBounds(50, 50, 150, 25);
        lastName.setBounds(50, 75, 150, 25);
        email.setBounds(50, 100, 150, 25);
        hireDate.setBounds(50, 125, 150, 25);
        titleText.setBounds(40,25,175,25);
        jobTitles.setBounds(50, 150, 150, 25);

        JButton ok = new JButton("OK");
        addEmployee.add(ok);
        ok.setBounds(50,175,100,50);
        ok.addActionListener(this);

        for(JobTitles jt: JobTitles.values()){
            jobTitles.addItem(jt.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addEmployee.dispatchEvent(new WindowEvent(addEmployee, WindowEvent.WINDOW_CLOSING));
        try {
            ResultSet resultSet = statement.executeQuery("SELECT employees_seq.nextval FROM dual");
            resultSet.next();
            var id = resultSet.getInt(1);

            statement.executeQuery("INSERT INTO EMPLOYEES(employee_id, first_name, last_name, email, hire_date, job_id) " +
                    "VALUES(" + id + ", '" + firstName.getText() + "', '"+ lastName.getText() +"', '" +
                    email.getText() + "', '" + hireDate.getText() + "', '" + jobTitles.getSelectedItem() + "')");

            Employee newEmployee = new Employee(id, firstName.getText(), lastName.getText(), email.getText(),
                    Date.valueOf(hireDate.getText()), jobTitles.getSelectedItem().toString(), 1000);

            listModel.getEmployeeRepository().add(newEmployee);
            listModel.getListModel().addElement(listModel.getEmployeeRepository().get(listModel.getEmployeeRepository().size() - 1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
