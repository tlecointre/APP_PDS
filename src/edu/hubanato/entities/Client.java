/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import edu.hubanato.models.PdsDatabase;
import java.util.logging.*;

/**
 * Release R2
 *
 * @author hubanato
 */
public class Client extends Person {

    private int id_adr;
    private int id_person;
    private int age;
    private int income;
    private String profession; 

    /**
     * Constructor This method is used to create a new client
     *
     * @param civility
     * @param name
     * @param firstName
     * @param birthDate
     * @param birthPlace
     * @param sex
     * @param nationality
     * @param number
     * @param street
     * @param add
     * @param cp
     * @param city
     * @param country
     * @param pNumber
     * @param pHome
     * @param pBusiness
     * @param email
     * @param job
     * @param age
     * @param profession
     * @param income
     */
    public Client(String civility, String name, String firstName, Date birthDate, String birthPlace,
                    String sex, String nationality, int number, String street, String add, String cp,
                    String city, String country, int pNumber, int pHome, int pBusiness, String email,
                    String job, int age, int income, String profession) {

        this.civility = civility;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.sex = sex;
        this.nationality = nationality;

        this.number = number;
        this.Street = street;
        this.Additional = add;
        this.cp = cp;
        this.city = city;
        this.country = country;

        this.phoneNumber = pNumber;
        this.phoneHome = pHome;
        this.phoneBusiness = pBusiness;
        this.email = email;
        this.job = job;
        
        this.age = age;
        this.income = income;
        this.profession = profession;
    }

    public Client() {

    }

    /**
     *
     *
     */
    @Override
    public void CreatePerson() throws SQLException {

        Connection connexion = PdsDatabase.getConnection();

        String requeteAddress = "INSERT INTO ADDRESS(NBER,STREET,ADDITIONAL,ZIP_CODE,CITY,COUNTRY) VALUES (?,?,?,?,?,?)";
        PreparedStatement ordre = connexion.prepareStatement(requeteAddress);

        ordre.setInt(1, number);
        ordre.setString(2, Street);
        ordre.setString(3, Additional);
        ordre.setString(4, cp);
        ordre.setString(5, city);
        ordre.setString(6, country);

        ordre.executeUpdate();
        System.out.println(requeteAddress);
        String sql = "SELECT MAX(id_adr) as idMax FROM ADDRESS";
        ordre = connexion.prepareStatement(sql);
        ResultSet rs = ordre.executeQuery();
        rs.next();
        id_adr = rs.getInt("idMax");

        ordre.close();

        //This query is used to insert after into the table "PERSON"
        String requeteClient = "INSERT INTO PERSON(ID_FUNCTIONS,ID_ADR,CIVILITY,FIRST_NAME,NAME,SEX,"
                + "BIRTH_DATE,BIRTH_PLACE,NATIONALITY,PHONE_HOME,PHONE_MOBIL,EMAIL,JOB,PHONE_BUSINESS,"
                + " PROFESSION, AGE, ANNUAL_INCOME) VALUES (1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ordre2 = connexion.prepareStatement(requeteClient);

        ordre2.setInt(1, id_adr);
        ordre2.setString(2, civility);
        ordre2.setString(3, firstName);
        ordre2.setString(4, name);
        ordre2.setString(5, sex);
        ordre2.setDate(6, birthDate);
        ordre2.setString(7, birthPlace);
        ordre2.setString(8, nationality);
        ordre2.setInt(9, phoneHome);
        ordre2.setInt(10, phoneNumber);
        ordre2.setString(11, email);
        ordre2.setString(12, job);
        ordre2.setInt(13, phoneBusiness);
        ordre2.setString(14, profession);
        ordre2.setInt(15, age);
        ordre2.setInt(16, income);

        ordre2.executeUpdate();
        ordre2.close();

        connexion.close();

    }

    /**
     * Returns a client
     *
     * @param id : ID client
     * @return client found
     * @throws SQLException
     */
    public static Client getById(int id) throws SQLException {
        Connection connexion = PdsDatabase.getConnection();
        String sql = "SELECT * FROM PERSON, ADDRESS WHERE ID_PERS = ? AND PERSON.ID_ADR = ADDRESS.ID_ADR";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, id);
        ResultSet rs = ordre.executeQuery();
        if (rs.next()) {
            return new Client(rs.getString("CIVILITY"), rs.getString("NAME"), rs.getString("FIRST_NAME"),
                    rs.getDate("BIRTH_DATE"), rs.getString("BIRTH_PLACE"), rs.getString("SEX"),
                    rs.getString("NATIONALITY"), rs.getInt("NBER"), rs.getString("STREET"),
                    rs.getString("ADDITIONAL"), rs.getString("ZIP_CODE"), rs.getString("CITY"),
                    rs.getString("COUNTRY"), rs.getInt("PHONE_MOBIL"), rs.getInt("PHONE_HOME"),
                    rs.getInt("PHONE_BUSINESS"), rs.getString("EMAIL"), rs.getString("JOB"),
                    rs.getInt("AGE"), rs.getInt("ANNUAL_INCOME"), rs.getString("PROFESSION"));
        } else {
            return null;
        }
    }

    /**
     * Returns a client
     *
     * @param name : client name
     * @param firstName : client first name
     * @return client found
     * @throws SQLException
     */
    public static List<Client> getByNamePC(String name, String firstName, String postalCode) throws SQLException {
        Connection connexion = PdsDatabase.getConnection();

        String sql = "SELECT * FROM PERSON, ADDRESS WHERE NAME like ? AND FIRST_NAME like ? "
                + "AND PERSON.ID_ADR = ADDRESS.ID_ADR AND ZIP_CODE like ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setString(1, name);
        ordre.setString(2, firstName);
        ordre.setString(3, postalCode);
        ResultSet rs = ordre.executeQuery();
        List<Client> clients = new ArrayList<Client>();
        while (rs.next()) {
            clients.add(new Client(rs.getString("CIVILITY"), rs.getString("NAME"), rs.getString("FIRST_NAME"),
                    rs.getDate("BIRTH_DATE"), rs.getString("BIRTH_PLACE"), rs.getString("SEX"),
                    rs.getString("NATIONALITY"), rs.getInt("NBER"), rs.getString("STREET"),
                    rs.getString("ADDITIONAL"), rs.getString("ZIP_CODE"), rs.getString("CITY"),
                    rs.getString("COUNTRY"), rs.getInt("PHONE_MOBIL"), rs.getInt("PHONE_HOME"),
                    rs.getInt("PHONE_BUSINESS"), rs.getString("EMAIL"), rs.getString("JOB"),
                    rs.getInt("AGE"), rs.getInt("ANNUAL_INCOME"), rs.getString("PROFESSION")));

        }
        return clients;
    }

    /**
     *
     */
    @Override
    public void UpdatePerson() {
        try {
            Connection connexion = PdsDatabase.getConnection();
            String sql = "UPDATE PERSON SET name = ? , firstName = ? WHERE id_pers = ?";
            PreparedStatement ordre = connexion.prepareStatement(sql);
            ordre.setString(1, name);
            ordre.setString(2, firstName);
            ordre.setInt(3, id_person);
            ordre.executeUpdate();
            ordre.close();
            connexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     */
    @Override
    public void DeletePerson(int id) {
        try {
            Connection connexion = PdsDatabase.getConnection();

            String deleteQuery = "DELETE FROM PERSON WHERE id_pers = ?";
            PreparedStatement ordre = connexion.prepareStatement(deleteQuery);
            ordre.setInt(1, id);
            ordre.executeUpdate();
            ordre.close();
            connexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
