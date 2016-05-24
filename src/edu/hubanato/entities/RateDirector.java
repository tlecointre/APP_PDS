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

    public double SelectRateDirector(String type, int term) throws SQLException {
        Connection connection = PdsDatabase.getConnection();

        String sql = "SELECT rate FROM RATE r, TYPES t WHERE r.id_types = t.id_types"
                + " AND t.title = ? AND r.duration_max = ?";

        PreparedStatement ordre = connection.prepareStatement(sql);
        ordre.setString(1, type);
        ordre.setInt(2, term);

        ResultSet rs = ordre.executeQuery();

        System.out.println(sql);

        rs.next();

        double rateDirector = rs.getDouble("rate");
        ordre.close();

        return rateDirector;
    }
}
