package com.sapob.client.data.component;

import java.util.List;

public class Professor {
    private final String name; 
    private double GPA;
    private double rating; 
    private List<Section> sections;

    public Professor(String name, double GPA, double rating, List<Section> sections) {
        this.name = name;
        this.GPA = GPA;
        this.rating = rating;
        this.sections = sections; 
    }

    public String getName() {
        return this.name;
    }

    public double getGPA() {
        return this.GPA;
    }

    public double getRating() {
        return this.rating; 
    }

    public List<Section> getSections() {
        return this.sections; 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if(!(o instanceof Professor))
            return false; 
        Professor a = (Professor)o;
        return this.name.equals(a.name) && this.GPA == a.GPA && this.rating == a.rating;
    }
}