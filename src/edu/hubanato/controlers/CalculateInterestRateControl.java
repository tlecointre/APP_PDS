/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import edu.hubanato.client.TCPClient;
import edu.hubanato.entities.InterestRate;
import edu.hubanato.entities.RateParentCompany;
import edu.hubanato.entities.RiskInterestRate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is used to define the interest rate by the director
 *
 * @author Nadia Randria
 */
public class CalculateInterestRateControl implements ActionListener, ItemListener {

    private InterestRate intrate;
    private RateParentCompany ratedir;
    private RiskInterestRate risk;

    private JComboBox loanType;
    private JComboBox age;
    private JComboBox professionalSituation;
    private JComboBox loanTerm;
    private JComboBox personalContribution;
    private JComboBox debtRatio;

    private JTextField rateDirector;
    private JTextField interestRate;

    private JTextArea resultEvaluation;

    private JButton evaluate;
    private JButton saveInterestRate;

    /**
     *
     * @param loanType
     * @param age
     * @param proSituation
     * @param loanTerm
     * @param persoContribution
     * @param debtRatio
     * @param evaluation
     * @param rated
     * @param inrate
     * @param evaluate
     * @param saveInterestRate
     */
    public CalculateInterestRateControl(JComboBox loanType, JComboBox age, JComboBox proSituation,
            JComboBox loanTerm, JComboBox persoContribution, JComboBox debtRatio, JTextArea evaluation,
            JTextField rated, JTextField inrate, JButton evaluate, JButton saveInterestRate) {
        this.loanType = loanType;
        this.age = age;
        this.professionalSituation = proSituation;
        this.loanTerm = loanTerm;
        this.personalContribution = persoContribution;
        this.debtRatio = debtRatio;
        this.resultEvaluation = evaluation;
        this.rateDirector = rated;
        this.interestRate = inrate;
        this.evaluate = evaluate;
        this.saveInterestRate = saveInterestRate;
    }

    /**
     * This method is called when we clicked one of the button of the form
     * CalculateInterestRateForm.java The treatment depends on which button is
     * clicked
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        /**
         * This treatment allows the director to know the risk that the agency
         * takes when they lend money to a customer
         */
        if (source == evaluate) {

            String type = loanType.getSelectedItem().toString();

            switch (type) {
                case "Prêt à la consommation":
                case "Prêt automobile": {
                    String agePers = age.getSelectedItem().toString();
                    int ageMin = Integer.parseInt(agePers.substring(0, 2));
                    int ageMax = Integer.parseInt(agePers.substring(5, 7));

                    String profession = professionalSituation.getSelectedItem().toString();

                    int durationMin, durationMax;
                    durationMin = durationMax = Integer.parseInt(loanTerm.getSelectedItem().toString());

                    String contribution = personalContribution.getSelectedItem().toString();

                    String ratio = debtRatio.getSelectedItem().toString();

                    this.ratedir = new RateParentCompany(durationMin, durationMax, type);

                    this.intrate = new InterestRate(ageMin, ageMax, durationMin, durationMax, type);

                    this.risk = new RiskInterestRate(type, ageMin, ageMax, profession, durationMin, durationMax, contribution, ratio);
                    try {
                        float rate = ratedir.selectRateDirector();
                        rateDirector.setText(String.valueOf(rate));

                        float in = intrate.queryInterestRate();
                        interestRate.setText(String.valueOf(in));

                        String viewRisk = risk.viewRisk(type);

                        resultEvaluation.setText("Rappel des paramètres :\n - Type de prêt : " + type + "\n  - Intervalle d'âge : " + ageMin + "\n et " + ageMax + "ans \n - Durée Minimum de  : "
                                + durationMin + "ans \n - Durée maximum de : " + durationMax + "ans \n  - Apport personnel : " + contribution + "% du montant de l'opération \n  - Taux d'endettement : " + ratio + " % \n\n\n\n Les risques : \n" + viewRisk);

                    } catch (SQLException ex) {
                        Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "Prêt immobilier": {
                    String agePers = age.getSelectedItem().toString();
                    int ageMin = Integer.parseInt(agePers.substring(0, 2));
                    int ageMax = Integer.parseInt(agePers.substring(5, 7));

                    String profession = professionalSituation.getSelectedItem().toString();

                    String duration = loanTerm.getSelectedItem().toString();
                    switch (duration) {
                        case "7 - 10": {
                            int durationMin = Integer.parseInt(duration.substring(0, 1));
                            int durationMax = Integer.parseInt(duration.substring(4, 6));

                            String contribution = personalContribution.getSelectedItem().toString();

                            String ratio = debtRatio.getSelectedItem().toString();

                            this.ratedir = new RateParentCompany(durationMin, durationMax, type);

                            this.intrate = new InterestRate(ageMin, ageMax, durationMin, durationMax, type);

                            this.risk = new RiskInterestRate(type, ageMin, ageMax, profession, durationMin, durationMax, contribution, ratio);
                            try {
                                float rate = ratedir.selectRateDirector();
                                rateDirector.setText(String.valueOf(rate));

                                float in = intrate.queryInterestRate();
                                interestRate.setText(String.valueOf(in));

                                String viewRisk = risk.viewRisk(type);

                                resultEvaluation.setText("Rappel des paramètres :\n - Type de prêt : " + type + "\n  - Intervalle d'âge : " + ageMin + "\n et " + ageMax + "ans \n - Durée Minimum de  : "
                                        + durationMin + "ans \n - Durée maximum de : " + durationMax + "ans \n  - Apport personnel : " + contribution + "% du montant de l'opération \n  - Taux d'endettement : " + ratio + " % \n\n\n\n Les risques : \n" + viewRisk);

                            } catch (SQLException ex) {
                                Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }
                        default: {
                            int durationMin = Integer.parseInt(duration.substring(0, 2));
                            int durationMax = Integer.parseInt(duration.substring(5, 7));

                            String contribution = personalContribution.getSelectedItem().toString();

                            String ratio = debtRatio.getSelectedItem().toString();

                            this.ratedir = new RateParentCompany(durationMin, durationMax, type);

                            this.intrate = new InterestRate(ageMin, ageMax, durationMin, durationMax, type);

                            this.risk = new RiskInterestRate(type, ageMin, ageMax, profession, durationMin, durationMax, contribution, ratio);
                            try {
                                float rate = ratedir.selectRateDirector();
                                rateDirector.setText(String.valueOf(rate));

                                float in = intrate.queryInterestRate();
                                interestRate.setText(String.valueOf(in));

                                String viewRisk = risk.viewRisk(type);

                                resultEvaluation.setText("Rappel des paramètres :\n - Type de prêt : " + type + "\n  - Intervalle d'âge : " + ageMin + "\n et " + ageMax + "ans \n - Durée Minimum de  : "
                                        + durationMin + "ans \n - Durée maximum de : " + durationMax + "ans \n  - Apport personnel : " + contribution + "% du montant de l'opération \n  - Taux d'endettement : " + ratio + " % \n\n\n\n Les risques : \n" + viewRisk);

                            } catch (SQLException ex) {
                                Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }
                    }

                }
            }

        }

        /**
         * This treatment allows the director to define the interest rate that
         * the agency will propose to its customer
         */
        if (source == saveInterestRate) {
            if (!interestRate.getText().isEmpty()) {
                try {
                    String type = loanType.getSelectedItem().toString();

                    switch (type) {
                        case "Prêt à la consommation":
                        case "Prêt automobile": {
                            String agePers = age.getSelectedItem().toString();
                            int ageMin = Integer.parseInt(agePers.substring(0, 2));
                            int ageMax = Integer.parseInt(agePers.substring(5, 7));

                            int durationMin, durationMax;
                            durationMin = durationMax = Integer.parseInt(loanTerm.getSelectedItem().toString());

                            float ratedir = Float.parseFloat(rateDirector.getText());
                            float inRate = Float.parseFloat(interestRate.getText());

                            resultEvaluation.setText("Type de prêt : " + type + "\nTaux de la maison mère : " + ratedir + "% \nTaux d'intérêt : " + inRate);

                            InterestRate t = new InterestRate(inRate, ageMin, ageMax, durationMin, durationMax, type);
                            TCPClient tcpClient = new TCPClient("localhost", 9999);
                            tcpClient.sendQuery("ct", edu.hubanato.serialization.EncodeJSON.serializeInterestRate(t));
                            String response = tcpClient.receiveQuery();
                            if (response.equals("ok")) {
                                JOptionPane.showMessageDialog(null, "La taux de l'agence a été sauvegardée");
                            } else {
                                JOptionPane.showMessageDialog(null, "La connexion au serveur a échoué.",
                                        "Erreur serveur", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        }
                        case "Prêt immobilier": {
                            String agePers = age.getSelectedItem().toString();
                            int ageMin = Integer.parseInt(agePers.substring(0, 2));
                            int ageMax = Integer.parseInt(agePers.substring(5, 7));

                            String duration = loanTerm.getSelectedItem().toString();
                            switch (duration) {
                                case "7 - 10": {
                                    int durationMin = Integer.parseInt(duration.substring(0, 1));
                                    int durationMax = Integer.parseInt(duration.substring(4, 6));

                                    float ratedir = Float.parseFloat(rateDirector.getText());
                                    float inRate = Float.parseFloat(interestRate.getText());

                                    resultEvaluation.setText("Type de prêt : " + type + "\n Taux de la maison mère : " + ratedir + "% \n Taux d'intérêt : " + inRate);

                                    InterestRate t = new InterestRate(inRate, ageMin, ageMax, durationMin, durationMax, type);
                                    TCPClient tcpClient = new TCPClient("localhost", 9999);
                                    tcpClient.sendQuery("ct", edu.hubanato.serialization.EncodeJSON.serializeInterestRate(t));
                                    String response = tcpClient.receiveQuery();
                                    if (response.equals("ok")) {
                                        JOptionPane.showMessageDialog(null, "La taux de l'agence a été sauvegardée");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La connexion au serveur a échoué.",
                                                "Erreur serveur", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                                }
                                default: {
                                    int durationMin = Integer.parseInt(duration.substring(0, 2));
                                    int durationMax = Integer.parseInt(duration.substring(5, 7));

                                    float ratedir = Float.parseFloat(rateDirector.getText());
                                    float inRate = Float.parseFloat(interestRate.getText());

                                    resultEvaluation.setText("Type de prêt : " + type + "\n Taux de la maison mère : " + ratedir + "% \n Taux d'intérêt : " + inRate);

                                    InterestRate t = new InterestRate(inRate, ageMin, ageMax, durationMin, durationMax, type);
                                    TCPClient tcpClient = new TCPClient("localhost", 9999);
                                    tcpClient.sendQuery("ct", edu.hubanato.serialization.EncodeJSON.serializeInterestRate(t));
                                    String response = tcpClient.receiveQuery();
                                    if (response.equals("ok")) {
                                        JOptionPane.showMessageDialog(null, "La taux de l'agence a été sauvegardée");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La connexion au serveur a échoué.",
                                                "Erreur serveur", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                                }
                            }
                        }
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir des chiffres et non des lettres dans les champs appropriés.",
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(CalculateInterestRateControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir le taux appliqué par l'agence",
                        "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * This method sets the list of loan periods depending on the type of loan
     *
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {

        if (loanType.getSelectedItem().equals("Prêt à la consommation") || loanType.getSelectedItem().equals("Prêt automobile")) {
            loanTerm.removeAllItems();
            loanTerm.addItem(1);
            loanTerm.addItem(2);
            loanTerm.addItem(3);
            loanTerm.addItem(4);
            loanTerm.addItem(5);
            loanTerm.addItem(6);
        } else if (loanType.getSelectedItem().equals("Prêt immobilier")) {
            loanTerm.removeAllItems();
            loanTerm.addItem("7 - 10");
            loanTerm.addItem("11 - 15");
            loanTerm.addItem("16 - 20");
            loanTerm.addItem("21 - 25");
        }

    }

}
