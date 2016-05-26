package edu.hubanato.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import edu.hubanato.server.InterfacePoolServer;


/**
 *
 * @author Tom
 */
public class Client extends Person {

    private int idAdress, idClient, age, income;
    private String profession; 

    /**
     * Constructor 
     *
     * @param idClient
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
    public Client(int idClient, String civility, String name, String firstName, Date birthDate, String birthPlace,
                    String sex, String nationality, int number, String street, String add, String cp,
                    String city, String country, int pNumber, int pHome, int pBusiness, String email,
                    String job, int age, int income, String profession) {

        this.idClient = idClient;
        this.civility = civility;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.sex = sex;
        this.nationality = nationality;

        this.number = number;
        this.street = street;
        this.additional = add;
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
    
    /**
     * 
     * @return int idClient 
     */
    public int getIdClient() {
        return idClient;
    }
    
    /**
     * 
     * @return int age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Create this client and its adress in database
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public void createPerson() throws SQLException, ClassNotFoundException {

        Connection connection = InterfacePoolServer.getConnection();

        String requeteAddress = "INSERT INTO ADDRESS(NBER,STREET,ADDITIONAL,ZIP_CODE,CITY,COUNTRY) VALUES (?,?,?,?,?,?)";
        PreparedStatement ordre = connection.prepareStatement(requeteAddress);

        ordre.setInt(1, number);
        ordre.setString(2, street);
        ordre.setString(3, additional);
        ordre.setString(4, cp);
        ordre.setString(5, city);
        ordre.setString(6, country);

        ordre.executeUpdate();
        System.out.println(requeteAddress);
        String sql = "SELECT MAX(id_adr) as idMax FROM ADDRESS";
        ordre = connection.prepareStatement(sql);
        ResultSet rs = ordre.executeQuery();
        rs.next();
        idAdress = rs.getInt("idMax");

        ordre.close();

        //This query is used to insert after into the table "PERSON"
        String requeteClient = "INSERT INTO PERSON(ID_FUNCTIONS,ID_ADR,CIVILITY,FIRST_NAME,NAME,SEX,"
                + "BIRTH_DATE,BIRTH_PLACE,NATIONALITY,PHONE_HOME,PHONE_MOBIL,EMAIL,JOB,PHONE_BUSINESS,"
                + " PROFESSION, AGE, ANNUAL_INCOME) VALUES (1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ordre2 = connection.prepareStatement(requeteClient);
        
        ordre2.setInt(1, idAdress);
        ordre2.setString(2, civility);
        ordre2.setString(3, firstName);
        ordre2.setString(4, name);
        ordre2.setString(5, sex);
        ordre2.setDate(6, birthDate);
        ordre2.setString(7, birthPlace);
        ordre2.setString(8, nationality);
        if (phoneHome != 0) { // this field is optional and equals 0 if empty
            ordre2.setInt(9, phoneHome);
        } else {
            ordre2.setNull(9, java.sql.Types.INTEGER);
        }
        ordre2.setInt(10, phoneNumber);
        ordre2.setString(11, email);
        ordre2.setString(12, job);
        if (phoneBusiness != 0) { // this field is optional and equals 0 if empty
            ordre2.setInt(13, phoneBusiness);
        } else {
            ordre2.setNull(13, java.sql.Types.INTEGER);
        }
        ordre2.setString(14, profession);
        ordre2.setInt(15, age);
        ordre2.setInt(16, income);

        ordre2.executeUpdate();
        ordre2.close();
        InterfacePoolServer.returnConnection(connection);

    }

    /**
     * Returns a client by researching an id in database
     * Returns null if no client has been found
     *
     * @param id : ID client
     * @return client found
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Client getById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();
        String sql = "SELECT * FROM PERSON, ADDRESS WHERE ID_PERS = ? AND PERSON.ID_ADR = ADDRESS.ID_ADR";
        PreparedStatement ordre = connection.prepareStatement(sql);
        ordre.setInt(1, id);
        ResultSet rs = ordre.executeQuery();
        if (rs.next()) {
            ordre.close();
            InterfacePoolServer.returnConnection(connection);
            return new Client(rs.getInt("ID_PERS"), rs.getString("CIVILITY"), rs.getString("NAME"), rs.getString("FIRST_NAME"),
                    rs.getDate("BIRTH_DATE"), rs.getString("BIRTH_PLACE"), rs.getString("SEX"),
                    rs.getString("NATIONALITY"), rs.getInt("NBER"), rs.getString("STREET"),
                    rs.getString("ADDITIONAL"), rs.getString("ZIP_CODE"), rs.getString("CITY"),
                    rs.getString("COUNTRY"), rs.getInt("PHONE_MOBIL"), rs.getInt("PHONE_HOME"),
                    rs.getInt("PHONE_BUSINESS"), rs.getString("EMAIL"), rs.getString("JOB"),
                    rs.getInt("AGE"), rs.getInt("ANNUAL_INCOME"), rs.getString("PROFESSION"));
        } else {
            ordre.close();
            InterfacePoolServer.returnConnection(connection);
            return null;
        }
    }

    /**
     * Returns a list of clients
     * Returns a list empty if no client has been found
     *
     * @param name : client name
     * @param firstName : client first name
     * @param postalCode
     * @return clients found
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Client> getByNamePC(String name, String firstName, String postalCode) throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();

        String sql = "SELECT * FROM PERSON, ADDRESS WHERE NAME like ? AND FIRST_NAME like ? "
                + "AND PERSON.ID_ADR = ADDRESS.ID_ADR AND ZIP_CODE like ?";
        PreparedStatement ordre = connection.prepareStatement(sql);
        ordre.setString(1, name);
        ordre.setString(2, firstName);
        ordre.setString(3, postalCode);
        ResultSet rs = ordre.executeQuery();
        List<Client> clients = new ArrayList<Client>();
        while (rs.next()) {
            clients.add(new Client(rs.getInt("ID_PERS"), rs.getString("CIVILITY"), rs.getString("NAME"), rs.getString("FIRST_NAME"),
                    rs.getDate("BIRTH_DATE"), rs.getString("BIRTH_PLACE"), rs.getString("SEX"),
                    rs.getString("NATIONALITY"), rs.getInt("NBER"), rs.getString("STREET"),
                    rs.getString("ADDITIONAL"), rs.getString("ZIP_CODE"), rs.getString("CITY"),
                    rs.getString("COUNTRY"), rs.getInt("PHONE_MOBIL"), rs.getInt("PHONE_HOME"),
                    rs.getInt("PHONE_BUSINESS"), rs.getString("EMAIL"), rs.getString("JOB"),
                    rs.getInt("AGE"), rs.getInt("ANNUAL_INCOME"), rs.getString("PROFESSION")));

        }
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
        return clients;
    }

    /**
     * Updates this client in database
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public void updatePerson() throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();
        String sql = "UPDATE PERSON SET name = ? , firstName = ? WHERE id_pers = ?";
        PreparedStatement ordre = connection.prepareStatement(sql);
        ordre.setString(1, name);
        ordre.setString(2, firstName);
        ordre.setInt(3, idClient);
        ordre.executeUpdate();
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
    }

    /**
     * Delete this client in database
     * 
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public void deletePerson(int id) throws SQLException, ClassNotFoundException {
        Connection connection = InterfacePoolServer.getConnection();

        String deleteQuery = "DELETE FROM PERSON WHERE id_pers = ?";
        PreparedStatement ordre = connection.prepareStatement(deleteQuery);
        ordre.setInt(1, idClient);
        ordre.executeUpdate();
        ordre.close();
        InterfacePoolServer.returnConnection(connection);
    }
    
}
