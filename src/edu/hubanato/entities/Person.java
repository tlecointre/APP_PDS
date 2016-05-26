package edu.hubanato.entities;

import java.sql.Date;
import java.sql.SQLException;

/**
 * 
 * @author Tom
 */
public abstract class Person {
    
    
    protected String civility;
    protected String name;
    protected String firstName;
    protected Date birthDate;
    protected String birthPlace;
    protected String sex;
    protected String nationality;
    
    // Adress
    protected int number;
    protected String street;
    protected String additional;
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
    
    /**
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return String firstName 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return String cp 
     */
    public String getCp() {
        return cp;
    }
    
}
