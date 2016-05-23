package edu.hubanato.server;

import edu.hubanato.entities.Client;
import edu.hubanato.entities.Simulation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
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
    
    public ConnectionTCP(int port) throws IOException {
        super(port);
    }
    
    public Runnable launchSession(final Socket sck) {
        
        return new Runnable () {
            public void run() {
                String clientSentence;
                
                try {
                    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sck.getInputStream()));
                    //DataOutputStream outToClient = new DataOutputStream(sck.getOutputStream());
                    
                    clientSentence = inFromClient.readLine();
                    
                    System.out.println("Received: " + clientSentence);
                    
                    String sqlQuery = clientSentence.substring(0,2);
                    String jsonObject = clientSentence.substring(2);
                    Simulation s; Client c;
                    List<Simulation> simulations; List<Client> clients;
                    
                    switch (sqlQuery) {
                        case "cs" : // create simulation
                            s = edu.hubanato.serialization.DecodeJSON.deserializeSimulation(jsonObject);
                            s.createSimulation();
                            break;
                        case "us" : // update simulation
                            s = edu.hubanato.serialization.DecodeJSON.deserializeSimulation(jsonObject);
                            s.updateSimulation();
                            break;
                        case "gs" : // get simulation by id client
                            // RECUP idClient
                            // simulations = Simulation.getbyClient(idClient);
                            // String s = edu.hubanato.serialization.DecodeJSON.serializeClients(jsonObject);
                            // envoyer s au client
                            break;
                        case "cc" : // create client
                            c = edu.hubanato.serialization.DecodeJSON.deserializeClient(jsonObject);
                            c.createPerson();
                            break;
                        case "gc" : // get client by name and first name and postal code
                            // RECUP name et first name et postal code
                            // clients = Client.getByNamePC(name, firstname, postalcode);
                            // String s = edu.hubanato.serialization.DecodeJSON.serializeClients(jsonObject);
                            //  envoyer s au client
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
    

