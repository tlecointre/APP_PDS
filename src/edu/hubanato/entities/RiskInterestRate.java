/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

/**
 *
 * @author Nadia Randria
 */
public class RiskInterestRate {

    private String typeLoan;
    private int ageMin, ageMax;
    private String proSituation;
    private int termLoanMin, termLoanMax, persoContribution, debtRatio;

    public RiskInterestRate(String typeLoan, int ageMin, int ageMax, String proSituation, int termLoanMin, int termLoanMax, int persoContribution, int debtRatio) {
        this.typeLoan = typeLoan;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.proSituation = proSituation;
        this.termLoanMin = termLoanMin;
        this.termLoanMax = termLoanMax;
        this.persoContribution = persoContribution;
        this.debtRatio = debtRatio;
    }

    public String viewRisk() {

        String str;

        switch (typeLoan) {
            case "Prêt à la consommation":
                str = "Je suis entrain de déterminer un taux d'intérêt pour un prêt conso";
                break;
            case "Prêt automobile":
                str = "Je suis entrain de déterminer un taux d'intérêt pour un prêt auto";
                break;

            case "Prêt immobilier":
                str = "Je suis entrain de déterminer un taux d'intérêt pour un prêt immo";
                break;
            default:
                str = "Rien à signaler";
                break;

        }
        return str;
    }

}
