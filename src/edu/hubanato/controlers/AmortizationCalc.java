package edu.hubanato.controlers;

import edu.hubanato.forms.AmortizationScheduleForm;
import edu.hubanato.forms.GraphForm;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class AmortizationCalc {

    private DefaultTableModel tab;
    private DecimalFormat df = new DecimalFormat("########.00");
    AmortizationScheduleForm t1;
    
    //public AmortizationCalc(AmortizationScheduleForm t1) {
    public AmortizationCalc(double amount, double rate, double insuranceRate, int nbYear, GraphForm g) {
        /*double amount, rate, insuranceRate;
        int nbYear;
        amount = 10000; //à modifier avec la BDD
        rate = 10; //à modifier avec la BDD
        nbYear = 2; //à modifier avec la BDD
        insuranceRate = 1;*/
        t1 = new AmortizationScheduleForm();
        t1.setVisible(true);
        //calAmort(amount, rate, insuranceRate,nbYear,t1);
        calAmort(amount, rate, insuranceRate,nbYear, g);

    }

    //public void calAmort(double amount, double interestRate, double insuranceRate,int nbYear, AmortizationScheduleForm t1) {
    public void calAmort(double amount, double interestRate, double insuranceRate,int nbYear, GraphForm g) { 
        double newAmount;
        double monthlyInterest = (interestRate / 12) / 100;
        int nbMonth = nbYear * 12;
        double monthlyPayment, interestPaid, principalPaid;
        double insurance = amount * (insuranceRate / 100);
        int i; 
        tab = (DefaultTableModel)t1.getTable().getModel();
        //t1.getLabelAMount().setText(t1.getLabelAMount().getText()+ df.format(amount) +" Euros");
        updateLabel(amount, nbMonth, interestRate, insuranceRate, t1);
        //Formule de calcul des mensualités
        monthlyPayment = amount * monthlyInterest * Math.pow(1 + monthlyInterest, (double) nbMonth) / (Math.pow(1 + monthlyInterest, (double) nbMonth) - 1);
       
        for (i = 1; i < nbMonth; i++) {
            interestPaid = amount * monthlyInterest;//Intérêt du mois
            principalPaid = monthlyPayment - interestPaid; //Mensualité sans intérêt
            newAmount = amount - principalPaid; //Restant à payer
            tab.addRow(new String[]{Integer.toString(i),df.format(principalPaid),df.format(interestPaid),df.format(newAmount),df.format(monthlyPayment),df.format(insurance),df.format(monthlyPayment+insurance)});
            amount = newAmount;  //On met le nouveau montant comme montant principal
            t1.insertData(amount, nbMonth);
        }
        //Dernier mois
        principalPaid = amount;
        interestPaid = amount * monthlyInterest;
        monthlyPayment = principalPaid + interestPaid;
        newAmount = 0.0;
        tab.addRow(new String[]{Integer.toString(i),df.format(principalPaid),df.format(interestPaid),df.format(newAmount),df.format(monthlyPayment),df.format(insurance),df.format(monthlyPayment+insurance)});
    }

    public void updateLabel(double amount, int nbMonth, double interestRate, double insuranceRate, AmortizationScheduleForm t1){
        t1.getLabelAMount().setText(t1.getLabelAMount().getText()+ df.format(amount) +" Euros");
        t1.getLabelDuration().setText(t1.getLabelDuration().getText()+ nbMonth +" Mois");
        t1.getLabelInsurance().setText(t1.getLabelInsurance().getText()+df.format(insuranceRate)+" %");
        t1.getLabelRate().setText(t1.getLabelRate().getText()+df.format(interestRate)+" %");
    }
}
