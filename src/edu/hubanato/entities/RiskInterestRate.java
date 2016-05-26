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
        
        if (typeLoan.equals("Prêt immobilier")){
            if(proSituation.equals("CDD") && persoContribution.equals("< 15") && debtRatio.equals("> 33")){
                str = "Profil médiocre"; 
            }
            else if(proSituation.equals("CDI") && persoContribution.equals("15 - 20") && debtRatio.equals("30 - 33")){
                str = "Profil moyen"; 
            }
            else if(proSituation.equals("CDI") && persoContribution.equals("20 - 30") && debtRatio.equals("25 - 30")){
                str = "Bon profil"; 
            }
            else if(proSituation.equals("CDI") && persoContribution.equals("> 30") && debtRatio.equals("< 25")){
                str = "Excellent profil"; 
            }
            else{
                str = "profil non définie";
            }
        }
        else if (typeLoan.equals("Prêt à la consommation")){
        }
        else if(typeLoan.equals("Prêt automobile")){
        }

        /*switch (typeLoan) {
            case "Prêt à la consommation":
                str = "Prêt à la consommation";
                break;
            case "Prêt automobile":
                str = "Prêt automobile";
                break;
            case "Prêt immobilier":
                if ("CDD".equals(proSituation) && "< 15".equals(persoContribution) && "> 33".equals(debtRatio)) {
                    str = "Profil médiocre";
                } else if ("CDI".equals(proSituation) && "15 - 20".equals(persoContribution) && "30 - 33".equals(debtRatio)) {
                    str = "Profil moyen";
                } else if ("CDI".equals(proSituation) && "20 - 30".equals(persoContribution) && "25 - 30".equals(debtRatio)) {
                    str = "Profil bon";
                } else if ("CDI".equals(proSituation) && "> 30".equals(persoContribution) && "< 25".equals(debtRatio)) {
                    str = "Profil excellent";
                } else {
                    str = "ERREUR";
                }
                break;                
        }*/

        return str;
    }

}
