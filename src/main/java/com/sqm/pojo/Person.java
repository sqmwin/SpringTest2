package com.sqm.pojo;

import java.util.StringJoiner;

/**
 * <p>
 *     PersonBean
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class Person {

    private String personName;
    private int personAge;
    private String country;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                ", country='" + country + '\'' +
                '}';
    }

    public int computeAge() {
        return personAge > 25 ? 25 : personAge;
    }
}
