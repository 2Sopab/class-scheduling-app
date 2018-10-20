package com.sapob.client.data;

import java.util.ArrayList;

public class Course implements Comparable<Course> {
    private String subject;
    private int number;
    private int creditHours;
    private ArrayList<Section> sections;

    public Course(String subject, int number, int creditHours, ArrayList<Section> sections) {
        this.subject = subject;
        this.number = number;
        this.creditHours = creditHours;
        this.sections = sections;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumber() {
        return this.number;
    }

    public int getCreditHorus() {
        return this.creditHours;
    }

    public ArrayList<Section> getSections() {
        return this.sections;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Course)) {
            return false;
        }
        Course a = (Course)o; 
        return this.subject.equals(a.subject) && this.number == a.number;
    }

    @Override
    public int compareTo(Course o) {
        return this.subject.compareTo(o.getSubject());
    }
}