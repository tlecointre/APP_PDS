/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pds_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hubanato
 */
public class ServeurInfo {

    public static void main(String[] zero) {

        ServerSocket socketserver;
        Socket socketduserveur;
        BufferedReader in;
        PrintWriter out;

        try {
            //Port in parameter
            socketserver = new ServerSocket(2009);
            System.out.println("Le serveur est à l'écoute du port " + socketserver.getLocalPort());
            socketduserveur = socketserver.accept();
            System.out.println("Un conseiller s'est connecté");
            out = new PrintWriter(socketduserveur.getOutputStream());
            out.println("Vous êtes connecté!");
            out.flush();

            socketduserveur.close();
            socketserver.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}
