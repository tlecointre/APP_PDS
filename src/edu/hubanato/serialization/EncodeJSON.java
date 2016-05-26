package edu.hubanato.serialization;

import com.google.gson.Gson;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.InterestRate;
import edu.hubanato.entities.RateParentCompany;
import edu.hubanato.entities.Simulation;
import java.util.List;

public class EncodeJSON {
    
    private static Gson gson = new Gson();
    
    /**
     * Serializes a client
     * 
     * @param c
     * @return String 
     */
    public static String serializeClient(Client c) {
        return gson.toJson(c);
    }
    
    /**
     * Serializes a parent company rate
     * 
     * @param r
     * @return String
     */
    public static String serializeRateParentCompany(RateParentCompany r) {
        System.out.println("EncodeJSON - method serializeRateParentCompany" + r);
        return gson.toJson(r);
    }
    
    /**
     * Serializes an interest rate
     * 
     * @param t
     * @return String 
     */
    public static String serializeInterestRate(InterestRate t) {
        System.out.println("EncodeJSON - method serializeInterestRate" + t);
        return gson.toJson(t);
    }
    
    /**
     * Serializes a list of clients
     * 
     * @param c
     * @return String 
     */
    public static String serializeClients(List<Client> c) {
        System.out.println("EncodeJSON - method serializeClients" + c);
        return gson.toJson(c);
    }
    
    /**
     * Serializes a simulation
     * 
     * @param s
     * @return String
     */
    public static String serializeSimulation(Simulation s) {
        System.out.println("EncodeJSON - method serializeSimulation" + s);
        return gson.toJson(s);
    }
    
    /**
     * Serializes a list of simulations
     * 
     * @param s
     * @return String
     */
    public static String serializeSimulations(List<Simulation> s) {
        System.out.println("EncodeJSON - method serializeSimulations" + s);
        return gson.toJson(s);
    }
    
    /**
     * Serializes a list of String
     * 
     * @param s
     * @return String
     */
    public static String serializeListString(List<String> s) {
        System.out.println("EncodeJSON - method serializeListString" + s);
        return gson.toJson(s);
    }
    
    /**
     * Serializes an int
     * 
     * @param s
     * @return String
     */
    public static String serializeInteger(int s) {
        System.out.println("EncodeJSON - method serializeInteger" + s);
        return gson.toJson(s);
    }
    
    /**
     * Serializes a float
     * 
     * @param s
     * @return String 
     */
    public static String serializeFloat(float s) {
        System.out.println("EncodeJSON - method serializeFloat" + s);
        return gson.toJson(s);
    }
}
