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
     * This method permit to calculate the interest rate
     * @param amt
     * @param depost
     * @param dur
     * @return 
     */
    public double CalculateInterestRate(double amt, double depost, int dur){
        double tx = (1200 * depost)/(amt * dur);
        return tx;
    }
    
    public double SelectRateDirector(){
        return 0;
    };
    
    public void SaveInterestRate(){
    }
    
    public double CalculateInterestRateMonth(){
        return 0;
    };
    
    public double CalculateInterestRateYear(){
        return 0;
    };
}
