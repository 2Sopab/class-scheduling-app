package com.sapob.client.data.component;

import java.util.ArrayList;
import java.util.List;

public class Course implements Comparable<Course> {
    private String subject;
    private String number;
    private int creditHours;
    private String title;
    private List<Section> sections;
    private final int uuid;
    private static int LAST_UUID = 0;

    public Course(String identifier, String title, int creditHours, List<Section> sections) {
        uuid = LAST_UUID++;
        this.subject = identifier.split("[ ]")[0];
        this.number = identifier.split("[ ]")[1];
        this.title = title;
        this.creditHours = creditHours;
        this.sections = sections;
    }

    public Course(String identifier, String title, List<Section> sections) {
        this(identifier, title, 3, sections);
    }

    public Course(String identifier, String title) {
        this(identifier, title, 3, new ArrayList<Section>());
    }

    public Course(String identifier, String title, int creditHours) {
        this(identifier, title, creditHours, new ArrayList<Section>());
    }

    public String getSubject() {
        return subject;
    }

    public String getNumber() {
        return this.number;
    }

    public int getCreditHorus() {
        return this.creditHours;
    }

    public String getTitle() {
        return title;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public String getIdentifier() {
        return getSubject() + " " + getNumber();
    }

    public int getUUID() {
        return uuid;
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
        return this.getIdentifier().compareTo(o.getIdentifier());
    }
}