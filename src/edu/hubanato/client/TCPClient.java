package edu.hubanato.client;

import java.net.* ;
import java.io.* ;
import java.util.logging.* ;

/**
 * 
 * @author Tom
 */
public class TCPClient {
    
    private Socket sck;
    
    /**
     * Constructor
     * 
     * @param host
     * @param port
     * @throws IOException 
     */
    public TCPClient(String host, int port) throws IOException {
       sck = new Socket(host, port);
    }
    
    /**
     * Send a query to server
     * 
     * @param query_name
     * @param jsonObject 
     */
    public void sendQuery(String query_name, String jsonObject) {
        try {
            PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sck.getOutputStream())),true);

            p.println(query_name + jsonObject);
            System.out.println("TCPClient - sendQuery : " + query_name + jsonObject);
            
        } catch(IOException exc) {
            Logger.global.log(Level.SEVERE,"serveur",exc) ;
        }
    }
    
    /**
     * Receives a query from server
     * @return String
     */
    public String receiveQuery() {
        try {
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sck.getInputStream()));

            String s = inFromServer.readLine();
            System.out.println("TCPClient - receiveQuery : " + s);
            return s;
        } catch(IOException exc) {
            Logger.global.log(Level.SEVERE,"serveur",exc) ;
        }
        return null;
    }

}

