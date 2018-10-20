package com.sapob.client.data.component;

public class Section {
    private Course courseName;
    private int CRN; 
    private Professor prof;
    private int remainingSpace;
    private Block block;

    public Section(Course courseName, int CRN, Professor prof, int remainingSpace, Block block) {
        this.courseName = courseName;
        this.CRN = CRN;
        this.prof = prof;
        this.remainingSpace = remainingSpace;
        this.block = block;
    }
    
    public Course getCourseName() {
        return this.courseName;
    }

    public int getCRN() {
        return this.CRN;
    }

    public Professor getProf() {
        return this.prof;
    }

    public int getRemainingSpace() {
        return this.remainingSpace;
    }

    public Block getBlock() {
        return this.block;
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