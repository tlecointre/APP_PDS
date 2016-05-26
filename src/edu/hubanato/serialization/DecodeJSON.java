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

    public static Client deserializeClient(String c) {
        return gson.fromJson(c, Client.class);
    }
    
    public static RateParentCompany deserializeRateParentCompany(String c) {
        return gson.fromJson(c, RateParentCompany.class);
    }
    
    public static InterestRate deserializeInterestRate(String c) {
        return gson.fromJson(c, InterestRate.class);
    }
    
    public static List<Client> deserializeClients(String c) {
        Type listType = new TypeToken<List<Client>>() {
                    }.getType();
        return gson.fromJson(c, listType);
    }
    
    public static Simulation deserializeSimulation(String s) {
        return gson.fromJson(s, Simulation.class);
    }
    
    public static List<Simulation> deserializeSimulations(String s) {
        Type listType = new TypeToken<List<Simulation>>() {
                    }.getType();
        return gson.fromJson(s, listType);
    }
    
    public static List<String> deserializeListString(String s) {
        Type listType = new TypeToken<List<String>>() {
                    }.getType();
        return gson.fromJson(s, listType);
    }
    
    public static int deserializeInteger(String s) {
        return gson.fromJson(s, Integer.class);
    }
    
    public static float deserializeFloat(String s) {
        return gson.fromJson(s, Float.class);
    }
}
