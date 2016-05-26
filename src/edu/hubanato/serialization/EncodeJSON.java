package edu.hubanato.serialization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.InterestRate;
import edu.hubanato.entities.RateParentCompany;
import edu.hubanato.entities.Simulation;
import java.util.List;

public class EncodeJSON {
    
    private static Gson gson = new Gson();
    
    public static String serializeClient(Client c) {
        return gson.toJson(c);
    }
    
    public static String serializeRateParentCompany(RateParentCompany r) {
        return gson.toJson(r);
    }
    
    public static String serializeInterestRate(InterestRate r) {
        return gson.toJson(r);
    }
    
    public static String serializeClients(List<Client> c) {
        return gson.toJson(c);
    }
    
    public static String serializeSimulation(Simulation s) {
        return gson.toJson(s);
    }
    
    public static String serializeSimulations(List<Simulation> s) {
        return gson.toJson(s);
    }
    
    public static String serializeListString(List<String> s) {
        return gson.toJson(s);
    }
    
    public static String serializeInteger(int s) {
        return gson.toJson(s);
    }
    
    public static String serializeFloat(float s) {
        return gson.toJson(s);
    }
}
