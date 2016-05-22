package edu.hubanato.serialization;

import com.google.gson.Gson;
import edu.hubanato.entities.Client;
import edu.hubanato.entities.Simulation;

/**
 *
 * @author Baptiste
 */
public class DecodeJSON {
    
    private static Gson gson = new Gson();

    public static Client deserializeClient(String c) {
        return gson.fromJson(c, Client.class);
    }
    
    public static Simulation deserializeSimulation(String s) {
        return gson.fromJson(s, Simulation.class);
    }
}
