package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private List<String> courses;

    public Student(String name, int year) {
        this.name = name;
        if (year >= 1 && year <= 4) {
            this.year = year;
        } else {
            this.year = 1;
            System.err.println("Некоректний рік навчання. Встановлено 1 курс.");
        }
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            courses.add(courseName);
        }
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getTuition() {
        return year * 20000.0;
    }
}