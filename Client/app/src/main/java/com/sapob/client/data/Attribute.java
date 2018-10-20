package com.sapob.client.data;

public class Attribute {
    private int preference;
    private Section preferredSection; 

    public Attribute(int preference, Section preferredSection) {
        this.preference = preference;
        this.preferredSection = preferredSection;
    }

    public int getPreference() {
        return this.preference;
    }

    public Section getPreferredSection() {
        return this.preferredSection;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Attribute)) {
            return false;
        }
        Attribute a = (Attribute)o;
        return this.preference == a.preference && this.preferredSection.equals(a.preferredSection);
    }
}