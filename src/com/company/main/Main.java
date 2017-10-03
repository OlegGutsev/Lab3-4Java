package com.company.main;

import com.company.Staff.Staff;
import com.company.educationmanager.Manager;
import com.company.exception.EduException;
import com.company.organization.Organizations;
import com.company.units.*;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static final String TAG = "TAG";

    public static void main(String[] args) {
        Logger log = Logger.getLogger(TAG);

        Staff staffAll = new Staff(
                new ArrayList<Person>(
                        Arrays.asList(
                                new Student("Олег", "Гуцев", 19, 9),
                                new Student("Максим", "Сергейчик", 21, 7),
                                new Student("Никита", "Воробьев", 19, 6),
                                new Student("Алексей", "Гаврусев", 19, 8),
                                new Student("Александра", "Красницкая", 19, 4),
                                new Student("Владислав", "Петровский", 19, 7),
                                new Student("Кирилл", "Давыдулин", 19, 8),
                                new Listener("Станислав", "Сябровский", 25, Organizations.EPAM),
                                new Listener("Максим", "Скварцов", 24, Organizations.BELHARD),
                                new Listener("Олег", "Верещинский", 23, Organizations.BELHARD),
                                new Listener("Максим", "Иванов", 20, Organizations.ITECHART),
                                new Listener("Алексей", "Сквар", 28, Organizations.BELHARD),
                                new Listener("Роман", "Пыжиков", 24, Organizations.ITRANSITION))));

        log.info(staffAll.getStudList().toString());

        List<Person> students = staffAll
                .getStudList()
                .get()
                .stream()
                .filter(stud -> stud instanceof Student)
                .collect(Collectors.toList());

        List<Person> listener = staffAll
                .getStudList()
                .get()
                .stream()
                .filter(listen -> listen instanceof Listener)
                .collect(Collectors.toList());

        String jsonStudent = new Gson().toJson(students);
        String jsonListener = new Gson().toJson(listener);

        Staff staffFirstGroup = new Staff();
        Staff staffSecondGroup = new Staff();

        Manager manager = new Manager();
        try {
            staffFirstGroup = manager.createGroup(5, 3,
                    jsonStudent, jsonListener);

            log.info("Первая группа:\n" + staffFirstGroup.getStudList().toString());
            log.info("Отсортированная первая группа студентов по оценке:\n" + manager.sortByMark(staffFirstGroup).getStudList().toString());
            log.info("Отсортированная первая группа студентов по Фамилии:\n" + manager.sortBySname(staffFirstGroup).getStudList().toString());
            log.info("Топ 3 студентов первой группы:\n" + (manager.TopStudents(staffFirstGroup)).getStudList().toString());
        } catch (EduException ex) {
            log.info(ex.getMessage() + ex.getStudent() +
                    " .Всего имеется: " + ex.getAllStudent());
        }

        try {
            staffSecondGroup = manager.generateGroup(staffAll, 6, 2);
            log.info("Вторая группа:\n" + staffSecondGroup.getStudList().toString());
            log.info("Отсортированная вторая группа студентов по оценке:\n" + manager.sortByMark(staffSecondGroup).getStudList().toString());
            log.info("Отсортированная вторая группа стуентов по Фамилии:\n" + manager.sortBySname(staffSecondGroup).getStudList().toString());
            log.info("Топ 3 студентов второй группы:\n" + (manager.TopStudents(staffFirstGroup)).getStudList().toString());
        } catch (EduException ex) {
            log.info(ex.getMessage() + ex.getStudent() +
                    " .Всего имеется: " + ex.getAllStudent());
        }
    }
}
