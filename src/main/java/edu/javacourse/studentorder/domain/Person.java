package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public abstract class Person {
    private String serName;
    private String givenName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Address address;

    public Person(String serName, String givenName, String patronymic, LocalDate dateOfBirth, Address address) {
        this.serName = serName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.address=address;
    }

    public Person(String serName, String givenName, String patronymic, LocalDate dateOfBirth) {
        this.serName = serName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {

    }

    public String getPersonString(){
        return serName+" "+givenName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "serName='" + serName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}

