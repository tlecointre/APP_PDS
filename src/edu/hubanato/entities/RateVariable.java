/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import edu.hubanato.entities.Year;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Baptiste
 */
public class RateVariable {
    
    // Variable declaration
    private List<Year> listGrowth;
    private List<Year> listStable;
    private List<Year> listDecreasing;

    /**
     * Creates new object RateVariable
     */
    public RateVariable() {
        listStable = new ArrayList<>();
        listGrowth = new ArrayList<>();
        listDecreasing = new ArrayList<>();
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
     * Then add this table into an ArrayList <Double []>. 
     * And returns that ArrayList <Double []>.
     * @param typeRate
     *            String containing the type of rate.
     * @return ArrayList<Double[]>
     *            Return the list of decreasing rate.     
     */
    public ArrayList<Double[]> getListDouble(String typeRate){
        
        ArrayList<Double[]> tableDouble = new ArrayList<>();
        Year year = null;
        
        switch (typeRate) {
        case "decay":
            year = null;
            System.out.println("enter case decay");
            for(int j =0; j < listDecreasing.size(); j++){
                year = listDecreasing.get(j);
                System.out.println(year.getYear() + " | " + year.getIndex() + " | " + year.getNewRate() + " | " + year.getMonthly() + " | " + year.getRemaining());
                tableDouble.add(new Double[] {year.getYear(), year.getIndex(), year.getNewRate(), year.getMonthly(), year.getRemaining()});
            }
            break;
            
        case "growth":
            year = null;
            System.out.println("enter case growth");
            for(int j =0; j < listGrowth.size(); j++){
                year = listGrowth.get(j);
                System.out.println(year.getYear() + " | " + year.getIndex() + " | " + year.getNewRate() + " | " + year.getMonthly() + " | " + year.getRemaining());
                tableDouble.add(new Double[] {year.getYear(), year.getIndex(), year.getNewRate(), year.getMonthly(), year.getRemaining()});
            }
            break;
            
        case "stable":
            year = null;
            System.out.println("enter case stable");
            for(int j =0; j < listStable.size(); j++){
                year = listStable.get(j);
                System.out.println(year.getYear() + " | " + year.getIndex() + " | " + year.getNewRate() + " | " + year.getMonthly() + " | " + year.getRemaining());
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
        
        return monthly;
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

        return remaining ;
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
        
        double monthly;
        System.out.println("------GrowthRate------");

        for (int i=1; i<duree; i++){
            if (i==1){
                monthly=calculateMonthly(rate+(i*(cape/duree)), duree, montant);
                listGrowth.add(new Year(i, cape, rate+(i*(cape/duree)), monthly, calculateRemaining(duree, monthly)));
            }
            else{
                monthly=calculateMonthly(rate+(i*(cape/duree)), duree, montant);
                listGrowth.add(new Year(i, cape, rate+(i*(cape/duree)), monthly, calculateRemaining(duree-i, monthly)));
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
       
        double monthly;
        System.out.println("------StableRate------");

        for (int i=1; i<duree; i++){            
            if (i%2==0){
                if (i==1){
                    monthly=calculateMonthly(rate+(cape/duree), duree, montant);
                    listStable.add(new Year(i, cape, rate+(cape/duree), monthly, calculateRemaining(duree, monthly)));
                }
                else{
                    monthly=calculateMonthly(rate+(cape/duree), duree, montant);
                    listStable.add(new Year(i, cape, rate+(cape/duree), monthly, calculateRemaining(duree-i, monthly)));
                }
            }
            else {
                monthly=calculateMonthly(rate-(cape/duree), duree, montant);
                listStable.add(new Year(i, cape, rate-(cape/duree), monthly, calculateRemaining(duree-i, monthly)));
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
       
        double monthly;
        System.out.println("------DecayRate------");

        for (int i=1; i<duree; i++){
            if (i==1){
                monthly=calculateMonthly(rate-(i*(cape/duree)), duree, montant);
                listDecreasing.add(new Year(i, cape, rate-(i*(cape/duree)), monthly, calculateRemaining(duree, monthly)));
            }
            else{
                monthly=calculateMonthly(rate-(i*(cape/duree)), duree, montant);
                listDecreasing.add(new Year(i, cape, rate-(i*(cape/duree)), monthly, calculateRemaining(duree-i, monthly)));
            }
        }
    }
}
