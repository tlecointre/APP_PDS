package edu.hubanato.server;

import edu.hubanato.models.PdsDatabase;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool<Connection> {
    
    private List<Connection> connections;
    
    /**
     * Defaut constructor
     * Adds connections
     */
    public ConnectionPool() {
        connections = new ArrayList<Connection>();
        while(!connectionPoolIsFull()) {
            try {
                connections.add((Connection) PdsDatabase.getConnection());
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Returns true if the pool is full and false if empty
     * 
     * @return boolean
     */
    private synchronized boolean connectionPoolIsFull() {
        int maxPoolSize = 10;
        return connections.size() >= maxPoolSize;
    }

    /**
     * Returns a connection
     * 
     * @return Connection 
     */
    public synchronized Connection getConnectionFromPool() {
        if(connections.size() > 0) {
            Connection connection = connections.get(0);
            connections.remove(0);
            return connection;
        }
        return null;
    }
    
    /**
     * Recoveries a connection
     * 
     * @param connection 
     */
    public synchronized void returnConnectionToPool(Connection connection) {
        connections.add(connection);
    }
}

