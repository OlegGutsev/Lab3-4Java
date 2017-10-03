package com.company.units;

import com.company.units.Person;

public class Student extends Person {

    private int mMark;

    public Student(String firstName, String secondName, int age, int mark) {
        super(firstName, secondName, age);
        mMark = mark;
    }

    public Student() {
    }

    public int getMark() {
        return mMark;
    }

    public void setMark(int mark) {
        mMark = mark;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSecondName() + " " + getAge() + " " + getMark() + "\n";
    }
}
