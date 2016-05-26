package edu.hubanato.server;

import edu.hubanato.entities.Client;
import edu.hubanato.entities.InterestRate;
import edu.hubanato.entities.RateParentCompany;
import edu.hubanato.entities.Simulation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class ConnectionTCP extends TCPServerThread {
    
    /**
     * Default constructor
     * @param port
     * @throws IOException 
     */
    public ConnectionTCP(int port) throws IOException {
        super(port);
    }
    
    /**
     * Following the query received by the client, communicate with the database
     * 
     * @param sck
     * @return Runnable
     */
    public Runnable launchSession(final Socket sck) {
        
        return new Runnable () {
            public void run() {
                String clientSentence;
                
                try {
                    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sck.getInputStream()));
                    PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sck.getOutputStream())),true);

                    clientSentence = inFromClient.readLine();
                    
                    System.out.println("Received: " + clientSentence);
                    
                    String sqlQuery = clientSentence.substring(0,2); // prefix to identify the query
                    String jsonObject = clientSentence.substring(2);
                    Simulation s; Client c;
                    List<Simulation> simulations; List<Client> clients;
                    InterestRate t; RateParentCompany r;
                    
                    switch (sqlQuery) {
                        case "cs" : // create simulation
                            s = edu.hubanato.serialization.DecodeJSON.deserializeSimulation(jsonObject);
                            s.createSimulation();
                            p.println("ok");
                            break;
                        case "us" : // update simulation
                            s = edu.hubanato.serialization.DecodeJSON.deserializeSimulation(jsonObject);
                            s.updateSimulation();
                            p.println("ok");
                            break;
                        case "gs" : // get simulation by id client
                            int idClient = edu.hubanato.serialization.DecodeJSON.deserializeInteger(jsonObject);
                            simulations = Simulation.getByClient(idClient);
                            String simulationsJson = edu.hubanato.serialization.EncodeJSON.serializeSimulations(simulations);
                            p.println(simulationsJson);
                            break;
                        case "cc" : // create client
                            c = edu.hubanato.serialization.DecodeJSON.deserializeClient(jsonObject);
                            c.createPerson();
                            p.println("ok");
                            break;
                        case "gc" : // get client by name and first name and postal code
                            List<String> client = edu.hubanato.serialization.DecodeJSON.deserializeListString(jsonObject);
                            clients = Client.getByNamePC(client.get(0), client.get(1), client.get(2));
                            String clientsJson = edu.hubanato.serialization.EncodeJSON.serializeClients(clients);
                            p.println(clientsJson);
                            break;
                        case "ct" : // save the interest rate
                            t = edu.hubanato.serialization.DecodeJSON.deserializeInterestRate(jsonObject);
                            t.saveInterestRate();
                            p.println("ok");
                            break;   
                        case "dr" : // get directory rate
                            List<String> info = edu.hubanato.serialization.DecodeJSON.deserializeListString(jsonObject);
                            float i = InterestRate.getRate(Integer.parseInt(info.get(0)), Integer.parseInt(info.get(1)), info.get(2));
                            System.out.println("ConnectionTCP - case pr : " + i);
                            String rateJson = edu.hubanato.serialization.EncodeJSON.serializeFloat(i);
                            p.println(rateJson);
                            break;
                        case "pr" : // get parent company rate    
                            List<String> infoRate = edu.hubanato.serialization.DecodeJSON.deserializeListString(jsonObject);
                            float pcr = RateParentCompany.getRate(Integer.parseInt(infoRate.get(0)), infoRate.get(1));
                            System.out.println("ConnectionTCP - case pr : " + pcr);
                            String rate = edu.hubanato.serialization.EncodeJSON.serializeFloat(pcr);
                            p.println(rate);
                            break;
                        default :
                            System.out.println("no query");
                    }
                    
                    //outToClient.writeBytes("");
                } catch (IOException exc) {
                    Logger.global.log(Level.SEVERE,"thread serv",exc) ;
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }
    
    public static void main(String args[]) throws Exception {
        //ConnectionTCP c = new ConnectionTCP(Integer.parseInt(args[0]));
        ConnectionTCP c = new ConnectionTCP(9999); //test
        c.go();
              
    }

    
}
    

