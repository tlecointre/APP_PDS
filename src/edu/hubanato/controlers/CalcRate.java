/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * This class is used to calcultate the interest rate
 * @author Nadia Randria
 */
public class CalcRate implements ActionListener{
    
    private JComboBox loanType;
    private JTextField rateDirector;
    private JTextField amount;
    private JSpinner duration;
    private JTextField deposit;
    private JTextField rateMonth;
    private JTextField rateYear;
    private JButton calculate;
    private JLabel infoError;

    public CalcRate(JComboBox loan, JTextField rated, JTextField amt, JSpinner dt, JTextField dep, JTextField intratem, JTextField intratey, JButton calc, JLabel error) {
        this.loanType = loan;
        this.rateDirector = rated;
        this.amount = amt;
        this.duration = dt;
        this.deposit = dep;
        this.rateMonth = intratem;
        this.rateYear = intratey;
        this.calculate = calc;
        this.infoError = error;
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
    
    public double SelectRateDirector(){
        return 0;
    };
    
    public double CalculateInterestRateMonth(){
        return 0;
    };
    
    public double CalculateInterestRateYear(){
        return 0;
    };    

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
            
            rateMonth.setText(String.valueOf(resrate));
             
            JOptionPane.showMessageDialog(null,"Taux (%) : " +valRateD+ "\n Capital (€) : " +valAmount+ "\n Durée (months) : " +valDuration+ "\n Apport (€) : " +valDeposit);
            //JOptionPane.showMessageDialog(null,"You are going to calculate the interest rate");
        }
    }
}
