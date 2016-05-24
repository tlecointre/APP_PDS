/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Baptiste
 */
public class RateVariable {
    
    // Variable declaration
    private List<Year> listGrowth;
    private List<Year> listStable;
    private List<Year> listDecreasing;
    private double rateMin;
    private double rateMax;
    private double rate;

    /**
     * Creates new object RateVariable
     */
    public RateVariable() {
        listStable = new ArrayList<>();
        listGrowth = new ArrayList<>();
        listDecreasing = new ArrayList<>();
        
        // Choosing the minimum and maximum rates by default and configurable in the menu
        rateMin=2;
        rateMax=6;
    }

    public List<Year> getListGrowth() {
        return listGrowth;
    }

    public void setListGrowth(List<Year> listGrowth) {
        this.listGrowth = listGrowth;
    }

    public List<Year> getListStable() {
        return listStable;
    }

    public void setListStable(List<Year> listStable) {
        this.listStable = listStable;
    }

    public List<Year> getListDecreasing() {
        return listDecreasing;
    }

    public void setListDecreasing(List<Year> listDecreasing) {
        this.listDecreasing = listDecreasing;
    }
    
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public double getRateMin() {
        return rateMin;
    }

    public void setRateMin(double rateMin) {
        this.rateMin = rateMin;
    }

    public double getRateMax() {
        return rateMax;
    }

    public void setRateMax(double rateMax) {
        this.rateMax = rateMax;
    }
    
    /** 
     * Reset all lists
     */
    public void resetLists(){
        listDecreasing.clear();
        listGrowth.clear();
        listStable.clear();
        System.out.println("All lists are reset");
    }
    
    /**
     * Depending on the type of rate, can convert objects Year from the list concerned Double tables. 
     * Then add this table into an ArrayList Double. 
     * And returns that ArrayList Double.
     * @param typeRate
     *            String containing the type of rate.
     * @return ArrayList Double
     *            Return the list of decreasing rate.     
     */
    public ArrayList<Double[]> getListDouble(String typeRate){
        
        ArrayList<Double[]> tableDouble = new ArrayList<>();
        Year year = null;
        
        switch (typeRate) {
        case "decay":
            year = null;
            System.out.println("Displays simulation of decay rates");
            for(int j =0; j < listDecreasing.size(); j++){
                year = listDecreasing.get(j);
//                System.out.println(year.getYear() + " | " + year.getIndex() + " | " + year.getNewRate() + " | " + year.getMonthly() + " | " + year.getRemaining());
                tableDouble.add(new Double[] {year.getYear(), year.getIndex(), year.getNewRate(), year.getMonthly(), year.getRemaining()});
            }
            break;
            
        case "growth":
            year = null;
            System.out.println("Displays simulation of growth rates");
            for(int j =0; j < listGrowth.size(); j++){
                year = listGrowth.get(j);
//                System.out.println(year.getYear() + " | " + year.getIndex() + " | " + year.getNewRate() + " | " + year.getMonthly() + " | " + year.getRemaining());
                tableDouble.add(new Double[] {year.getYear(), year.getIndex(), year.getNewRate(), year.getMonthly(), year.getRemaining()});
            }
            break;
            
        case "stable":
            year = null;
            System.out.println("Displays simulation of satble rates");
            for(int j =0; j < listStable.size(); j++){
                year = listStable.get(j);
//                System.out.println(year.getYear() + " | " + year.getIndex() + " | " + year.getNewRate() + " | " + year.getMonthly() + " | " + year.getRemaining());
                tableDouble.add(new Double[] {year.getYear(), year.getIndex(), year.getNewRate(), year.getMonthly(), year.getRemaining()});
            }
            break;
            
        default:
            System.out.println("erreur");

        }
       
        return tableDouble;
    }

    
    /** 
    * Calculate the monthly payments based on the rate, amount and duration. 
    * Then return the value of the monthly payment.
    * @param rate
    *            The value of the download rate.
    * @param duree
    *            Time desired loan.
    * @param montant
    *            Time desired loan.
    * @return double
    *            Return the value of the monthly payment.  
    */
    public double calculateMonthly (double rate, double duree, double montant){

        double monthly=(montant*(rate/100)/12)/(1-(1/Math.pow((1+(rate/100)/12), 12*duree)));
//        System.out.println("Mountant:" + montant + "€ | Duree: " + duree + " | Rate: " + rate + " | Monthly : "+ monthly);
        
        return roundingDecimals(monthly);
    }
    
    /** 
    * Calculate the remainder to be paid based on monthly payment and the remaining time. 
    * Then return the value of the remaining liabilities.
    * @param duree
    *            The value of the download rate.
    * @param monthly
    *            Time desired loan.
    * @return double
    *            Return the value of the remaining liabilities.
    */
    public double calculateRemaining (double duree, double monthly){
        
        double remaining= ((12*duree)*monthly)-(12*monthly) ;
//        System.out.println("Remaining time: " + remainingTime + " year for :"+ remaining + "€");

        return roundingDecimals(remaining) ;
    }
    

    /**
    * Propose a table with an increasing variable rate
    * @param rate
    *            The value of the download rate.
    * @param duree
    *            Time desired loan.
    * @param montant
    *            Amount to borrow.
    * @param cape
    *            Index to respect.
    */
    public void growthRate(double rate, double duree, double montant, double cape) {
        System.out.println("---Calculate the simulation of growth rate---");

        double monthly;
        double rateChecked;
        
        for (int i=0; i<duree; i++){
            
            rateChecked=checkRateMax(rate, duree, i, cape);
            if (i==0){
                monthly=calculateMonthly(rateChecked, duree, montant);
                listGrowth.add(new Year(i+1, cape, rateChecked, monthly, calculateRemaining(duree, monthly)));
            }
            else{
                monthly=calculateMonthly(rateChecked, duree, montant);
                listGrowth.add(new Year(i+1, cape, rateChecked, monthly, calculateRemaining(duree-i, monthly)));
            }
        }    
        
    }
    
    /** 
    * Propose a table with an stable variable rate
    * @param rate
    *            The value of the download rate.
    * @param duree
    *            Time desired loan.
    * @param montant
    *            Amount to borrow.
    * @param cape
    *            Index to respect.
    */
    public void stableRate(double rate, double duree, double montant, double cape) {
        System.out.println("---Calculate the simulation of stable rate---");

        double monthly;
        
        for (int i=0; i<duree; i++){ 
            if (i%2==0){
                if (i==1){
                    monthly=calculateMonthly(rate+(cape/duree), duree, montant);
                    listStable.add(new Year(i+1, cape, rate+(cape/duree), monthly, calculateRemaining(duree, monthly)));
                }
                else{
                    monthly=calculateMonthly(rate+(cape/duree), duree, montant);
                    listStable.add(new Year(i+1, cape, rate+(cape/duree), monthly, calculateRemaining(duree-i, monthly)));
                }
            }
            else {
                monthly=calculateMonthly(rate-(cape/duree), duree, montant);
                listStable.add(new Year(i+1, cape, rate-(cape/duree), monthly, calculateRemaining(duree-i, monthly)));
            }
        }

    }
    
    /** 
    * Propose a table with an decreasing variable rate
    * @param rate
    *            The value of the download rate.
    * @param duree
    *            Time desired loan.
    * @param montant
    *            Amount to borrow.
    * @param cape
    *            Index to respect.
    */
    public void decayRate(double rate, double duree, double montant, double cape) {
       
        System.out.println("---Calculate the simulation of decay rate---");

        double monthly;
        double rateChecked;
        
        for (int i=0; i<duree; i++){
            
            rateChecked=checkRateMin(rate, duree, i, cape);
            if (i==0){
                monthly=calculateMonthly(rateChecked, duree, montant);
                listDecreasing.add(new Year(i+1, cape, rateChecked, monthly, calculateRemaining(duree, monthly)));
            }
            else{
                monthly=calculateMonthly(rateChecked, duree, montant);
                listDecreasing.add(new Year(i+1, cape, rateChecked, monthly, calculateRemaining(duree-i, monthly)));
            }
        }
    }
    
    /** 
    * Calculate the new rate and test if it is lower than the minimum rate set according to the chosen capped.
    * If the new rate lower then return the minimum rate allowed, if the calculated rate.
    * @param rate
    *            The value of the download rate.
    * @param duree
    *            Time desired loan.
    * @param year
    *            The value of the current calculated year.
    * @param cape
    *            Index to respect.
    * @return double
    *            Return the value of the rate.
    */
    public double checkRateMin(double rate, double duree, double year, double cape){
        if( (rate-(year*(cape/duree))) < rateMin){
            return rateMin;
        }
        else {
            return roundingDecimals(rate-(year*(cape/duree)));   
        }     
    }
    
    /** 
    * Calculate the new rate and test if it exceeds the maximum rate set according to the chosen capped.
    * If the new rate supperior then return the maximum rate allowed, if the calculated rate.
    * @param rate
    *            The value of the download rate.
    * @param duree
    *            Time desired loan.
    * @param year
    *            The value of the current calculated year.
    * @param cape
    *            Index to respect.
    * @return double
    *            Return the value of the rate.
    */
    public double checkRateMax(double rate, double duree, double year, double cape){
        if( (rate+(year*(cape/duree))) > rateMax){
            return rateMax;
        }
        else {
            return roundingDecimals(rate+(year*(cape/duree)));   
        }     
    }
    
    /** 
    * Used to round all numbers with 2 digits after the comma
    * @param number
    *            The number to be rounded to two decimal comma.
    * @return double
    *            Return the number rounded to two decimal places.
    */    
    private double roundingDecimals(double number){
        double pow = Math.pow(10, 2);
        return (Math.floor(number * pow)) / pow;
    }

}
