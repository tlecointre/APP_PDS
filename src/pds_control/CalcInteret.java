/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pds_control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * This class is used to calcultate the interest rate
 * @author Nadia Randria
 */
public class CalcInteret implements ActionListener{
    
    private JTextField emprunt;
    private JTextField duree;
    private JTextField apport;
    private JTextField taux;
    private JButton calculer;

    public CalcInteret(JTextField emprunt, JTextField duree, JTextField apport, JTextField taux, JButton calculer) {
        this.emprunt = emprunt;
        this.duree = duree;
        this.apport = apport;
        this.taux = taux;
        this.calculer = calculer;
    }

    /**
     * This method permit to calculate the interest rate
     * @return 
     */
    public float CalculerTaux(){
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == calculer) {}
    }
}
