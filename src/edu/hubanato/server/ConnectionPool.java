package edu.hubanato.server;

import edu.hubanato.models.PdsDatabase;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool<Connection> {
    
    private List<Connection> connections;
    
    public ConnectionPool() throws SQLException {
        connections = new ArrayList<Connection>();
        while(!connectionPoolIsFull()) {
            connections.add((Connection) PdsDatabase.getConnection());
        }
    }
    
     private synchronized boolean connectionPoolIsFull() {
        final int maxPoolSize = 10;
        return connections.size() >= maxPoolSize;
    }


    public synchronized Connection getConnectionFromPool() {
        if(connections.size() > 0) {
            Connection connection = connections.get(0);
            connections.remove(0);
            return connection;
        }
        return null;
    }

    public synchronized void returnConnectionToPool(Connection connection) {
        connections.add(connection);
    }
}

