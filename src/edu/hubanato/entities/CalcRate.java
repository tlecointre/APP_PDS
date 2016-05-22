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

    /**
     *
     * @return
     */
    public double SelectRateDirector() {
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
        return 0;
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
        return tx;
    }
;
}
