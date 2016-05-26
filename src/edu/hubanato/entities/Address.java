package edu.hubanato.entities;

/**
 * 
 * @author Tom
 */
class Address {

    private int number;
    private String street;
    private String additional;
    private int cp;
    private String city;
    private String country;
    
    /**
     * Defaut constructor
     * 
     * @param number
     * @param street
     * @param additional
     * @param cp
     * @param city
     * @param country 
     */
    public Address(int number, String street, String additional, int cp, String city, String country) {
        this.number = number;
        this.street = street;
        this.additional = additional;
        this.cp = cp;
        this.city = city;
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Address{" + "number=" + number + ", Street=" + street + ", Additional=" + additional + ", cp=" + cp + ", city=" + city + ", country=" + country + '}';
    }

}
