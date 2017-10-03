package com.company.educationmanager;

import com.company.Staff.Staff;
import com.company.exception.EduException;
import com.company.units.Listener;
import com.company.units.Person;
import com.company.units.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Manager implements IAction {

    @Override
    public Staff createGroup(int maxStudent, int maxListener,
                             String jsonStudent, String jsonListener) throws EduException {


        CopyOnWriteArrayList<Student> students = new Gson().
                fromJson(jsonStudent, new TypeToken<CopyOnWriteArrayList<Student>>() {
                }
                        .getType());

        CopyOnWriteArrayList<Listener> listeners = new Gson().
                fromJson(jsonListener, new TypeToken<CopyOnWriteArrayList<Listener>>() {
                }
                        .getType());

        if (maxStudent > students.size()) {
            throw new EduException("Указано больше студентов,а именно: ",
                    maxStudent, students.size());
        } else if (maxListener > listeners.size()) {
            throw new EduException("Указано больше Слушателей,а именно: ",
                    maxListener, listeners.size());
        }

        Staff newCourse = new Staff();
        newCourse.addRange((ArrayList) students
                .stream()
                .limit(maxStudent)
                .collect(Collectors.toList()));
        newCourse.addRange((ArrayList) listeners
                .stream()
                .limit(maxListener)
                .collect(Collectors.toList()));

        return newCourse;
    }

    @Override
    public Staff generateGroup(Staff someCourse, int maxStudent, int maxListener) throws EduException {

        List<Person> students = someCourse
                .getStudList()
                .get()
                .stream()
                .filter(stud -> stud instanceof Student)
                .collect(Collectors.toList());

        List<Person> listener = someCourse
                .getStudList()
                .get()
                .stream()
                .filter(listen -> listen instanceof Listener)
                .collect(Collectors.toList());

        Staff newStaff = new Staff();

        if (maxStudent > countStudent(someCourse)) {
            throw new EduException("Указано больше студентов,а именно: ",
                    maxStudent, countStudent(someCourse));
        } else if (maxListener > countListener(someCourse)) {
            throw new EduException("Указано больше Слушателей,а именно: ",
                    maxListener, countListener(someCourse));
        }
        for (int i = 0; i < maxStudent; i++) {
            Person person = (getRandom((ArrayList) students));
            students.remove(person);
            newStaff.add(person);
        }
        for (int i = 0; i < maxListener; i++) {
            Person person = (getRandom((ArrayList) listener));
            students.remove(person);
            newStaff.add(person);
        }
        return newStaff;
    }

    @Override
    public int sumRanges(Staff anyCourse) {
        int sum = 0;

        List<Person> students = anyCourse
                .getStudList()
                .get()
                .stream()
                .filter(stud -> stud instanceof Student)
                .collect(Collectors.toList());
        for (int i = 0; i < students.size(); i++) {
            sum += ((Student) students.get(i)).getMark();
        }
        return sum;
    }

    @Override
    public int countListener(Staff anyCourse) {
        return (int) anyCourse
                .getStudList()
                .get()
                .stream()
                .filter(listn -> listn instanceof Listener)
                .count();
    }

    @Override
    public int countStudent(Staff anyCourse) {
        return (int) anyCourse
                .getStudList()
                .get()
                .stream()
                .filter(stud -> stud instanceof Listener)
                .count();
    }

    @Override
    public Staff sortByMark(Staff anyCourse) {
        List<Person> students = anyCourse
                .getStudList()
                .get()
                .stream()
                .filter(stud -> stud instanceof Student)
                .collect(Collectors.toList());
        students.sort((first, second) -> compareMark.compare((Student) first, (Student) second));
        return new Staff((ArrayList) students);
    }

    @Override
    public Staff sortBySname(Staff anyCourse) {
        List<Person> students = anyCourse
                .getStudList()
                .get()
                .stream()
                .filter(stud -> stud instanceof Student)
                .collect(Collectors.toList());
        students.sort((first, second) -> compareSname.compare((Student) first, (Student) second));
        return new Staff((ArrayList)students);
    }

    @Override
    public Staff TopStudents(Staff anyCourse) {
        Staff newCourse = sortByMark(anyCourse);
        newCourse.setStudList((ArrayList)newCourse
                                    .getStudList()
                                    .get()
                                    .stream()
                                    .limit(3)
                                    .collect(Collectors.toList()));

        return newCourse;
    }

    Comparator<Student> compareMark = (o1, o2) -> {
        return Integer.compare(o2.getMark(),
                o1.getMark());
    };

    Comparator<Student> compareSname = (o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName());

    private Person getRandom(List<Person> people) {
        int rnd = new Random().nextInt(people.size());
        return people.get(rnd);
    }

}
