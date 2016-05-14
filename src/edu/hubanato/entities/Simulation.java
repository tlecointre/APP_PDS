package edu.hubanato.entities;

import edu.hubanato.models.PdsDatabase;
import java.sql.*;

/**
 *
 * @author Tom
 */
public class Simulation {
    
    private int idSimulation, idClient, amount, duration;
    private double rate;
    private String loanType;
    
    public Simulation(int idClient, int amount, int duration, double rate, String loanType) {
        this.idClient = idClient;
        this.amount = amount;
        this.duration = duration;
        this.rate = rate;
        this.loanType = loanType;
    }
    
    public void createSimulation() throws SQLException {
        Connection connection = PdsDatabase.getConnection();
        
        int idLoanType;
        String sql = "SELECT ID_TYPES AS idLoanType FROM TYPES WHERE TITLE = ?";
        PreparedStatement o = connection.prepareStatement(sql);
        o.setString(1, loanType);
        ResultSet rs = o.executeQuery();
        rs.next();
        idLoanType = rs.getInt("idLoanType");

        String querySimulation = "INSERT INTO SIMULATION(ID_CUSTOMER,AMOUNT,DURATION,ID_TYPES,RATE_FINAL) VALUES (?,?,?,?,?)";
        PreparedStatement ordre = connection.prepareStatement(querySimulation);

        ordre.setInt(1, idClient);
        ordre.setInt(2, amount);
        ordre.setInt(3, duration);
        ordre.setInt(4, idLoanType);
        ordre.setDouble(5, rate);
        
        ordre.executeUpdate();
        ordre.close();

        connection.close();
    }
    
    public static Simulation getByClient(int idClient) throws SQLException {
        Connection connexion = PdsDatabase.getConnection();
        String sql = "SELECT * FROM SIMULATION s, TYPES t WHERE ID_CUSTOMER = ? AND s.ID_TYPES = t.ID_TYPES";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idClient);
        ResultSet rs = ordre.executeQuery();
        if (rs.next()) {
            return new Simulation(rs.getInt("ID_CUSTOMER"), rs.getInt("AMOUNT"), rs.getInt("DURATION"),
                    rs.getDouble("RATE_FINAL"), rs.getString("TITLE"));
        } else {
            return null;
        }
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

    public String getLoanType() {
        return loanType;
    }
    
    
}
