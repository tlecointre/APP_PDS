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
    
    private JTextField rateDirector;
    private JTextField amount;
    private JSpinner duration;
    private JTextField deposit;
    private JTextField rate;
    private JButton calculate;

    public CalcRate(JTextField rated, JTextField amt, JSpinner dt, JTextField dep, JTextField intrate, JButton calc) {
        this.rateDirector = rated;
        this.amount = amt;
        this.duration = dt;
        this.deposit = dep;
        this.rate = intrate;
        this.calculate = calc;
    }

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

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == calculate) {
            /*double valRateD = Integer.parseInt(rateDirector.getText());
            double valAmount = Integer.parseInt(amount.getText());
            int valDuration = (Integer)duration.getValue();
            double valDeposit = Integer.parseInt(deposit.getText());*/
            
            double valRateD = Double.parseDouble(rateDirector.getText());
            double valAmount = Double.parseDouble(amount.getText());
            int valDuration = (Integer)duration.getValue();
            double valDeposit = Double.parseDouble(deposit.getText());
            
            double resrate = CalculateInterestRate(valAmount, valDeposit, valDuration);
            
            rate.setText(String.valueOf(resrate));
             
            JOptionPane.showMessageDialog(null,"Rate (%) : " +valRateD+ "\n Amount (€) : " +valAmount+ "\n Duration (months) : " +valDuration+ "\n Deposit (€) : " +valDeposit);
            //JOptionPane.showMessageDialog(null,"You are going to calculate the interest rate");
        }
    }
}
