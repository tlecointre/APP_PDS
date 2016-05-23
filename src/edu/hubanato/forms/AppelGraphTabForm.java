package edu.hubanato.forms;

import edu.hubanato.controlers.AmortizationCalc;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Tony
 */
public class AppelGraphTabForm extends javax.swing.JFrame{

    //DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
    
    public AppelGraphTabForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amortButton = new javax.swing.JButton();
        labelAmount = new javax.swing.JLabel();
        labelDuration = new javax.swing.JLabel();
        labelRate = new javax.swing.JLabel();
        labelInsuranceRate = new javax.swing.JLabel();
        textFieldAmount = new javax.swing.JTextField();
        textFieldDuration = new javax.swing.JTextField();
        textFieldRate = new javax.swing.JTextField();
        textFieldInsuranceRate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        amortButton.setText("Tableau d'amortissement");
        amortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amortButtonActionPerformed(evt);
            }
        });

        labelAmount.setText("Montant:");

        labelDuration.setText("Durée(année):");

        labelRate.setText("Taux:");

        labelInsuranceRate.setText("Assurance:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAmount)
                            .addComponent(labelDuration)
                            .addComponent(labelRate)
                            .addComponent(labelInsuranceRate))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(textFieldDuration)
                            .addComponent(textFieldRate)
                            .addComponent(textFieldInsuranceRate)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(amortButton)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAmount)
                    .addComponent(textFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDuration)
                    .addComponent(textFieldDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRate)
                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInsuranceRate)
                    .addComponent(textFieldInsuranceRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amortButton)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amortButtonActionPerformed
        AmortizationCalc am = new AmortizationCalc(
                Double.parseDouble(this.textFieldAmount.getText()),
                Double.parseDouble(this.textFieldRate.getText()),
                Double.parseDouble(this.textFieldInsuranceRate.getText()),
                Integer.parseInt(this.textFieldDuration.getText()),
                this
        );
        //AmortizationScheduleForm t1 = new AmortizationScheduleForm();
        //t1.setVisible(true);
    }//GEN-LAST:event_amortButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppelGraphTabForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amortButton;
    private javax.swing.JLabel labelAmount;
    private javax.swing.JLabel labelDuration;
    private javax.swing.JLabel labelInsuranceRate;
    private javax.swing.JLabel labelRate;
    private javax.swing.JTextField textFieldAmount;
    private javax.swing.JTextField textFieldDuration;
    private javax.swing.JTextField textFieldInsuranceRate;
    private javax.swing.JTextField textFieldRate;
    // End of variables declaration//GEN-END:variables

}
