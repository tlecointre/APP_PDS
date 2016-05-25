package edu.hubanato.controlers;

import edu.hubanato.forms.AmortizationScheduleForm;

import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 * This class is used to calculate the different values of the schedule
 * @author Tony
 */
public class AmortizationCalc {

    private DefaultTableModel tab;
    private DecimalFormat df = new DecimalFormat("########.00");
    AmortizationScheduleForm t1;

    /**
     * The constructor initializes the AmortizationScheduleForm and launches the calcul
     * @param amount
        * The amount of the loan
     * @param rate
        * The rate of the loan
     * @param insuranceRate
        * The insurance rate
     * @param nbMonth 
        * The duration of the loan in month
     */
    public AmortizationCalc(double amount, double rate, double insuranceRate, int nbMonth) {
        t1 = new AmortizationScheduleForm();
        t1.setVisible(true);
        calAmort(amount, rate, insuranceRate, nbMonth);

    }

    /**
     * This method is used to calculate the different values of the schedule
     * @param amount
        * The amount of the loan
     * @param interestRate
        * The rate of the loan
     * @param insuranceRate
        * The insurance rate
     * @param nbMonth 
        * The duration of the loan in month
     */
    public void calAmort(double amount, double interestRate, double insuranceRate, int nbMonth) {
        double newAmount;
        double monthlyInterest = (interestRate / 12) / 100;
        double monthlyPayment, interestPaid, principalPaid;
        double insurance = amount * (insuranceRate / 100) / 12;
        double amountAlreadyPaid = 0, insuranceAlreadyPaid = 0, interestAlreadyPaid = 0;
        int i;
        tab = (DefaultTableModel) t1.getTable().getModel();
        updateLabelInfo(amount, nbMonth, interestRate, insuranceRate, t1);
        
        //Monthly calculation formula
        monthlyPayment = amount * monthlyInterest * Math.pow(1 + monthlyInterest, (double) nbMonth) / (Math.pow(1 + monthlyInterest, (double) nbMonth) - 1);

        for (i = 1; i < nbMonth; i++) {
            interestPaid = amount * monthlyInterest;//Month interest
            principalPaid = monthlyPayment - interestPaid; //Monthly without interest
            newAmount = amount - principalPaid; //Still to pay
            amountAlreadyPaid += principalPaid; //Amount already paid
            interestAlreadyPaid += interestPaid; //Interest already paid
            insuranceAlreadyPaid += insurance; //Insurance already paid
            tab.addRow(new String[]{Integer.toString(i), df.format(principalPaid), df.format(interestPaid), df.format(newAmount), df.format(monthlyPayment), df.format(insurance), df.format(monthlyPayment + insurance)});
            if (i % 12 == 0) {
                t1.insertDataToBarChartGlobal(amountAlreadyPaid, "Montant", i);
                t1.insertDataToBarChartGlobal(insuranceAlreadyPaid, "Assurance", i);
                t1.insertDataToBarChartGlobal(interestAlreadyPaid, "Interêt", i);
            }
            amount = newAmount;  //On met le nouveau montant comme montant principal
            if (i % 12 == 0) {
                t1.insertDataToLineChartAmount(newAmount, i);
            }
            System.out.println("amount:" + amount + " new amount:" + newAmount);
        }
        //Last month
        principalPaid = amount;
        interestPaid = amount * monthlyInterest;
        monthlyPayment = principalPaid + interestPaid;
        newAmount = 0.0;
        amountAlreadyPaid += principalPaid;
        interestAlreadyPaid += interestPaid;
        insuranceAlreadyPaid += insurance;
        updateLabelResult(interestAlreadyPaid, insuranceAlreadyPaid, amountAlreadyPaid + interestAlreadyPaid);
        t1.insertDataToPieChartGlobal("Montant", amountAlreadyPaid);
        t1.insertDataToPieChartGlobal("Intérêt", interestAlreadyPaid);
        t1.insertDataToPieChartGlobal("Assurance", insuranceAlreadyPaid);
        t1.insertDataToLineChartAmount(newAmount, i);
        t1.insertDataToBarChartGlobal(amountAlreadyPaid, "Montant", i);
        t1.insertDataToBarChartGlobal(insuranceAlreadyPaid, "Assurance", i);
        t1.insertDataToBarChartGlobal(interestAlreadyPaid, "Interêt", i);
        tab.addRow(new String[]{Integer.toString(i), df.format(principalPaid), df.format(interestPaid), df.format(newAmount), df.format(monthlyPayment), df.format(insurance), df.format(monthlyPayment + insurance)});
    }

    /**
     * This method is used to refresh the different labels used in the form for the loan information
     * @param amount
     * @param nbMonth
     * @param interestRate
     * @param insuranceRate
     * @param t1 
     */
    public void updateLabelInfo(double amount, int nbMonth, double interestRate, double insuranceRate, AmortizationScheduleForm t1) {
        t1.getLabelAMount().setText(t1.getLabelAMount().getText() + df.format(amount) + " Euros");
        t1.getLabelDuration().setText(t1.getLabelDuration().getText() + nbMonth + " Mois");
        t1.getLabelInsurance().setText(t1.getLabelInsurance().getText() + df.format(insuranceRate) + " %");
        t1.getLabelRate().setText(t1.getLabelRate().getText() + df.format(interestRate) + " %");
    }

    /**
     * This method is used to refresh the different labels used in the form for the loan results
     * @param totalInterest
     * @param totalInsurance
     * @param totalWithoutInsurance 
     */
    public void updateLabelResult(double totalInterest, double totalInsurance, double totalWithoutInsurance) {
        t1.getLabelTotalInsurance().setText(t1.getLabelTotalInsurance().getText() + df.format(totalInsurance) + " Euros");
        t1.getLabelTotalInterest().setText(t1.getLabelTotalInterest().getText() + df.format(totalInterest) + " Euros");
        t1.getLabelTotalWithoutInterest().setText(t1.getLabelTotalWithoutInterest().getText() + df.format(totalWithoutInsurance) + " Euros");
    }
}
