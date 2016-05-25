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
public class RateParentCompany {

    
    private float rateDir;
    private int durationMin, durationMax;
    private String titleLoan;

    public RateParentCompany(int durationMin, int durationMax, String titleLoan) {
        this.durationMin = durationMin;
        this.durationMax = durationMax;
        this.titleLoan = titleLoan;
    }

    public float SelectRateDirector() throws SQLException {
        Connection connection = PdsDatabase.getConnection();

        String sql = "SELECT rate_dir FROM RATE r, TYPES t "
                + "WHERE r.id_types = t.id_types "
                + "AND t.title = ? AND r.duration_min = ? AND r.duration_max = ?";

        PreparedStatement ordre = connection.prepareStatement(sql);

        ordre.setString(1, titleLoan);
        ordre.setInt(2, durationMin);
        ordre.setInt(3, durationMax);

        ResultSet rs = ordre.executeQuery();

        System.out.println(sql);

        rs.next();
        rateDir = rs.getFloat("rate_dir");

        ordre.close();

        return rateDir;
    }
    
    public static float getRate(int duration, String loanType) throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();
        
        String sql = "SELECT rate_dir FROM RATE r, TYPES t"
                + "WHERE r.id_types = t.id_types "
                + "AND t.title = ? AND ? BETWEEN r.duration_min AND r.duration_max";
        
        PreparedStatement ordre = connection.prepareStatement(sql);

        ordre.setString(1, loanType);
        ordre.setInt(2, duration);
        
        ResultSet rs = ordre.executeQuery();
        
        rs.next();
        float rate = rs.getFloat("rate_dir");
        
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
        return rate;
    }
}
