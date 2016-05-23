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
import javax.swing.JSpinner;
import javax.swing.JTextArea;
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
    private JComboBox age;
    private JTextField salary;
    private JTextField amount;
    private JSpinner duration;
    private JTextField deposit;
    private JTextField rateMonth;
    private JTextField rateYear;
    private JTextArea message;

    private JButton calculate;
    private JButton save;

    /**
     *
     * @param loan
     * @param rated
     * @param agePers
     * @param sal
     * @param amt
     * @param dt
     * @param dep
     * @param intratem
     * @param intratey
     * @param msg
     * @param calc
     * @param saveRate
     */
    public CalcRateControl(JComboBox loan, JTextField rated, JComboBox agePers, JTextField sal, JTextField amt, JSpinner dt, JTextField dep, JTextField intratem, JTextField intratey, JTextArea msg, JButton calc, JButton saveRate) {
        this.loanType = loan;
        this.rateDirector = rated;
        this.age = agePers;
        this.salary = sal;
        this.amount = amt;
        this.duration = dt;
        this.deposit = dep;
        this.rateMonth = intratem;
        this.rateYear = intratey;
        this.message = msg;

        this.calculate = calc;
        this.save = saveRate;
    }
    
    /**
     * Returns true if one of the mandatory fields is empty and returns false if not
     * @return 
     */
    private boolean fieldsEmpty() {
        //if (age.getText().isEmpty() || amount.getText().isEmpty() || deposit.getText().isEmpty()) {
        if (amount.getText().isEmpty() || deposit.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == calculate) {

            if (!fieldsEmpty()) {
                String type = loanType.getSelectedItem().toString();
                double valAmount = Double.parseDouble(amount.getText());
                int valDuration = (Integer) duration.getValue();
                double valDeposit = Double.parseDouble(deposit.getText());

                this.intrate = new CalcRate();

                try {
                    double r = intrate.SelectRateDirector(type,valDuration);
                    rateDirector.setText(String.valueOf(r));

                    double resratem = intrate.CalculateInterestRateMonth(valAmount, valDeposit, valDuration);
                    double resratey = intrate.CalculateInterestRateYear(valAmount, valDeposit, valDuration);

                    if (resratey < 0 || resratey == 0) {
                        message.setText("Le taux appliqué est négatif ou nul. Veuillez revoir vos paramètres");
                    } else if (resratey > 0) {
                        rateMonth.setText(String.valueOf(resratem));
                        rateYear.setText(String.valueOf(resratey));
                    }

                //JOptionPane.showMessageDialog(null, "Capital (€) : " + valAmount + "\n Durée (months) : " + valDuration + "\n Apport (€) : " + valDeposit);
                } catch (Exception e) {
                }
            }

        }

        if (source == save) {
            this.intrate = new CalcRate();

            try {
                intrate.SaveInterestRate();
            } catch (Exception e) {
            }
        }
    }
}
