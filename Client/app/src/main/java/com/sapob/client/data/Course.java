package com.sapob.client.data;

import java.util.ArrayList;

public class Course implements Comparable<Course> {
    private final String id;
    private final String name;
    private int creditHours;
    private ArrayList<Section> sections;

    public Course(String id, String name, int creditHours, ArrayList<Section> sections) {
        this.id = id;
        this.name = name;
        this.creditHours = creditHours;
        this.sections = sections;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return this.name;
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
        return this.name.equals(a.name) && this.id.equals(a.getID());
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.getName());
    }
}