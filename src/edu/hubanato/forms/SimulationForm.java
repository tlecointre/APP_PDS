package edu.hubanato.forms;

import edu.hubanato.client.TCPClient;
import edu.hubanato.controlers.AmortizationCalc;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.Simulation;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTitle.setText("Simulateur de prêt à taux fixe");

        labelParameters.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelParameters.setText("Saisir les paramètres :");

        labelLoanDuration.setText("Durée du prêt (ans) :");

        labelLoanType.setText("Type de prêt :");

        cmbLoanType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prêt à la consommation", "Prêt automobile", "Prêt immobilier" }));
        cmbLoanType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLoanTypeItemStateChanged(evt);
            }
        });

        labelLoanAmount.setText("Montant du prêt :");

        txtAmountLoan.setPreferredSize(new java.awt.Dimension(60, 20));
        txtAmountLoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountLoanKeyTyped(evt);
            }
        });

        btnCalculate.setText("Valider");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        labelEuro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEuro.setText("€");

        txtDuration.setPreferredSize(new java.awt.Dimension(40, 20));
        txtDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDurationKeyTyped(evt);
            }
        });

        cmbTypeDuration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "année(s)", "mois" }));

        labelClient.setText("Client :");

        labelSelectedClient.setPreferredSize(new java.awt.Dimension(100, 14));

        btnBack.setText("Retour");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labelRate.setText("Taux d'intérêt :");

        labelRateParent.setText("Taux d'intérêt maison mère :");

        labelRateDirector.setText("Taux d'intérêt directeur agence :");

        txtRate.setPreferredSize(new java.awt.Dimension(60, 20));

        labelInsuranceRate.setText("Assurance (en % du montant global) :");

        txtInsuranceRate.setPreferredSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLoanDuration)
                            .addComponent(labelLoanType)
                            .addComponent(labelClient)
                            .addComponent(labelRateParent)
                            .addComponent(labelRateDirector)
                            .addComponent(labelLoanAmount)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnBack)
                                        .addComponent(labelInsuranceRate))
                                    .addComponent(labelRate))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInsuranceRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCalculate)
                                        .addGap(221, 221, 221))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAmountLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTypeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelEuro)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSelectedClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTitle)
                .addGap(51, 51, 51))
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
                    .addComponent(labelEuro)
                    .addComponent(labelLoanAmount)
                    .addComponent(txtAmountLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelRateParent)
                .addGap(18, 18, 18)
                .addComponent(labelRateDirector)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRate)
                    .addComponent(txtRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInsuranceRate)
                    .addComponent(txtInsuranceRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate)
                    .addComponent(btnBack))
                .addGap(37, 37, 37))
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

                            new AmortizationCalc(s.getAmount(), s.getRate(), 
                                    Double.parseDouble(txtInsuranceRate.getText()), duration/12);
                            JOptionPane.showMessageDialog(null, "Simulation ajoutée");

                            new AuthenticationClientForm().setVisible(true);
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

    private void txtDurationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDurationKeyTyped
        if (!txtDuration.getText().isEmpty() && !txtAmountLoan.getText().isEmpty()) {
            //update the rates
        }
    }//GEN-LAST:event_txtDurationKeyTyped

    private void txtAmountLoanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountLoanKeyTyped
        if (!txtDuration.getText().isEmpty() && !txtAmountLoan.getText().isEmpty()) {
            //update the rates
        }
    }//GEN-LAST:event_txtAmountLoanKeyTyped

    private void cmbLoanTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLoanTypeItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            if (!txtDuration.getText().isEmpty() && !txtAmountLoan.getText().isEmpty()) {
                //update the rates
            }   
        }
    }//GEN-LAST:event_cmbLoanTypeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JComboBox cmbLoanType;
    private javax.swing.JComboBox cmbTypeDuration;
    private javax.swing.JLabel labelClient;
    private javax.swing.JLabel labelEuro;
    private javax.swing.JLabel labelInsuranceRate;
    private javax.swing.JLabel labelLoanAmount;
    private javax.swing.JLabel labelLoanDuration;
    private javax.swing.JLabel labelLoanType;
    private javax.swing.JLabel labelParameters;
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
