package edu.hubanato.controlers;

import edu.hubanato.client.TCPClient;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import edu.hubanato.entities.Client;
import java.io.IOException;
import org.jdesktop.swingx.JXDatePicker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tom
 */
public class ClientControl implements ActionListener {

    //Client
    private Client client;

    private JComboBox civility, sex, nationality, country, profession;
    
    private JXDatePicker birthDate;

    private JTextField name, firstName, birthPlace, nb, street, add, cp, city;

    private JTextField pnumber, phome, pbusiness, email, job, age, income;
    
    //All the buttons
    private JButton btnCreate, btnClear;
    
    

    /**
     * Default constructor.
     *
     * @param civility
     * @param name
     * @param firstName
     * @param date
     * @param birthPlace
     * @param sex
     * @param nationality
     * @param number
     * @param street
     * @param add
     * @param cp
     * @param city
     * @param country
     * @param pnumber
     * @param phome
     * @param pbusiness
     * @param email
     * @param job
     * @param age
     * @param profession
     * @param income
     * @param create
     * @param clear
     */
    public ClientControl(JComboBox civility, JTextField name, JTextField firstName, JXDatePicker date,
                        JTextField birthPlace, JComboBox sex, JComboBox nationality, JTextField number,
                        JTextField street, JTextField add, JTextField cp, JTextField city, JComboBox country,
                        JTextField pnumber, JTextField phome, JTextField pbusiness, JTextField email,
                        JTextField job, JTextField age, JComboBox profession, JTextField income,
                        JButton create, JButton clear) {

        this.civility = civility;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = date;
        this.birthPlace = birthPlace;
        this.sex = sex;
        this.nationality = nationality;

        this.nb = number;
        this.street = street;
        this.add = add;
        this.cp = cp;
        this.city = city;
        this.country = country;

        this.pnumber = pnumber;
        this.phome = phome;
        this.pbusiness = pbusiness;
        this.email = email;
        this.job = job;
        
        this.age = age;
        this.income = income;
        this.profession = profession;

        this.btnCreate = create;
        this.btnClear = clear;
    }

    /**
     * The action that will be performed when one click on a button (create, clear)
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == btnCreate) {
            
            if (!fieldsEmpty()) {
                    
                if (!fieldsNotInteger()) {
                    
                    if (validateEmail()) {
                    
                        if (Integer.parseInt(age.getText()) > 17) { 
                            // optional fields control :
                            String additional;
                            if (add.getText().isEmpty()) {
                                additional = "non renseigné";
                            } else {
                                additional = add.getText();
                            }

                            String employment;
                            if (job.getText().isEmpty()) {
                                employment = "non renseigné";
                            } else {
                                employment = job.getText();
                            }

                            int phoneBusiness;
                            if (pbusiness.getText().isEmpty()) {
                                phoneBusiness = 0;
                            } else {
                                phoneBusiness = Integer.parseInt(pbusiness.getText());
                            }

                            int phoneHome;
                            if (phome.getText().isEmpty()) {
                                phoneHome = 0;
                            } else {
                                phoneHome = Integer.parseInt(phome.getText());
                            }

                            // client creation
                            this.client = new Client(-1, civility.getSelectedItem().toString(), name.getText(), firstName.getText(),
                                            convertUtilToSql(birthDate.getDate()), birthPlace.getText(),
                                            sex.getSelectedItem().toString(), nationality.getSelectedItem().toString(),
                                            Integer.parseInt(nb.getText()), street.getText(), additional,
                                            cp.getText(), city.getText(), country.getSelectedItem().toString(),
                                            Integer.parseInt(pnumber.getText()), phoneHome,
                                            phoneBusiness, email.getText(), employment,
                                            Integer.parseInt(age.getText()), Integer.parseInt(income.getText()),
                                            profession.getSelectedItem().toString());
                            try {
                                TCPClient tcpClient = new TCPClient("localhost",9999);
                                tcpClient.sendQuery("cc", edu.hubanato.serialization.EncodeJSON.serializeClient(this.client));
                                String response = tcpClient.receiveQuery();
                                if (response.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Client ajouté");
                                } else {
                                    JOptionPane.showMessageDialog(null, "La connexion au serveur a échoué.", 
                                    "Erreur serveur", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "L'utilisateur ne peut pas avoir moins de 18 ans.", 
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "L'adresse email n'est pas correcte.", 
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir des chiffres et non des lettres dans les champs appropriés.", 
                            "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.",
                        "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (source == btnClear) {
            //System.out.println("Vous voulez effacer les données saisies");
            civility.setSelectedItem("M.");
            name.setText("");
            firstName.setText("");
            birthDate.getDate();
            birthPlace.setText("");
            sex.setSelectedItem("M");
            nationality.setSelectedItem("Francaise");
            nb.setText("");
            street.setText("");
            add.setText("");
            cp.setText("");
            city.setText("");
            country.setSelectedItem("France");
            pnumber.setText("");
            phome.setText("");
            pbusiness.setText("");
            email.setText("");
            job.setText("");
            age.setText("");
            profession.setSelectedItem("Agriculteur exploitant");
            income.setText("");

        }
    }
    
    /**
     * Returns true if one of the mandatory fields is empty and returns false if not
     * 
     * @return boolean
     */
    private boolean fieldsEmpty() {
        if (name.getText().isEmpty() || firstName.getText().isEmpty() || convertUtilToSql(birthDate.getDate()) == null ||
                birthPlace.getText().isEmpty() || nb.getText().isEmpty() || street.getText().isEmpty() ||
                cp.getText().isEmpty() || city.getText().isEmpty() || pnumber.getText().isEmpty() ||
                email.getText().isEmpty() || age.getText().isEmpty() || income.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns true if one of the mandatory integer database fields is not an integer 
     * or if one of the not empty fiels is not an integer and returns false if it is
     * 
     * @return boolean 
     */
    private boolean fieldsNotInteger() {
        if (!isInteger(nb.getText()) || !isInteger(pnumber.getText()) || !isInteger(age.getText()) ||
                !isInteger(income.getText()) || (!isInteger(phome.getText()) && !phome.getText().isEmpty()) ||
                (!isInteger(pbusiness.getText()) && !phome.getText().isEmpty())) {
            return true;
        } else  { 
            return false;
        }
    }
    
    /**
     * 
     * returns a date with a correct java format. If the date is empty, returns null
     * 
     * @param uDate
     * @return java.sql.Date sdate  
     */
    private java.sql.Date convertUtilToSql(java.util.Date uDate) {
        if (uDate == null) {
            return null;
        } else {
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            return sDate;
        }
    }
    
    /**
     * returns true if s can be converted to integer
     * 
     * @param String s 
     * @return boolean 
     */
    private boolean isInteger(String s) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e){
                return false;
            }

            return true;
    }
    
    /**
     * returns true if the email format is correct
     * 
     * @return boolean 
     */
    private boolean validateEmail() {
        Pattern pattern = Pattern.compile("^.+@.+(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email.getText());
        return matcher.matches();
    }

}