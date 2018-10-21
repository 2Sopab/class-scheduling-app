package com.sapob.client.data.component;

public class Section {
    private int CRN;
    private Professor prof;
    private int remainingSpace;
    private Block block;
    private double rating;
    private String id;

    public Section(String id, int CRN, Professor prof, int remainingSpace, Block block, double rating) {
        this.id = id;
        this.CRN = CRN;
        this.prof = prof;
        this.remainingSpace = remainingSpace;
        this.block = block;
        this.rating = rating;
    }

    public int getCRN() {
        return this.CRN;
    }

    public Professor getProf() {
        return this.prof;
    }

    public String getId() {
        return id;
    }

    public double getRating() { return this.rating; }

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

    public String getCourseName() {
        return this.getBlock().getCourse().getIdentifier();
    }
}