/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import edu.hubanato.entities.CalcRate;
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
 *
 * @author Nadia Randria
 */
public class CalcRateControl implements ActionListener {

    private CalcRate intrate;

    private JComboBox loanType;
    private JTextField rateDirector;
    private JTextField age;
    private JTextField amount;
    private JSpinner duration;
    private JTextField deposit;
    private JTextField rateMonth;
    private JTextField rateYear;
    private JLabel infoError;
    
    private JButton calculate;
    private JButton save;

    /**
     *
     * @param loan
     * @param rated
     * @param agePers
     * @param amt
     * @param dt
     * @param dep
     * @param intratem
     * @param intratey
     * @param calc
     * @param error
     * @param saveRate 
     */
    public CalcRateControl(JComboBox loan, JTextField rated, JTextField agePers, JTextField amt, JSpinner dt, JTextField dep, JTextField intratem, JTextField intratey, JLabel error, JButton calc, JButton saveRate) {
        this.loanType = loan;
        this.rateDirector = rated;
        this.age = agePers;
        this.amount = amt;
        this.duration = dt;
        this.deposit = dep;
        this.rateMonth = intratem;
        this.rateYear = intratey;
        this.infoError = error;
        
        this.calculate = calc;
        this.save = saveRate;
    }

    /**
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == calculate) {

            double valRateD = Double.parseDouble(rateDirector.getText());
            double valAmount = Double.parseDouble(amount.getText());
            int valDuration = (Integer) duration.getValue();
            double valDeposit = Double.parseDouble(deposit.getText());

            this.intrate = new CalcRate();

            try {
                double r = intrate.SelectRateDirector();
                rateDirector.setText(String.valueOf(r));

                double resratem = intrate.CalculateInterestRateMonth(valAmount, valDeposit, valDuration);
                double resratey = intrate.CalculateInterestRateYear(valAmount, valDeposit, valDuration);
                rateMonth.setText(String.valueOf(resratem));
                rateYear.setText(String.valueOf(resratey));

                JOptionPane.showMessageDialog(null, "Taux (%) : " + valRateD + "\n Capital (€) : " + valAmount + "\n Durée (months) : " + valDuration + "\n Apport (€) : " + valDeposit);

            } catch (Exception e) {
            }
        }
        
        if (source == save){
        }
    }
}
