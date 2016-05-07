package edu.hubanato.controlers;

import edu.hubanato.forms.AmortizationScheduleForm;
import java.text.DecimalFormat;

public class AmortizationCalc {

    public static void main(String[] args) {
        double amount, taux;
        int nbYear;
        amount = 10000; //à modifier avec la BDD
        taux = 10; //à modifier avec la BDD
        nbYear = 2; //à modifier avec la BDD
        
        AmortizationScheduleForm t1 = new AmortizationScheduleForm();
        t1.setVisible(true);
        calAmort(amount, taux, nbYear,t1);

    }

    public static void calAmort(double amount, double interest, int nbYear, AmortizationScheduleForm t1) {
        double newAmount;
        double im = (interest / 12) / 100;
        int nbMonth = nbYear * 12;
        double monthlyPayment, interestPaid, principalPaid;
        int i;
        DecimalFormat df = new DecimalFormat("########.000"); 
        
        //Formule de calcul des mensualités
        monthlyPayment = amount * im * Math.pow(1 + im, (double) nbMonth) / (Math.pow(1 + im, (double) nbMonth) - 1);
       
        for (i = 1; i < nbMonth; i++) {
            interestPaid = amount * im;//Intérêt du mois
            principalPaid = monthlyPayment - interestPaid; //Mensualité sans intérêt
            newAmount = amount - principalPaid; //Restant à payer               
            t1.getTable().setValueAt(i, i-1, 0);
            t1.getTable().setValueAt(df.format(principalPaid), i-1, 1);
            t1.getTable().setValueAt(df.format(interestPaid), i-1, 2);
            t1.getTable().setValueAt(df.format(newAmount), i-1, 3);
            t1.getTable().setValueAt(0, i-1, 4);
            t1.getTable().setValueAt(df.format(monthlyPayment), i-1, 5);
            amount = newAmount;  //On met le nouveau montant comme montant principal
        }
        //last month
        principalPaid = amount;
        interestPaid = amount * im;
        monthlyPayment = principalPaid + interestPaid;
        newAmount = 0.0;
        t1.getTable().setValueAt(i, i-1, 0);
        t1.getTable().setValueAt(df.format(principalPaid), i-1, 1);
        t1.getTable().setValueAt(df.format(interestPaid), i-1, 2);
        t1.getTable().setValueAt(df.format(newAmount), i-1, 3);
        t1.getTable().setValueAt(0, i-1, 4);
        t1.getTable().setValueAt(df.format(monthlyPayment), i-1, 5);

    }

}
