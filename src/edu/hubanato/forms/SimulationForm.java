package edu.hubanato.forms;

import edu.hubanato.entities.Client;
import edu.hubanato.entities.Simulation;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelLoanDuration)
                                .addGap(18, 18, 18)
                                .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTypeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelLoanAmount)
                                .addGap(35, 35, 35)
                                .addComponent(txtAmountLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelEuro))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLoanType)
                                    .addComponent(labelClient))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSelectedClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitle)
                            .addComponent(labelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalculate))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(labelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelClient)
                    .addComponent(labelSelectedClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanType)
                    .addComponent(cmbLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoanDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTypeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEuro)
                            .addComponent(labelLoanAmount)
                            .addComponent(txtAmountLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(138, 138, 138))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnCalculate)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        int duration = Integer.parseInt(txtDuration.getText());
        if (cmbTypeDuration.getSelectedIndex() == 0) { // duration in years
            duration = duration * 12; // convert years in months
        }
        Simulation s = new Simulation(-1, this.client.getIdClient(), Integer.parseInt(txtAmountLoan.getText()),
                                        duration, 4.5, cmbLoanType.getSelectedItem().toString());
        try {
            s.createSimulation();
        } catch (SQLException ex) {
            Logger.getLogger(SimulationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        new LoanSummaryForm(s.getAmount(), duration, s.getRate(), s.getLoanType()).setVisible(true);
    }//GEN-LAST:event_btnCalculateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimulationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JComboBox cmbLoanType;
    private javax.swing.JComboBox cmbTypeDuration;
    private javax.swing.JLabel labelClient;
    private javax.swing.JLabel labelEuro;
    private javax.swing.JLabel labelLoanAmount;
    private javax.swing.JLabel labelLoanDuration;
    private javax.swing.JLabel labelLoanType;
    private javax.swing.JLabel labelParameters;
    private javax.swing.JLabel labelSelectedClient;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtAmountLoan;
    private javax.swing.JTextField txtDuration;
    // End of variables declaration//GEN-END:variables
}
