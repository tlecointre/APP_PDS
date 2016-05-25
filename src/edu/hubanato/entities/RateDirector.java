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
public class RateDirector {

    private int idRate, idTypeLoan;
    private float rateDir;
    private int amountMin, amountMax, durationMin, durationMax;
    private String titleLoan;

    public RateDirector(int durationMax, String titleLoan) {
        this.durationMax = durationMax;
        this.titleLoan = titleLoan;
    }

    public float SelectRateDirector(String type, int term) throws SQLException {
        Connection connection = PdsDatabase.getConnection();

        String sql = "SELECT rate_dir FROM RATE r, TYPES t "
                + "WHERE r.id_types = t.id_types "
                + "AND t.title = ? AND r.duration_max = ?";

        PreparedStatement ordre = connection.prepareStatement(sql);

        ordre.setString(1, titleLoan);
        ordre.setInt(2, durationMax);

        ResultSet rs = ordre.executeQuery();

        System.out.println(sql);

        rs.next();
        rateDir = rs.getFloat("rate_dir");

        ordre.close();

        return rateDir;
    }
}
