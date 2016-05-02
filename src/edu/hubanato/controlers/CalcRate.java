/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * This class is used to calcultate the interest rate
 * @author Nadia Randria
 */
public class CalcRate implements ActionListener{
    
    private JTextField amount;
    private JSpinner duration;
    private JTextField deposit;
    private JTextField rate;
    private JButton calculate;

    public CalcRate(JTextField amt, JSpinner dt, JTextField dep, JTextField intrate, JButton calc) {
        this.amount = amt;
        this.duration = dt;
        this.deposit = dep;
        this.rate = intrate;
        this.calculate = calc;
    }

    /**
     * This method permit to calculate the interest rate
     * @return 
     */
    public float CalculateInterestRate(){
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == calculate) {
            int valAmount = Integer.parseInt(amount.getText());
            int valDuration = (Integer)duration.getValue();
            int valDeposit = Integer.parseInt(deposit.getText()); 
             
            JOptionPane.showMessageDialog(null,"Amount (€) : " +valAmount+ "\n Duration (months) : " +valDuration+ "\n Deposit (€) : " +valDeposit);
            //JOptionPane.showMessageDialog(null,"You are going to calculate the interest rate");
        }
    }
}
