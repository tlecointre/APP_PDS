package edu.hubanato.controlers;

import edu.hubanato.forms.AmortizationScheduleForm;
import java.text.DecimalFormat;

public class AmortizationCalc {

    public static void main(String[] args) {
        double amount, taux;
        int nbyear;
        amount = 10000;
        taux = 10;
        nbyear = 2;
        
        AmortizationScheduleForm t1 = new AmortizationScheduleForm();
        t1.setVisible(true);
        calAmort(amount, taux, nbyear,t1);

    }

    public static void calAmort(double amount, double iy, int ny, AmortizationScheduleForm t1) {
        double newAmount;
        double im = (iy / 12) / 100;
        int nbMonth = ny * 12;
        double monthlyPayment, interestPaid, principalPaid;
        int i;
        DecimalFormat df = new DecimalFormat("########.000"); 
        monthlyPayment = amount * im * Math.pow(1 + im, (double) nbMonth) / (Math.pow(1 + im, (double) nbMonth) - 1);
        //print amortization schedule for all months except the last month
        for (i = 1; i < nbMonth; i++) {
            interestPaid = amount * im;//interest paid
            principalPaid = monthlyPayment - interestPaid; //princial paid
            newAmount = amount - principalPaid; //new balance                 
            t1.getTable().setValueAt(i, i-1, 0);
            t1.getTable().setValueAt(df.format(principalPaid), i-1, 1);
            t1.getTable().setValueAt(df.format(interestPaid), i-1, 2);
            t1.getTable().setValueAt(df.format(newAmount), i-1, 3);
            t1.getTable().setValueAt(0, i-1, 4);
            t1.getTable().setValueAt(df.format(monthlyPayment), i-1, 5);
            amount = newAmount;  //update old balance
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
