/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

/**
 *
 * @author Nadia Randria
 */
public class CalcRate {
    
    private int duration;
    private int deposit;
    private String loanType;
    
    /**
     *
     * @param loanType
     * @param duration
     * @return
     */
    public double SelectRateDirector(String loanType, int duration) {
        return 0;
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
