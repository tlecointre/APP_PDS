package pds_sclient;

import java.io.IOException;
import java.net.*;

public class Client {
    
    public Client(){
        Socket socket;
	try {
            socket = new Socket("localhost",5678);
            socket.close();
	} catch (IOException e) {
	}
    }
    
}
