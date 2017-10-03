package com.company.educationmanager;

import com.company.Staff.Staff;
import com.company.exception.EduException;
import com.google.gson.Gson;

public interface IAction {
    Staff createGroup(int maxStudent, int maxListener,
                      String jsonStudent, String jsonListener) throws EduException;

    Staff generateGroup(Staff someCourse, int maxStudent,
                        int maxListener) throws EduException;

    int sumRanges(Staff anyCourse);

    int countListener(Staff anyCourse);

    int countStudent(Staff anyCourse);

    Staff sortByMark(Staff anyCourse);

    Staff sortBySname(Staff anyCourse);

    Staff TopStudents(Staff anyCourse);

    default void print(){

        System.out.println("Интерфейс по умолчанию");
    }

    static void read(){

        System.out.println("Статический интерфейс");
    }
}
