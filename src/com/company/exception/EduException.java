package com.company.exception;

public class EduException extends Exception {
    private int allStudent;
    private int student;

    public EduException(String message, int allStudent, int student) {
        super(message);
        this.allStudent = allStudent;
        this.student = student;
    }

    public int getAllStudent() {
        return allStudent;
    }

    public int getStudent() {
        return student;
    }
}
