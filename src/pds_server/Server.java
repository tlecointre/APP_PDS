package pds_server;

import java.net.*;
import java.io.IOException;

public class Server {

    public static void main(String[] args){
		
	ServerSocket socket;
	try {
	socket = new ServerSocket(5678);
	Thread t = new Thread(new LancerServeur(socket));
	t.start();
	System.out.println("Serveur lancé");
        
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
}

class LancerServeur implements Runnable {

    private ServerSocket socketserver;
    private Socket socket;
    private int nbrclient = 1;
    
    public LancerServeur(ServerSocket s){
	socketserver = s;
    }

    public void run() {

        try {
            while(true){
                socket = socketserver.accept();
	        System.out.println(nbrclient+ " connecté");
	        nbrclient++;
	        socket.close();
	    }
	        
	} catch (IOException e) {
	}
    }
}