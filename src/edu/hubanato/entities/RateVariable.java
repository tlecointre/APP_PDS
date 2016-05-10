/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

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
    
    /** 
     * calculate the monthly
     */
    public double calculateMonthly (double rate, double duree, double montant){

        double monthly=(montant*(rate/100)/12)/(1-(1/Math.pow((1+(rate/100)/12), 12*duree)));
        System.out.println("Montlhy for " + montant + "€ and " + duree + "year : "+ monthly);
        
        return monthly;
    }
    
    /** 
     * propose a table with an increasing variable rate
     */
    public void growthRate(double rate, double duree, double montant, double cape) {
        
        System.out.println("rentre growth");
        
        double monthly=calculateMonthly(rate, duree, montant);
        
        for (int cmpt=0; cmpt<duree; cmpt++){
        
//            listGrowth.add(new Year(cmpt,2.3,10,5.5,5.5));
            System.out.println("year:" + cmpt);
        
        }
            
        // Indiquer que l'objet a changé
        setChanged();
        // Prévenir les observateurs pour qu'ils se mettent à jour
        notifyObservers();
    }
    
    /** 
     * propose a table with an stable variable rate
     */
    public void stableRate(double rate, double duree, double montant, double cape) {
       
        System.out.println("rentre stable");
        
        double monthly=calculateMonthly(rate, duree, montant);
        
        
        for (int cmpt=0; cmpt<duree; cmpt++){
//            listGrowth.add(new Year(cmpt,2.3,10,5.5,5.5));
//            System.out.println("year:" + cmpt);
        }

        System.out.println("indique objet observable");

        // Indiquer que l'objet a changé
        setChanged();
        // Prévenir les observateurs pour qu'ils se mettent à jour
        notifyObservers();
    }
    
    
    /** 
     * propose a table with an decreasing variable rate
     */
    public void decreasingRate() {
                
        // Indiquer que l'objet a changé
        setChanged();
        // Prévenir les observateurs pour qu'ils se mettent à jour
        notifyObservers();
    }
    
}
