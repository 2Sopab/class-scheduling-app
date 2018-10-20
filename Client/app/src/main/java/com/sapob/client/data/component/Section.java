package com.sapob.client.data.component;

import java.util.List;
import java.util.ArrayList;

public class Section {
    private String courseName;
    private List<Integer> CRN;
    private Professor prof;
    private int remainingSpace;
    private List<Block> blocks;
    private int rating;

    public Section(String courseName, ArrayList<Integer> CRN, Professor prof, int remainingSpace, List<Block> blocks, int rating) {
        this.courseName = courseName;
        this.CRN = CRN;
        this.prof = prof;
        this.remainingSpace = remainingSpace;
        this.blocks = blocks;
        this.rating = rating;
    }
    
    public String getCourseName() {
        return this.courseName;
    }

    public List<Integer> getCRN() {
        return this.CRN;
    }

    public Professor getProf() {
        return this.prof;
    }

    public int getRating() { return this.rating; }

    public int getRemainingSpace() {
        return this.remainingSpace;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public boolean isFull() {
        return remainingSpace <= 0; 
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Section)) {
            return false;
        }
        Section a = (Section)o;
        return this.CRN == a.CRN;
    }
}