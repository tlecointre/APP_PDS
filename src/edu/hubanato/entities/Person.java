/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hubanato.entities;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Release R2
 * @author hubanato
 */
public abstract class Person {
    
    
    protected String civility;
    protected String name;
    protected String firstName;
    protected Date birthDate;
    protected String birthPlace;
    protected String sex;
    protected String nationality;
    
    /*protected Address address;*/
    protected int number;
    protected String Street;
    protected String Additional;
    protected String cp;
    protected String city;
    protected String country;
    
    protected int phoneNumber;
    protected int phoneHome;
    protected int phoneBusiness;
    protected String email;
    protected String job;
    
    //All methods
    public abstract void createPerson() throws SQLException, ClassNotFoundException;
    public abstract void updatePerson() throws SQLException, ClassNotFoundException;
    public abstract void deletePerson(int id) throws SQLException, ClassNotFoundException;

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCp() {
        return cp;
    }
    
}
