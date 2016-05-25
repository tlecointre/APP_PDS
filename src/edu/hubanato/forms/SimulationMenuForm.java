package edu.hubanato.forms;

/**
 *
 * @author Tom
 */
public class SimulationMenuForm extends javax.swing.JFrame {

    /**
     * Creates new form SimulationMenuForm
     */
    public SimulationMenuForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSimulation = new javax.swing.JLabel();
        btnCreateSimulation = new javax.swing.JButton();
        btnSimulationManagement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulation");

        labelSimulation.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelSimulation.setForeground(new java.awt.Color(0, 51, 102));
        labelSimulation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSimulation.setText("Simulation");

        btnCreateSimulation.setText("Simulation d'un prêt à taux fixe");
        btnCreateSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateSimulationActionPerformed(evt);
            }
        });

        btnSimulationManagement.setText("Gestion de simulation");
        btnSimulationManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimulationManagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSimulationManagement, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateSimulation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(160, Short.MAX_VALUE))
            .addComponent(labelSimulation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateSimulation)
                .addGap(18, 18, 18)
                .addComponent(btnSimulationManagement)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Start of AuthenticationClientForm
     * @param evt 
     */
    private void btnCreateSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateSimulationActionPerformed
        this.setVisible(false);
        new AuthenticationClientForm().setVisible(true);
    }//GEN-LAST:event_btnCreateSimulationActionPerformed
    
    /**
     * Start of SimulationManagementForm
     * @param evt 
     */
    private void btnSimulationManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulationManagementActionPerformed
        this.setVisible(false);
        new SimulationManagementForm().setVisible(true);
    }//GEN-LAST:event_btnSimulationManagementActionPerformed

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
            java.util.logging.Logger.getLogger(SimulationMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationMenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateSimulation;
    private javax.swing.JButton btnSimulationManagement;
    private javax.swing.JLabel labelSimulation;
    // End of variables declaration//GEN-END:variables
}
