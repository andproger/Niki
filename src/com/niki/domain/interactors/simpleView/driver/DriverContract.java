package com.niki.domain.interactors.simpleView.driver;

import com.niki.domain.entities.Person;

public class DriverContract {
    private int id;
    private String card;
    private Person person;

    public DriverContract(int id, String card, Person person) {
        this.id = id;
        this.card = card;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return person.getLastName() + " " + card;
    }
}
