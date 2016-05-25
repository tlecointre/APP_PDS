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

    private float interestRate;
    private String typeLoan;
    private int ageMin, ageMax;
    private String proSituation, persoContribution, debtRatio;
    private int termLoanMin, termLoanMax;

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

    public String viewRisk(String typeLoan) {

        String str = "";

        switch (typeLoan) {
            case "Prêt à la consommation":
                str = "Prêt à la consommation";
                break;
            case "Prêt automobile":
                str = "Prêt automobile";
                break;
            case "Prêt immobilier":
                if ("CDD".equals(proSituation) && "< 15".equals(persoContribution) && "> 33".equals(debtRatio) && (termLoanMin > 20 || termLoanMax > 20)) {
                    str = "Profil médiocre";
                }
                else if ("CDI".equals(proSituation) && "15 - 20".equals(persoContribution) && "30 - 33".equals(debtRatio) && (termLoanMax == 15 || (termLoanMin > 15 && termLoanMax == 20))) {
                    str = "Profil moyen";
                }
                else if ("CDI".equals(proSituation) && "20 - 30".equals(persoContribution) && "25 - 30".equals(debtRatio) && (termLoanMin >=10 && termLoanMax == 15)) {
                    str = "Profil bon";            
                }
                else if ("CDI".equals(proSituation) && "> 30".equals(persoContribution) && "< 25".equals(debtRatio) && (termLoanMin == 7 && termLoanMax <= 10)) {
                    str = "Profil excellent";            
                }
                break;
        }

        return str;
    }

}
