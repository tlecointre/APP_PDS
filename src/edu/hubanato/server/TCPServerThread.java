package edu.hubanato.server;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public abstract class TCPServerThread {
    
    private ServerSocket srv;
    
    /**
     * Constructor
     * @param port
     * @throws IOException 
     */
    public TCPServerThread(int port) throws IOException {
        this.srv = new ServerSocket(port);
    }
    
    /**
     * launches a multi-threading process
     * @throws IOException 
     */
    public void go() throws IOException {

        ThreadGroup thg = new ThreadGroup("server"){
            public void uncaughtException(Thread t, Throwable e) {
                Logger.global.log(Level.SEVERE,t.toString(), e);
            }
        };
       
        while (true) {
            Socket sck = srv.accept();
            new Thread(thg, launchSession(sck)).start();
        }
        
    }
    
    public abstract Runnable launchSession(Socket sck);
    
    
}