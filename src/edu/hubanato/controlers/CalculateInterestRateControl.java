/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import edu.hubanato.entities.InterestRate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is used to calcultate the interest rate
 *
 * @author Nadia Randria
 */
public class CalculateInterestRateControl implements ActionListener {

    private InterestRate intrate;

    private JComboBox loanType;
    private JTextField rateDirector;
    private JComboBox profil;
    private JComboBox age;
    private JComboBox duration;
    private JTextField rateYear;
    private JTextArea message;

    private JButton calculate;
    private JButton save;

    /**
     *
     * @param loan
     * @param rated
     * @param prof
     * @param agePers
     * @param dt
     * @param intratey
     * @param msg
     * @param calc
     * @param saveRate
     */
    public CalculateInterestRateControl(JComboBox loan, JTextField rated, JComboBox prof, JComboBox agePers, JComboBox dt, JTextField intratey, JTextArea msg, JButton calc, JButton saveRate) {
        this.loanType = loan;
        this.rateDirector = rated;
        this.profil = prof;
        this.age = agePers;
        this.duration = dt;
        this.rateYear = intratey;
        this.message = msg;

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
            String type = loanType.getSelectedItem().toString();
            int valDuration = Integer.parseInt(duration.getSelectedItem().toString());

            this.intrate = new InterestRate();

            try {
                float r = intrate.SelectRateDirector(type, valDuration);
                rateDirector.setText(String.valueOf(r));

                float resratey = intrate.CalculateInterestRateYear();

                if (resratey < 0 || resratey == 0) {
                    message.setText("Le taux appliqué est négatif ou nul. Veuillez revoir vos paramètres");
                } else if (resratey > 0) {
                    rateYear.setText(String.valueOf(resratey));
                }

                //JOptionPane.showMessageDialog(null, "Capital (€) : " + valAmount + "\n Durée (months) : " + valDuration + "\n Apport (€) : " + valDeposit);
            } catch (Exception e) {
            }

        }

        if (source == save) {
            this.intrate = new InterestRate();

            try {
                intrate.SaveInterestRate();
            } catch (Exception e) {
            }
        }
    }
    
    
}
