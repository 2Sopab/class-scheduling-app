package com.sapob.client.data.component;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.ArrayList;

>>>>>>> 0dfee5b0307c610fe463de768c04769cfc29faca
public class Section {
    private String courseName;
    private List<Integer> CRN;
    private Professor prof;
    private int remainingSpace;
<<<<<<< HEAD
    private Block block;

    public Section(Course courseName, int CRN, Professor prof, int remainingSpace, Block block) {
=======
    private List<Block> blocks;
    private int rating;

    public Section(String courseName, ArrayList<Integer> CRN, Professor prof, int remainingSpace, List<Block> blocks, int rating) {
>>>>>>> 0dfee5b0307c610fe463de768c04769cfc29faca
        this.courseName = courseName;
        this.CRN = CRN;
        this.prof = prof;
        this.remainingSpace = remainingSpace;
<<<<<<< HEAD
        this.block = block;
=======
        this.blocks = blocks;
        this.rating = rating;
>>>>>>> 0dfee5b0307c610fe463de768c04769cfc29faca
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