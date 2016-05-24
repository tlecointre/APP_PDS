package edu.hubanato.forms;

import edu.hubanato.client.TCPClient;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.Simulation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom
 */
public class SimulationUpdateForm extends javax.swing.JFrame {

    private Simulation simulation;
    private Client client;
    
    public SimulationUpdateForm(Simulation simulation, Client client) {
        initComponents();
        this.simulation = simulation;
        this.client = client;
        cmbLoanType.setSelectedItem(simulation.getLoanType());
        cmbDurationType.setSelectedItem("mois"); // Duration is stored in months
        txtDuration.setText(simulation.getDuration() + "");
        txtAmountLoan.setText(simulation.getAmount() + "");
        txtRate.setText(simulation.getRate() + "");
        txtInsuranceRate.setText(simulation.getRateInsurance() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSubtitle = new javax.swing.JLabel();
        labelLoanDuration = new javax.swing.JLabel();
        labelLoanType = new javax.swing.JLabel();
        cmbLoanType = new javax.swing.JComboBox();
        labelLoanAmount = new javax.swing.JLabel();
        txtAmountLoan = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        labelEur = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        cmbDurationType = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        labelRate = new javax.swing.JLabel();
        labelRateParent = new javax.swing.JLabel();
        labelRateDirector = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        labelInsuranceRate = new javax.swing.JLabel();
        txtInsuranceRate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelSubtitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSubtitle.setText("Paramètres de la simulation :");

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

        btnCalculate.setText("Modifier");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        labelEur.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEur.setText("€");

        txtDuration.setPreferredSize(new java.awt.Dimension(40, 20));
        txtDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDurationKeyTyped(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTitle.setText("Modifier une simulation");

        cmbDurationType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "année(s)", "mois" }));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRateParent)
                            .addComponent(labelRateDirector)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelInsuranceRate)
                                .addGap(18, 18, 18)
                                .addComponent(txtInsuranceRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLoanAmount)
                                    .addComponent(labelRate)
                                    .addComponent(labelLoanDuration)
                                    .addComponent(labelLoanType))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(cmbDurationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAmountLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelEur))
                                    .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnCalculate)
                                .addGap(45, 45, 45)
                                .addComponent(btnBack))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(labelTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanType)
                    .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDurationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanAmount)
                    .addComponent(txtAmountLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEur))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        if (!(txtDuration.getText().isEmpty() || txtAmountLoan.getText().isEmpty() ||
                txtRate.getText().isEmpty() || txtInsuranceRate.getText().isEmpty())) {
            
            try {
           
                int duration = Integer.parseInt(txtDuration.getText());
                if (cmbDurationType.getSelectedIndex() == 0) { // duration in years
                    duration = duration * 12; // convert years in months
                }
                String loanType = cmbLoanType.getSelectedItem().toString();
                int amount = Integer.parseInt(txtAmountLoan.getText());
                
                if (!((loanType.equals("Prêt à la consommation") || loanType.equals("Prêt automobile")) && 
                        amount > 75000)) {
                    
                    if (!(loanType.equals("Prêt immobilier") && amount < 75000)) {
                        
                        if (!(loanType.equals("Prêt immobilier") && duration < 84)) {
                            
                            Simulation s = new Simulation(simulation.getIdSimulation(), this.client.getIdClient(), 
                                                    amount, duration, Double.parseDouble(txtRate.getText()), 
                                                    Double.parseDouble(txtInsuranceRate.getText()), 
                                                    loanType);

                            TCPClient tcpClient = new TCPClient("localhost",9999);
                            tcpClient.sendQuery("us", edu.hubanato.serialization.EncodeJSON.serializeSimulation(s));
                            String response = tcpClient.receiveQuery();
                            if (response.equals("ok")) {
                                JOptionPane.showMessageDialog(null, "Simulation modifiée");
                                this.setVisible(false);
                                new SimulationManagementForm().setVisible(true);
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
                Logger.getLogger(SimulationUpdateForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.",
                        "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        new SimulationManagementForm().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbLoanTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLoanTypeItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            if (!txtDuration.getText().isEmpty() && !txtAmountLoan.getText().isEmpty()) {
                //update the rates
            }   
        }
    }//GEN-LAST:event_cmbLoanTypeItemStateChanged

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JComboBox cmbDurationType;
    private javax.swing.JComboBox cmbLoanType;
    private javax.swing.JLabel labelEur;
    private javax.swing.JLabel labelInsuranceRate;
    private javax.swing.JLabel labelLoanAmount;
    private javax.swing.JLabel labelLoanDuration;
    private javax.swing.JLabel labelLoanType;
    private javax.swing.JLabel labelRate;
    private javax.swing.JLabel labelRateDirector;
    private javax.swing.JLabel labelRateParent;
    private javax.swing.JLabel labelSubtitle;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtAmountLoan;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtInsuranceRate;
    private javax.swing.JTextField txtRate;
    // End of variables declaration//GEN-END:variables
}
