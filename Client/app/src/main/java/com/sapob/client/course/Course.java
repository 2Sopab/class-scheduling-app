package com.sapob.client.course;

public class Course implements Comparable<Course> {
    private final String id;
    private final String name;
    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getID() {
        return id;
    }
    public String getName() {
        return name;
    }
}
