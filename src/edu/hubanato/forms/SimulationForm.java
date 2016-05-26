package edu.hubanato.forms;

import edu.hubanato.client.TCPClient;
import edu.hubanato.controlers.AmortizationCalc;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.InterestRate;
import edu.hubanato.entities.RateParentCompany;
import edu.hubanato.entities.Simulation;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom
 */
public class SimulationForm extends javax.swing.JFrame {

    /**
     * Creates new form SimulationForm
     */
    
    private Client client;
    
    public SimulationForm(Client client) {
        initComponents();
        labelSelectedClient.setText(client.getFirstName().substring(0,1).toUpperCase() + 
                                    client.getFirstName().substring(1).toLowerCase() + " " + 
                                    client.getName().toUpperCase());
        this.client = client;
    }
    
    public SimulationForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        labelParameters = new javax.swing.JLabel();
        labelLoanDuration = new javax.swing.JLabel();
        labelLoanType = new javax.swing.JLabel();
        cmbLoanType = new javax.swing.JComboBox();
        labelLoanAmount = new javax.swing.JLabel();
        txtAmountLoan = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        labelEuro = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        cmbTypeDuration = new javax.swing.JComboBox();
        labelClient = new javax.swing.JLabel();
        labelSelectedClient = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        labelRate = new javax.swing.JLabel();
        labelRateParent = new javax.swing.JLabel();
        labelRateDirector = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        labelInsuranceRate = new javax.swing.JLabel();
        txtInsuranceRate = new javax.swing.JTextField();
        labelParentRate = new javax.swing.JLabel();
        labelDirectorRate = new javax.swing.JLabel();
        btnSeeRate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simulation d'un prêt à taux fixe");

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 51, 102));
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Simulateur de prêt à taux fixe");

        labelParameters.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelParameters.setText("Saisir les paramètres :");

        labelLoanDuration.setText("Durée du prêt (ans) :");

        labelLoanType.setText("Type de prêt :");

        cmbLoanType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prêt à la consommation", "Prêt automobile", "Prêt immobilier" }));

        labelLoanAmount.setText("Montant du prêt :");

        txtAmountLoan.setPreferredSize(new java.awt.Dimension(60, 20));

        btnCalculate.setText("Valider");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        labelEuro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEuro.setText("€");

        txtDuration.setPreferredSize(new java.awt.Dimension(40, 20));

        cmbTypeDuration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "année(s)", "mois" }));

        labelClient.setText("Client :");

        labelSelectedClient.setPreferredSize(new java.awt.Dimension(100, 14));

        btnBack.setText("Retour");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labelRate.setText("Taux d'intérêt définitif :");

        labelRateParent.setText("Taux d'intérêt maison mère :");

        labelRateDirector.setText("Taux d'intérêt directeur agence :");

        txtRate.setPreferredSize(new java.awt.Dimension(60, 20));

        labelInsuranceRate.setText("Assurance (en % du montant global) :");

        txtInsuranceRate.setPreferredSize(new java.awt.Dimension(60, 20));

        labelParentRate.setPreferredSize(new java.awt.Dimension(60, 20));

        labelDirectorRate.setPreferredSize(new java.awt.Dimension(60, 20));

        btnSeeRate.setText("Voir les taux préconisés :");
        btnSeeRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeRateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelRate)
                                .addGap(18, 18, 18)
                                .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelRateParent)
                            .addComponent(labelLoanType)
                            .addComponent(labelClient)
                            .addComponent(labelLoanDuration))
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack)
                            .addComponent(labelRateDirector))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalculate)
                    .addComponent(btnSeeRate)
                    .addComponent(labelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInsuranceRate)
                            .addComponent(labelLoanAmount))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelParentRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSelectedClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTypeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAmountLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtInsuranceRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(labelEuro))
                            .addComponent(labelDirectorRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(labelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSelectedClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClient))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanType)
                    .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTypeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanAmount)
                    .addComponent(txtAmountLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEuro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInsuranceRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelInsuranceRate))
                .addGap(26, 26, 26)
                .addComponent(btnSeeRate)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelRateDirector)
                            .addComponent(labelDirectorRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelRateParent))
                    .addComponent(labelParentRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRate)
                    .addComponent(txtRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate)
                    .addComponent(btnBack)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        if (!(txtDuration.getText().isEmpty() || txtAmountLoan.getText().isEmpty() ||
                txtRate.getText().isEmpty() || txtInsuranceRate.getText().isEmpty())) {
            
            try {
                int duration = Integer.parseInt(txtDuration.getText());
                if (cmbTypeDuration.getSelectedIndex() == 0) { // duration in years
                    duration = duration * 12; // convert years in months
                }
                
                String loanType = cmbLoanType.getSelectedItem().toString();
                int amount = Integer.parseInt(txtAmountLoan.getText());
                
                if (!((loanType.equals("Prêt à la consommation") || loanType.equals("Prêt automobile")) && 
                        amount > 75000)) {
                    
                    if (!(loanType.equals("Prêt immobilier") && amount < 75000)) {
                        
                        if (!(loanType.equals("Prêt immobilier") && duration < 84)) {
                            
                            Simulation s = new Simulation(-1, this.client.getIdClient(), 
                                                    amount, duration, Double.parseDouble(txtRate.getText()), 
                                                    Double.parseDouble(txtInsuranceRate.getText()), 
                                                    loanType);


                            TCPClient tcpClient = new TCPClient("localhost",9999);
                            tcpClient.sendQuery("cs", edu.hubanato.serialization.EncodeJSON.serializeSimulation(s));
                            String response = tcpClient.receiveQuery();
                            if (response.equals("ok")) {
                                JOptionPane.showMessageDialog(null, "Simulation ajoutée");
                                new AmortizationCalc(s.getAmount(), s.getRate(), 
                                    Double.parseDouble(txtInsuranceRate.getText()), duration);
                            } else {
                                JOptionPane.showMessageDialog(null, "La connexion au serveur a échoué.", 
                                "Erreur serveur", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La durée d'un crédit immobilier ne peut pas être inférieure à 7 ans.", 
                                "Incohérence", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Le montant d'un crédit immobilier ne peut être inférieur à 75 000 euros.", 
                            "Incohérence", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Le montant d'un crédit automobile ou à la consommation ne peut excéder 75 000 euros.", 
                            "Incohérence", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez saisir des chiffres et non des lettres dans les champs appropriés.", 
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(SimulationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.",
                        "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        new AuthenticationClientForm().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSeeRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeRateActionPerformed
        if (!txtDuration.getText().isEmpty()) {
            try {
                int duration = Integer.parseInt(txtDuration.getText());
                if (cmbTypeDuration.getSelectedIndex() == 1) { // duration in months
                    duration = duration / 12; // convert months in years (without rounding)
                }
                TCPClient tcpClient = new TCPClient("localhost",9999);
                List<String> infoParentRate = new ArrayList<String>();
                infoParentRate.add(duration + ""); infoParentRate.add(cmbLoanType.getSelectedItem().toString());
                tcpClient.sendQuery("pr", edu.hubanato.serialization.EncodeJSON.serializeListString(infoParentRate));
                float parentRate = edu.hubanato.serialization.DecodeJSON.deserializeFloat(tcpClient.receiveQuery());
                
                TCPClient tcpClient2 = new TCPClient("localhost",9999);
                List<String> infoDirectorRate = new ArrayList<String>();
                infoDirectorRate.add(duration + ""); infoDirectorRate.add(this.client.getAge() + "");
                infoDirectorRate.add(cmbLoanType.getSelectedItem().toString());
                tcpClient2.sendQuery("dr", edu.hubanato.serialization.EncodeJSON.serializeListString(infoDirectorRate));
                float directorRate = edu.hubanato.serialization.DecodeJSON.deserializeFloat(tcpClient2.receiveQuery());
                
                if (parentRate == -1 || directorRate == -1) {
                    JOptionPane.showMessageDialog(null, "la durée de prêt et/ou l'âge du client "
                            + "ne peuvent être appliqués pour un " +
                            cmbLoanType.getSelectedItem().toString() + ".", 
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                } else {
                    labelDirectorRate.setText(directorRate + "");
                    labelParentRate.setText(parentRate + "");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "la durée de prêt et/ou l'âge du client "
                            + "ne peuvent être appliqués pour un " +
                            cmbLoanType.getSelectedItem().toString() + ".", 
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(SimulationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner la durée et le type de prêt pour visionner les taux.",
                    "Avertissement", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSeeRateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnSeeRate;
    private javax.swing.JComboBox cmbLoanType;
    private javax.swing.JComboBox cmbTypeDuration;
    private javax.swing.JLabel labelClient;
    private javax.swing.JLabel labelDirectorRate;
    private javax.swing.JLabel labelEuro;
    private javax.swing.JLabel labelInsuranceRate;
    private javax.swing.JLabel labelLoanAmount;
    private javax.swing.JLabel labelLoanDuration;
    private javax.swing.JLabel labelLoanType;
    private javax.swing.JLabel labelParameters;
    private javax.swing.JLabel labelParentRate;
    private javax.swing.JLabel labelRate;
    private javax.swing.JLabel labelRateDirector;
    private javax.swing.JLabel labelRateParent;
    private javax.swing.JLabel labelSelectedClient;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtAmountLoan;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtInsuranceRate;
    private javax.swing.JTextField txtRate;
    // End of variables declaration//GEN-END:variables
}
