package com.project.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class Config {
    @Bean
    public Statement getStatement() throws SQLException, ClassNotFoundException {
        return new ConnectionToDB().getConnection().createStatement();
    }
}
