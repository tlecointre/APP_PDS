package edu.hubanato.entities;

import edu.hubanato.models.PdsDatabase;
import edu.hubanato.server.ConnectionPool;
import edu.hubanato.server.InterfacePoolServer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tom
 */
public class Simulation {
    
    private int idSimulation, idClient, amount, duration;
    private double rate, rateInsurance;
    private String loanType;
    
    public Simulation(int idSimulation, int idClient, int amount, int duration, double rate, double rateInsurance, String loanType) {
        this.idSimulation = idSimulation;
        this.idClient = idClient;
        this.amount = amount;
        this.duration = duration;
        this.rate = rate;
        this.rateInsurance = rateInsurance;
        this.loanType = loanType;
    }

    public int getIdSimulation() {
        return idSimulation;
    }
    
    public void createSimulation() throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();
        
        int idLoanType;
        String sql = "SELECT ID_TYPES AS idLoanType FROM TYPES WHERE TITLE = ?";
        PreparedStatement o = connection.prepareStatement(sql);
        o.setString(1, loanType);
        ResultSet rs = o.executeQuery();
        rs.next();
        idLoanType = rs.getInt("idLoanType");

        String querySimulation = "INSERT INTO SIMULATION(ID_CUSTOMER,AMOUNT,DURATION,ID_TYPES,RATE_FINAL,RATE_INSURANCE) "
                                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ordre = connection.prepareStatement(querySimulation);

        ordre.setInt(1, idClient);
        ordre.setInt(2, amount);
        ordre.setInt(3, duration);
        ordre.setInt(4, idLoanType);
        ordre.setDouble(5, rate);
        ordre.setDouble(6, rateInsurance);
        
        ordre.executeUpdate();
        ordre.close();

        InterfacePoolServer.returnConnection(connection);
    }
    
    public static List<Simulation> getByClient(int idClient) throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();
        
        String sql = "SELECT * FROM SIMULATION s, TYPES t WHERE ID_CUSTOMER = ? AND s.ID_TYPES = t.ID_TYPES";
        PreparedStatement ordre = connection.prepareStatement(sql);
        ordre.setInt(1, idClient);
        ResultSet rs = ordre.executeQuery();
        List<Simulation> simulations = new ArrayList<Simulation>();
        while (rs.next()) {
            simulations.add(new Simulation(rs.getInt("ID_SIMULATION"), rs.getInt("ID_CUSTOMER"), rs.getInt("AMOUNT"), rs.getInt("DURATION"),
                    rs.getDouble("RATE_FINAL"), rs.getDouble("RATE_INSURANCE"), rs.getString("TITLE")));
        }
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
        return simulations;
        
    }
    
    /**
     * Update a simulation in database
     */
    public void updateSimulation() throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();

        int idLoanType;
        String sql = "SELECT ID_TYPES AS idLoanType FROM TYPES WHERE TITLE = ?";
        PreparedStatement o = connection.prepareStatement(sql);
        o.setString(1, loanType);
        ResultSet rs = o.executeQuery();
        rs.next();
        idLoanType = rs.getInt("idLoanType");

        String queryUSimulation = "UPDATE SIMULATION SET AMOUNT = ? , DURATION = ?, ID_TYPES = ?, RATE_FINAL = ?, "
                    + "RATE_INSURANCE = ? WHERE ID_SIMULATION = ?";
        PreparedStatement ordre = connection.prepareStatement(queryUSimulation);
        ordre.setInt(1, amount);
        ordre.setInt(2, duration);
        ordre.setInt(3, idLoanType);
        ordre.setDouble(4, rate);
        ordre.setDouble(5, rateInsurance);
        ordre.setInt(6, idSimulation);
        ordre.executeUpdate();
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
    }
    
    public int getAmount() {
        return amount;
    }

    public int getDuration() {
        return duration;
    }

    public double getRate() {
        return rate;
    }
    
    public double getRateInsurance() {
        return rateInsurance;
    }
    
    public String getLoanType() {
        return loanType;
    }
    
    
}
