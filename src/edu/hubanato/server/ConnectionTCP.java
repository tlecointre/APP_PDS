package edu.hubanato.server;

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
                    
                    switch (sqlQuery) {
                        case "cs" :
                            Simulation s = edu.hubanato.serialization.DecodeJSON.deserializeSimulation(jsonObject);
                            s.createSimulation();
                            break;
                        default :
                            System.out.println("no query");
                    }
                    
                    //outToClient.writeBytes("");
                } catch (IOException exc) {
                    Logger.global.log(Level.SEVERE,"thread serv",exc) ;
                } catch (SQLException ex) {
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
    

