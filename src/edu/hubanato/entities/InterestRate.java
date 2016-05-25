/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import edu.hubanato.models.PdsDatabase;
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

    public void SaveInterestRate() throws SQLException {

        Connection connection = PdsDatabase.getConnection();

        String queryIdTypeLoan = "SELECT id_types as idTypeLoan FROM TYPES WHERE title = ?";
        PreparedStatement ordre = connection.prepareStatement(queryIdTypeLoan);

        ordre.setString(1, titleLoan);
        System.out.println(titleLoan);
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

}
