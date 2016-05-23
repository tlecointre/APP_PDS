package edu.hubanato.server;

import java.sql.Connection;
import java.sql.SQLException;

public class InterfacePoolServer {

    static ConnectionPool pool = new ConnectionPool();

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection connection = (Connection) pool.getConnectionFromPool();
        return connection;
    }

    public static void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}