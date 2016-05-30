package edu.hubanato.entities;

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
    
    /**
     * Default constructor
     * 
     * @param idSimulation
     * @param idClient
     * @param amount
     * @param duration
     * @param rate
     * @param rateInsurance
     * @param loanType 
     */
    public Simulation(int idSimulation, int idClient, int amount, int duration, double rate, double rateInsurance, String loanType) {
        this.idSimulation = idSimulation;
        this.idClient = idClient;
        this.amount = amount;
        this.duration = duration;
        this.rate = rate;
        this.rateInsurance = rateInsurance;
        this.loanType = loanType;
    }
    
    /**
     * 
     * @return int idSimulation 
     */
    public int getIdSimulation() {
        return idSimulation;
    }
    
    /**
     * Creates this simulation in database
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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
    
    /**
     * Returns a list of simulations by researching an id in database
     * Returns an empty list if no simulation has been found
     * 
     * @param idClient
     * @return 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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
     * Updates this simulation in database
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
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
    
    /**
     * 
     * @return int amount 
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * 
     * @return int duration
     */
    public int getDuration() {
        return duration;
    }
    
    /**
     * 
     * @return double rate
     */
    public double getRate() {
        return rate;
    }
    
    /**
     * 
     * @return double rateInsurance 
     */
    public double getRateInsurance() {
        return rateInsurance;
    }
    
    /**
     * 
     * @return String loanType
     */
    public String getLoanType() {
        return loanType;
    }
    
    
}
