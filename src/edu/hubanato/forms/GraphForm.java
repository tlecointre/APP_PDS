package edu.hubanato.forms;

import edu.hubanato.controlers.AmortizationCalc;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Tony
 */
public class GraphForm extends javax.swing.JFrame{

    public GraphForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphButton = new javax.swing.JButton();
        amortButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graphButton.setText("Afficher Graph");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        amortButton.setText("Tableau d'amortissement");
        amortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amortButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amortButton)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graphButton)
                    .addComponent(amortButton))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        int leftToPay = 100;
        int totalToPay = 1000;
        int paid = 900;
        
        DefaultPieDataset test = new DefaultPieDataset();
        test.setValue("Reste à payer: "+leftToPay+"E", new Integer(leftToPay));
        test.setValue("Payé: "+paid+"E", new Integer(paid));
        test.setValue("Total: "+totalToPay+"E", new Integer(0));
        JFreeChart chart = ChartFactory.createPieChart("Prêt", test, true, true, true);
        
        DefaultPieDataset test1 = new DefaultPieDataset();
        test1.setValue("Reste à payer: "+leftToPay+"E", new Integer(leftToPay));
        test1.setValue("Payé: "+paid+"E", new Integer(paid));
        test1.setValue("Total: "+totalToPay+"E", new Integer(0));
        JFreeChart chart1 = ChartFactory.createPieChart("Prêt", test1, true, true, true);
        
        ChartPanel pan = new ChartPanel(chart, false);
        pan.setBounds(0, 0, 300, 300);

        ChartPanel pan1 = new ChartPanel(chart1, false);
        pan1.setBounds(350, 0, 300, 300);
        
        this.add(pan);
        this.add(pan1);
        this.graphButton.setVisible(false);
        this.setVisible(true);
        this.setSize(1000,1000);
        
    }//GEN-LAST:event_graphButtonActionPerformed

    private void amortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amortButtonActionPerformed
        //AmortizationCalc am = new AmortizationCalc();
        AmortizationScheduleForm t1 = new AmortizationScheduleForm();
        t1.setVisible(true);
    }//GEN-LAST:event_amortButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amortButton;
    private javax.swing.JButton graphButton;
    // End of variables declaration//GEN-END:variables

}
