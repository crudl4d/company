package com.project.company;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Component
public class ConnectionToDB {
    private final Connection connection;
    public ConnectionToDB() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@155.158.112.45:1521:oltpstud", "msbd7", "utopia7523");
    }
}
