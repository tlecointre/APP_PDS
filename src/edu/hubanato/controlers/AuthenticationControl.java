/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.controlers;

import edu.hubanato.forms.AuthenticationAdvisorForm;
import java.awt.event.*;
import javax.swing.*;

/**
 * Release R2
 *
 * @author hubanato
 */
public class AuthenticationControl implements ActionListener {

    private AuthenticationAdvisorForm authentication;
    private JTextField login;
    private JPasswordField password;

    private JButton connect;

    public AuthenticationControl(AuthenticationAdvisorForm authForm, JTextField login, JPasswordField password, JButton connect) {
        this.authentication = authForm;
        this.login = login;
        this.password = password;
        this.connect = connect;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String slogin = "nrandria";
        String spassword = "nrandria";

        if (source == connect) {
            if (login.getText().equals(slogin) && password.getText().equals(spassword)) {
                JOptionPane.showMessageDialog(null, "Login / Password correct");
                
                authentication.setVisible(false);
                

            } else {
                JOptionPane.showMessageDialog(null, "Login / Password must be incorrect");
            }
        }

    }
}
