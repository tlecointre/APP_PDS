/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import edu.hubanato.models.PdsDatabase;
import edu.hubanato.server.InterfacePoolServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nadia Randria
 */
public class InterestRate {

    private int idTypeLoan;
    private float interestRate;
    private int ageMin, ageMax;
    private int durationMin, durationMax;
    private String titleLoan;

    public InterestRate(float interestRate, int ageMin, int ageMax, int durationMin, int durationMax, String title) {

        this.interestRate = interestRate;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.durationMin = durationMin;
        this.durationMax = durationMax;
        this.titleLoan = title;
    }

    public void saveInterestRate() throws SQLException {

        Connection connection = PdsDatabase.getConnection();

        String queryIdTypeLoan = "SELECT id_types as idTypeLoan FROM TYPES WHERE title = ?";
        PreparedStatement ordre = connection.prepareStatement(queryIdTypeLoan);

        ordre.setString(1, titleLoan);
        
        ResultSet rs = ordre.executeQuery();

        System.out.println(queryIdTypeLoan);

        rs.next();

        idTypeLoan = rs.getInt("idTypeLoan");

        ordre.close();

        String queryInsertRate = "INSERT INTO INTEREST_RATE(INTRATE,AGE_MIN,AGE_MAX,DURATION_MIN,DURATION_MAX,ID_TYPES) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ordre2 = connection.prepareStatement(queryInsertRate);

        ordre2.setFloat(1, interestRate);
        ordre2.setInt(2, ageMin);
        ordre2.setInt(3, ageMax);
        ordre2.setInt(4, durationMin);
        ordre2.setInt(5, durationMax);
        ordre2.setInt(6, idTypeLoan);

        ordre2.executeUpdate();

        System.out.println(queryInsertRate);
        
        ordre2.close();
    }
    
    public static float getRate(int duration, int age, String loanType) throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();
        
        String sql = "SELECT intrate FROM INTEREST_RATE r, TYPES t "
                + "WHERE r.id_types = t.id_types "
                + "AND t.title = ? AND ? BETWEEN r.duration_min AND r.duration_max "
                + "AND ? BETWEEN r.age_min AND r.age_max";
        
        PreparedStatement ordre = connection.prepareStatement(sql);

        ordre.setString(1, loanType);
        ordre.setInt(2, duration);
        ordre.setInt(3, age);
        
        ResultSet rs = ordre.executeQuery();
        
        float rate;
        if (rs.next()) {
            rate = rs.getFloat("intrate");
        } else {
            rate = -1;
        }
        System.out.println(rate);
        
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
        return rate;
    }

}
