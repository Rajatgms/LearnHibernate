package com.example.LearnHibernate.Basic;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlienName {
    private String firstName;
    private String middleName;
    private String lastName;

    public AlienName() {

    }

    public AlienName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AlienName{" + "fName='" + firstName + ", mName='" + middleName + ", lName='" + lastName + '}';
    }
}
