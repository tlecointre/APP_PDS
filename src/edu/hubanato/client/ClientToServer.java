/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author Nadia Randria
 */
public class ClientToServer {

    public static void main(String[] zero) {

        Socket socket;
        BufferedReader in;
        PrintWriter out;

        try {

            socket = new Socket(InetAddress.getLocalHost(), 2009);
            System.out.println("Demande de connexion");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message_distant = in.readLine();
            System.out.println(message_distant);

            socket.close();

        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
