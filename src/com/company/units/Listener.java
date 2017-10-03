package com.company.units;

import com.company.organization.Organizations;

public class Listener extends Person {

    private Organizations mOrganization;
    private int mListeningHours;

    public Listener(String firstName, String secondName, int age, Organizations organisation) {
        super(firstName, secondName, age);
        mOrganization = organisation;
    }

    public Listener() {
    }

    public Organizations getOrganization() {
        return mOrganization;
    }

    public void setOrganization(Organizations organization) {
        mOrganization = organization;
    }

    public int getListeningHours() {
        return mListeningHours;
    }

    public void setListeningHours(int listeningHours) {
        mListeningHours = listeningHours;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSecondName() + " " + getAge() + " " + getOrganization() + "\n";
    }
}