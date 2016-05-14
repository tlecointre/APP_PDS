/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Baptiste
 */
public class RateVariable extends Observable {
    
    private List<Year> listGrowth;
    private List<Year> listStable;
    private List<Year> listDecreasing;

    public RateVariable() {
        listStable = new ArrayList<>();
        listGrowth = new ArrayList<>();
        listDecreasing = new ArrayList<>();
    }
    
    /** 
     * reset all lists
     */
    public void resetLists(){
        listDecreasing.clear();
        listGrowth.clear();
        listStable.clear();
    }
    
    /** 
     * calculate the monthly
     * @param rate
     * @param duree
     * @param montant
     * @return 
     */
    public double calculateMonthly (double rate, double duree, double montant){

        double monthly=(montant*(rate/100)/12)/(1-(1/Math.pow((1+(rate/100)/12), 12*duree)));
//        System.out.println("Mountant:" + montant + "€ | Duree: " + duree + " | Rate: " + rate + " | Monthly : "+ monthly);
        
        return monthly;
    }
    
    /** 
     * calculate the remaining
     * @param remainingTime
     * @param monthly
     * @return 
     */
    public double calculateRemaining (double remainingTime, double monthly){
        
        double remaining= ((12*remainingTime)*monthly)-(12*monthly) ;
//        System.out.println("Remaining time: " + remainingTime + " year for :"+ remaining + "€");
        
        return remaining ;
    }
    
    /** 
     * propose a table with an increasing variable rate
     * @param rate
     * @param duree
     * @param montant
     * @param cape
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
        
        // Indicate that the object growthRate has changed
        setChanged();
        System.out.println("Indicate that the object growthRate has changed");
        
        // Prevent observers to update themselves
        notifyObservers();
        System.out.println("Prevent observers to update themselves");
    }
    
    /** 
     * propose a table with an stable variable rate
     * @param rate
     * @param duree
     * @param montant
     * @param cape
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

        // Indicate that the object StableRate has changed
        setChanged();
        System.out.println("Indicate that the object StableRate has changed");
        
        // Prevent observers to update themselves
        notifyObservers();
        System.out.println("Prevent observers to update themselves");
    }
    
    /** 
     * propose a table with an decreasing variable rate
     * @param rate
     * @param duree
     * @param montant
     * @param cape
     */
    public void decayRate(double rate, double duree, double montant, double cape) {
       
        double monthly;
        System.out.println("------DecayRate------");

        for (int i=1; i<duree; i++){
            if (i==1){
                monthly=calculateMonthly(rate-(i*(cape/duree)), duree, montant);
                listDecreasing.add(new Year(i, cape, rate+(i*(cape/duree)), monthly, calculateRemaining(duree, monthly)));
            }
            else{
                monthly=calculateMonthly(rate-(i*(cape/duree)), duree, montant);
                listDecreasing.add(new Year(i, cape, rate+(i*(cape/duree)), monthly, calculateRemaining(duree-i, monthly)));
            }
        }    
        
        // Indicate that the object DecayRate has changed
        setChanged();
        System.out.println("Indicate that the object DecayRate has changed");
        
        // Prevent observers to update themselves
        notifyObservers();
        System.out.println("Prevent observers to update themselves");
    }
    
//    public void notifyObserverObservable (){
//         // Indicate that the object growthRate has changed
//        setChanged();
//        System.out.println("Indicate that the object growthRate has changed");
//        
//        // Prevent observers to update themselves
//        notifyObservers();
//        System.out.println("Prevent observers to update themselves");
//    }
    
}
