/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.Observable;

/**
 *
 * @author Baptiste
 */
public class RateVariable extends Observable {
    
    /** 
     * propose a table with an increasing variable rate
     */
    public void growthRate() {
                
        // Indiquer que l'objet a changé
        setChanged();
        // Prévenir les observateurs pour qu'ils se mettent à jour
        notifyObservers();
    }
    
    /** 
     * propose a table with an stable variable rate
     */
    public void stableRate() {
                
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
