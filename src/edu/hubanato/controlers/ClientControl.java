/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import edu.hubanato.forms.ClientForm;
import edu.hubanato.forms.GestionClientForm;

/**
 *
 * @author hubanato
 */
public class ClientControl implements ActionListener {
    
    private GestionClientForm gestionClient;
    private JButton btnRedirectCreateClient;
    private JButton btnSearchName;

    private JTable lesClients;
    private JTextField searchName;

    public ClientControl(GestionClientForm gestionClient, JButton btnRedirectCreateClient, JButton btnSearchName, JTable lesClients, JTextField searchName) {
        this.gestionClient = gestionClient;
        this.btnRedirectCreateClient = btnRedirectCreateClient;
        this.btnSearchName = btnSearchName;
        this.lesClients = lesClients;
        this.searchName = searchName;
    }
    

    public ClientControl() {
        
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == btnSearchName) {
            
        } else if (source == btnRedirectCreateClient) {
            //System.out.println("Vous allez créer un client");
            
            gestionClient.setVisible(true);
            
            ClientForm createForm = new ClientForm();
            createForm.setVisible(true);
            
        }
    }

}
