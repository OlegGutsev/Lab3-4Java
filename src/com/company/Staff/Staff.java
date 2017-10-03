package com.company.Staff;

import com.company.units.Person;

import java.util.ArrayList;
import java.util.Optional;

public class Staff {
    private Optional<ArrayList<Person>> mStudList;

    public Staff() {
        mStudList = Optional.ofNullable(new ArrayList<>());
    }

    public Staff(ArrayList<Person> studList) {
        mStudList = Optional.of(studList);
    }

    public Optional<ArrayList<Person>> getStudList() {
        return mStudList;
    }

    public void setStudList(ArrayList<Person> studList) {
        mStudList = Optional.of(studList);
    }

    public boolean add(Person item) {
        mStudList.get().add(item);
        return true;
    }

    public boolean addRange(ArrayList<Person> items) {
        mStudList.get().addAll(items);
        return true;
    }

    public boolean remove(Person item) {
        mStudList.get().remove(item);
        return true;
    }

    public int count() {
        return mStudList.get().size();
    }

    public boolean compByCourse(Person a, Person b) {
        return true;
    }
}