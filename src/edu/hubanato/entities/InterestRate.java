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
public class InterestRate {

    private int idIntrate, idTypeLoan;
    private int interestRate;
    private int ageMin, ageMax;
    private int durationMin, durationMax;
    private String proSituation;
    private int debtRatio;

    public InterestRate(int idTypeLoan, int interestRate, int ageMin, int ageMax, int durationMax, String proSituation, int debtRatio) {
        this.idTypeLoan = idTypeLoan;
        this.interestRate = interestRate;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.durationMax = durationMax;
        this.proSituation = proSituation;
        this.debtRatio = debtRatio;
    }

    public void SaveInterestRate() {
    }

}
