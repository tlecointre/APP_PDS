/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;


/**
 *
 * @author Baptiste
 */
public class Year {
        
    private double year;
    private double index;
    private double newRate;
    private double monthly;
    private double remaining;

    Year(double year, double index, double newRate, double monthly, double remaining) {
        this.year = year;
        this.index = index;
        this.newRate = newRate;
        this.monthly = monthly;
        this.remaining = remaining;
    } 

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public double getNewRate() {
        return newRate;
    }

    public void setNewRate(double newRate) {
        this.newRate = newRate;
    }

    public double getMonthly() {
        return monthly;
    }

    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }  
}
