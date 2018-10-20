package com.sapob.client.data.component;

import java.util.ArrayList;
import java.util.List;

public class Course implements Comparable<Course> {
    private String subject;
    private String number;
    private int creditHours;
    private String title;
    private List<Block> blocks;
    private final int uuid;
    private static int LAST_UUID = 0;

    public Course(String identifier, String title, int creditHours, List<Block> blocks) {
        uuid = LAST_UUID++;
        this.subject = identifier.split("[ ]")[0];
        this.number = identifier.split("[ ]")[1];
        this.title = title;
        this.creditHours = creditHours;
        this.blocks = blocks;
    }

    public Course(String identifier, String title, List<Block> blocks) {
        this(identifier, title, 3, blocks);
    }

    public Course(String identifier, String title) {
        this(identifier, title, 3, new ArrayList<Block>());
    }

    public Course(String identifier, String title, int creditHours) {
        this(identifier, title, creditHours, new ArrayList<Block>());
    }

    public String getSubject() {
        return subject;
    }

    public String getNumber() {
        return this.number;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public String getTitle() {
        return title;
    }

    public List<Block> getBlocks() {
        return this.blocks;
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
        return this.subject.equals(a.subject) && this.number.equals(a.number);
    }

    @Override
    public int compareTo(Course o) {
        return this.getIdentifier().compareTo(o.getIdentifier());
    }
}