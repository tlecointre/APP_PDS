/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

/**
 * This class is used to define all possibilities of scenario
 *
 * @author Nadia Randria
 */
public class RiskInterestRate {

    private String typeLoan;
    private int ageMin, ageMax;
    private String proSituation, persoContribution, debtRatio;
    private int termLoanMin, termLoanMax;

    /**
     * This method permit to retrieve the parameters which define the risks
     *
     * @param typeLoan Type of the loan
     * @param ageMin Age minimum
     * @param ageMax Age maximum
     * @param proSituation Professional situation
     * @param termLoanMin Minimal duration of the loan
     * @param termLoanMax Maximal duration of the loan
     * @param persoContribution Personal contribution
     * @param debtRatio Debt Ratio
     */
    public RiskInterestRate(String typeLoan, int ageMin, int ageMax, String proSituation, int termLoanMin, int termLoanMax, String persoContribution, String debtRatio) {
        this.typeLoan = typeLoan;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.proSituation = proSituation;
        this.termLoanMin = termLoanMin;
        this.termLoanMax = termLoanMax;
        this.persoContribution = persoContribution;
        this.debtRatio = debtRatio;
    }

    /**
     * This method is used to show the risks according the different parameters
     *
     * @param typeLoan Type of the loan
     *
     * @return str List of the risks
     */
    public String viewRisk(String typeLoan) {

        String str = "";

        if (typeLoan.equals("Prêt immobilier")) {
            if ((proSituation.equals("CDD") || proSituation.equals("CDI")) && persoContribution.equals("< 15") && debtRatio.equals("> 33")) {

                if ((ageMin == 18 && ageMax == 25) && (termLoanMin == 7 && termLoanMax == 10)) {
                    str = "(Liste des risques ici)";
                } else if ((ageMin == 18 && ageMax == 25) && (termLoanMin == 16 && termLoanMax == 20)) {
                    str = "(Liste des risques ici)";
                } else {
                    str = "Les risques sont encore à définir";
                }

            } else if (proSituation.equals("CDI") && persoContribution.equals("15 - 20") && debtRatio.equals("30 - 33")) {

                if ((ageMin == 26 && ageMax == 45) && (termLoanMin == 16 && termLoanMax == 20)) {
                    str = "(Liste des risques ici)";
                } else if ((ageMin == 26 && ageMax == 45) && (termLoanMin == 21 && termLoanMax == 25)) {
                    str = "(Liste des risques ici)";
                } else {
                    str = "Les risques sont encore à définir";
                }

            } else if (proSituation.equals("CDI") && persoContribution.equals("20 - 30") && debtRatio.equals("25 - 30")) {

                if ((ageMin == 26 && ageMax == 45) && (termLoanMin == 16 && termLoanMax == 20)) {
                    str = "(Liste des risques ici)";
                } else if ((ageMin == 46 && ageMax == 50) && (termLoanMin == 21 && termLoanMax == 25)) {
                    str = "(Liste des risques ici)";
                } else {
                    str = "Les risques sont encore à définir";
                }

            } else if (proSituation.equals("CDI") && persoContribution.equals("30 >") && debtRatio.equals("< 25")) {

                if ((ageMin == 46 && ageMax == 50) && (termLoanMin == 21 && termLoanMax == 25)) {
                    str = "(Liste des risques ici)";
                } else {
                    str = "Les risques sont encore à définir";
                }

            } else {
                str = "Profil non définie";
            }
        } else if (typeLoan.equals("Prêt à la consommation")) {
            str = "Les risques sont encore à définir";
        } else if (typeLoan.equals("Prêt automobile")) {
            str = "Les risques sont encore à définir";
        }

        return str;
    }

}
