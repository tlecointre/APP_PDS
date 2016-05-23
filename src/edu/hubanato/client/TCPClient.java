package edu.hubanato.client;

import java.net.* ;
import java.io.* ;
import java.util.logging.* ;

public class TCPClient {
    
    private Socket sck;
    
    public TCPClient(String host, int port) throws IOException {
       sck = new Socket(host, port);
    }
    
    public void sendQuery(String query_name, String jsonObject) {
        try {
            PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sck.getOutputStream())),true);

            p.println(query_name + jsonObject);
            System.out.println(query_name + jsonObject);
            
        } catch(IOException exc) {
            Logger.global.log(Level.SEVERE,"serveur",exc) ;
        }
    }
    
    public String receiveQuery() {
        try {
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sck.getInputStream()));

            return inFromServer.readLine();
            
        } catch(IOException exc) {
            Logger.global.log(Level.SEVERE,"serveur",exc) ;
        }
        return null;
    }

}

