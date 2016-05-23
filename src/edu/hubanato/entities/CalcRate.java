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
public class CalcRate {
    
    private int rateDirector;
    private int duration;
    private int deposit;
    private String loanType;
    
    /**
     *
     * @param loanType
     * @param duration
     * @return
     * @throws java.sql.SQLException
     */
    public double SelectRateDirector(String loanType, int duration) throws SQLException {
        Connection connection = PdsDatabase.getConnection();
        
        String sql = "SELECT rate as rateDirector FROM RATE r, TYPES t WHERE r.id_types = t.id_types"
                + " AND t.title = ?";
        
        try (PreparedStatement ordre = connection.prepareStatement(sql)) {
            ordre.setString(1, loanType);
            ResultSet rs = ordre.executeQuery();
            rs.next();
            rateDirector = rs.getInt("rateDirector");
        }
        
        return rateDirector;
    }

    ;
    /**
     * 
     */
    public void SaveInterestRate() {
    }

    /**
     *
     * @param amt
     * @param depost
     * @param dur
     * @return
     */
    public double CalculateInterestRateMonth(double amt, double depost, int dur) {
        double txm = CalculateInterestRateYear(amt, depost, dur);
        double tx = txm / 12;
        return tx;
    }

    ;
    /**
     * 
     * @param amt
     * @param depost
     * @param dur
     * @return 
     */
    public double CalculateInterestRateYear(double amt, double depost, int dur) {
        double tx = (1200 * depost) / (amt * dur);
        tx = tx*100;
        return tx;
    }
;
}
