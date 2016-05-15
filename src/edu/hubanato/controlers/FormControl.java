package edu.hubanato.controlers;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import edu.hubanato.entities.Client;
import edu.hubanato.forms.AuthenticationClientForm;
import org.jdesktop.swingx.JXDatePicker;

/**
 * Release R2
 *
 * @author hubanato
 */
public class FormControl implements ActionListener {

    //Client
    private Client client;

    private JComboBox civility, sex, nationality, country, profession;
    
    private JXDatePicker birthDate;

    private JTextField name, firstName, birthPlace, nb, street, add, cp, city;

    private JTextField pnumber, phome, pbusiness, email, job, age, income;
    
    //All the buttons
    private JButton btnCreate, btnClear, btnCancel;

    /**
     * Constructor
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
     * @param cancel
     */
    public FormControl(JComboBox civility, JTextField name, JTextField firstName, JXDatePicker date,
                        JTextField birthPlace, JComboBox sex, JComboBox nationality, JTextField number,
                        JTextField street, JTextField add, JTextField cp, JTextField city, JComboBox country,
                        JTextField pnumber, JTextField phome, JTextField pbusiness, JTextField email,
                        JTextField job, JTextField age, JComboBox profession, JTextField income,
                        JButton create, JButton clear, JButton cancel) {

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
        this.btnCancel = cancel;
    }

    /**
     * The action that will be performed when one click on a button (create,
     * clear, cancel)
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == btnCreate) {

            /*System.out.println("Informations sur le client :");
             System.out.println("Civilité : " + civility.getSelectedItem());
             System.out.println("Client : " + name.getText() + " " + firstName.getText());
             System.out.println("Birth Date / Birth Place : " + birthDate.getDate() + ", " + birthPlace.getText());
             System.out.println("Sex : " + sex.getSelectedItem());
             System.out.println("Nationality : " + nationality.getSelectedItem());
             System.out.println("Adresse : " + nb.getText() + " " + street.getText() + ", " + cp.getText() + ", " + city.getText() + ", " + country.getSelectedItem());
             System.out.println("Phone Number : " + pnumber.getText());
             System.out.println("Phone Home : " + phome.getText());
             System.out.println("Phone Business : " + pbusiness.getText());
             System.out.println("Email : " + email.getText());
             System.out.println("Job : " + job.getText());*/
            this.client = new Client(civility.getSelectedItem().toString(), name.getText(), firstName.getText(),
                            convertUtilToSql(birthDate.getDate()), birthPlace.getText(),
                            sex.getSelectedItem().toString(), nationality.getSelectedItem().toString(),
                            Integer.parseInt(nb.getText()), street.getText(), add.getText(),
                            cp.getText(), city.getText(), country.getSelectedItem().toString(),
                            Integer.parseInt(pnumber.getText()), Integer.parseInt(phome.getText()),
                            Integer.parseInt(pbusiness.getText()), email.getText(), job.getText(),
                            Integer.parseInt(age.getText()), Integer.parseInt(income.getText()),
                            profession.getSelectedItem().toString());
            try {
                client.createPerson();
                JOptionPane.showMessageDialog(null, "Client Added");
            } catch (SQLException ex) {
                Logger.getLogger(FormControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (source == btnClear) {
            //System.out.println("Vous voulez effacer les données saisies");
            civility.setSelectedItem("Mr");
            name.setText("");
            firstName.setText("");
            birthDate.getDate();
            birthPlace.setText("");
            sex.setSelectedItem("M");
            nationality.setSelectedItem("France");
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

        } else if (source == btnCancel) {
            new AuthenticationClientForm().setVisible(true);
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}