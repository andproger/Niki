package com.niki.domain.interactors.simpleView.admin;

import com.niki.domain.entities.Person;

public class AdminContract {
    private int id;
    private String login;
    private String password;
    private Person person;


    public AdminContract(int id, String login, String password, Person person) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return login;
    }
}
