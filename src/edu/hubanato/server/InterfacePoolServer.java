package edu.hubanato.server;

import java.sql.Connection;
import java.sql.SQLException;

public class InterfacePoolServer {

    static ConnectionPool pool = new ConnectionPool();
    
    /**
     * get a connection
     * 
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection connection = (Connection) pool.getConnectionFromPool();
        return connection;
    }
    
    /**
     * Recoveries a connection
     * 
     * @param connection 
     */
    public static void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}