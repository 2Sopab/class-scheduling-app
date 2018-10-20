package com.sapob.client.data;

import com.sapob.client.data.component.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SampleData implements DataModel {
    private final List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("CS 1331", "Intro to Object Oriented Programming"),
            new Course("ISYE 3770", "Statistics and Applications"),
            new Course("CS 2050", "Intro to Discrete Math"),
            new Course("MATH 1554", "Linear Algebra", 4),
            new Course("MATH 1553", "Integral Calculus", 4),
            new Course("MATH 2550", "Multivariable Calculus", 2),
            new Course("CHEM 1211k", "General Chemistry I", 4),
            new Course("CHEM 1212k", "General Chemistry II", 4),
            new Course("ENGL 1101", "English Composition I"),
            new Course("ENGL 1102", "English Composition II"),
            new Course("MATH 3012", "Applied Combinatorics"),
            new Course("CS 2340", "Objects and Design"),
            new Course("CS 3510", "Design & Analysis of Algorithms"),
            new Course("CS 1301", "Introduction to Computing")));

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Course getCourseFromUUID(int uuid) {
        final int uuidRef = uuid;
        return courses.stream().filter(new Predicate<Course>() {
            @Override
            public boolean test(Course c) {
                return c.getUUID() == uuidRef;
            }
        }).findFirst().orElse(null);
    }
}
