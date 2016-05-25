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

        if(typeLoan == "Prêt à la consommation"){
            
            str = "Prêt à la consommation";
        }
        else if(typeLoan == "Prêt automobile"){
            str = "Prêt automobile";
        }
        else if(typeLoan == "Prêt immobilier"){
            str = "Prêt immobilier";
            
        }
        
        return str;
    }

}
