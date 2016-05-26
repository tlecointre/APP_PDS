package edu.hubanato.serialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.InterestRate;
import edu.hubanato.entities.RateParentCompany;
import edu.hubanato.entities.Simulation;
import java.util.List;
import java.lang.reflect.Type;


public class DecodeJSON {
    
    private static Gson gson = new Gson();
    
    /**
     * Deserializes a client
     * 
     * @param c
     * @return Client 
     */
    public static Client deserializeClient(String c) {
        System.out.println("DecodeJSON - method deserializeClient " + c);
        return gson.fromJson(c, Client.class);
    }
    
    /**
     * Deserializes a parent company rate
     * 
     * @param r
     * @return RateParentCompany
     */
    public static RateParentCompany deserializeRateParentCompany(String r) {
        System.out.println("DecodeJSON - method deserializeRateParentCompany " + r);
        return gson.fromJson(r, RateParentCompany.class);
    }
    
    /**
     * Deserializes a director rate
     * 
     * @param t
     * @return InterestRate
     */
    public static InterestRate deserializeInterestRate(String t) {
        System.out.println("DecodeJSON - method deserializeInterestRate " + t);
        return gson.fromJson(t, InterestRate.class);
    }
    
    /**
     * Deserializes a list of clients
     * 
     * @param c
     * @return List<Client>
     */
    public static List<Client> deserializeClients(String c) {
        System.out.println("DecodeJSON - method deserializeRateParentClients " + c);
        Type listType = new TypeToken<List<Client>>() {
                    }.getType();
        return gson.fromJson(c, listType);
    }
    
    /**
     * deserializes a simulation
     * 
     * @param s
     * @return Simulation 
     */
    public static Simulation deserializeSimulation(String s) {
        System.out.println("DecodeJSON - method deserializeSimulation " + s);
        return gson.fromJson(s, Simulation.class);
    }
    
    /**
     * deserializes a list of simulation
     * 
     * @param s
     * @return List<Simulation>
     */
    public static List<Simulation> deserializeSimulations(String s) {
        System.out.println("DecodeJSON - method deserializeSimulations " + s);
        Type listType = new TypeToken<List<Simulation>>() {
                    }.getType();
        return gson.fromJson(s, listType);
    }
    
    /**
     * deserializes a list of string
     * 
     * @param s
     * @return List<String>
     */
    public static List<String> deserializeListString(String s) {
        System.out.println("DecodeJSON - method deserializeListString " + s);
        Type listType = new TypeToken<List<String>>() {
                    }.getType();
        return gson.fromJson(s, listType);
    }
    
    /**
     * deserializes a list of Integer
     * 
     * @param s
     * @return int 
     */
    public static int deserializeInteger(String s) {
        System.out.println("DecodeJSON - method deserializeInteger" + s);
        return gson.fromJson(s, Integer.class);
    }
    
    /**
     * deserializes a float
     * 
     * @param s
     * @return float 
     */
    public static float deserializeFloat(String s) {
        System.out.println("DecodeJSON - method deserializeFloat" + s);
        return gson.fromJson(s, Float.class);
    }
}
