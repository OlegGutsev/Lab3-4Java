package com.company.units;
import java.lang.annotation.*;
import java.util.Date;

@interface DateNow {
    int day();
    int month();
    int year();
}

@interface Version {
    DateNow date();
}

@interface My{
    String str();
    String name();
}

@DateNow(day = 26, month = 9, year = 2017)
public abstract class Person {
    private String mFirstName;
    private String mSecondName;
    private int mAge;

    public Person() {
        mFirstName = "";
        mSecondName = "";
        mAge = 0;
    }

    public Person(String firstName, String secondName, int age) {
        mFirstName = firstName;
        mSecondName = secondName;
        mAge = age;
    }

    @My(str = "Получение имени", name = "Oleg")
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getSecondName() {
        return mSecondName;
    }

    public void setSecondName(String secondName) {
        mSecondName = secondName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
