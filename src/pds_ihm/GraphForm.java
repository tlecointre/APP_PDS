package pds_ihm;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Tony
 */
public class GraphForm extends javax.swing.JFrame {

    public GraphForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphBouton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graphBouton.setText("Afficher Graph");
        graphBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphBoutonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(graphBouton)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(graphBouton)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graphBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphBoutonActionPerformed
        int resteAPayer = 100;
        int totalAPayer = 1000;
        int dejaPaye = 900;
        
        DefaultPieDataset test = new DefaultPieDataset();
        test.setValue("Reste à payer: "+resteAPayer+"E", new Integer(resteAPayer));
        test.setValue("Payé: "+dejaPaye+"E", new Integer(dejaPaye));
        test.setValue("Total: "+totalAPayer+"E", new Integer(0));
        JFreeChart chart = ChartFactory.createPieChart("Prêt", test, true, true, true);
        
        DefaultPieDataset test1 = new DefaultPieDataset();
        test1.setValue("Reste à payer: "+resteAPayer+"E", new Integer(resteAPayer));
        test1.setValue("Payé: "+dejaPaye+"E", new Integer(dejaPaye));
        test1.setValue("Total: "+totalAPayer+"E", new Integer(0));
        JFreeChart chart1 = ChartFactory.createPieChart("Prêt", test1, true, true, true);
        
        ChartPanel pan = new ChartPanel(chart, false);
        pan.setBounds(0, 0, 300, 300);

        ChartPanel pan1 = new ChartPanel(chart1, false);
        pan1.setBounds(350, 0, 300, 300);
        
        this.add(pan);
        this.add(pan1);
        this.setVisible(true);
        this.setSize(1000,1000);
        
    }//GEN-LAST:event_graphBoutonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton graphBouton;
    // End of variables declaration//GEN-END:variables
}
