package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public final class ConnectionToDB {
    private static ConnectionToDB connectionToDB;
    private static Connection connection;
    private ConnectionToDB(String password) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@155.158.112.45:1521:oltpstud", "msbd7", password);
    }

    public static Connection getConnection(String password) throws SQLException, ClassNotFoundException {
        if (Objects.isNull(connectionToDB)){
            connectionToDB = new ConnectionToDB(password);
        }
        return connection;
    }
}
