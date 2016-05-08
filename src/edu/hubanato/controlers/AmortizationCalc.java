package edu.hubanato.controlers;

import edu.hubanato.forms.AmortizationScheduleForm;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AmortizationCalc {

    private DefaultTableModel tab;
    
    public AmortizationCalc(AmortizationScheduleForm t1) {
        double amount, taux;
        int nbYear;
        amount = 10000; //à modifier avec la BDD
        taux = 10; //à modifier avec la BDD
        nbYear = 2; //à modifier avec la BDD
        
//        AmortizationScheduleForm t1 = new AmortizationScheduleForm();
//        t1.setVisible(true);
        calAmort(amount, taux, nbYear,t1);

    }

    public void calAmort(double amount, double interest, int nbYear, AmortizationScheduleForm t1) {
        double newAmount;
        double monthlyInterest = (interest / 12) / 100;
        int nbMonth = nbYear * 12;
        double monthlyPayment, interestPaid, principalPaid;
        int i;
        DecimalFormat df = new DecimalFormat("########.000"); 
        tab = (DefaultTableModel)t1.getTable().getModel();
        //Formule de calcul des mensualités
        monthlyPayment = amount * monthlyInterest * Math.pow(1 + monthlyInterest, (double) nbMonth) / (Math.pow(1 + monthlyInterest, (double) nbMonth) - 1);
       
        for (i = 1; i < nbMonth; i++) {
            interestPaid = amount * monthlyInterest;//Intérêt du mois
            principalPaid = monthlyPayment - interestPaid; //Mensualité sans intérêt
            newAmount = amount - principalPaid; //Restant à payer
            tab.addRow(new String[]{Integer.toString(i),df.format(principalPaid),df.format(interestPaid),df.format(newAmount),df.format(0),df.format(monthlyPayment)});
            amount = newAmount;  //On met le nouveau montant comme montant principal
        }
        //Dernier mois
        principalPaid = amount;
        interestPaid = amount * monthlyInterest;
        monthlyPayment = principalPaid + interestPaid;
        newAmount = 0.0;
        tab.addRow(new String[]{Integer.toString(i),df.format(principalPaid),df.format(interestPaid),df.format(newAmount),df.format(0),df.format(monthlyPayment)});
    }
    
    public DefaultTableModel getTableModel(){
        return tab;
    }

}
