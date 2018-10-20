public class Section {
    private Course courseName; 
    private int CRN; 
    private Professor prof;
    private int remainingSpace;
    private Arraylist<Block> blocks; 

    public Section(String courseName, int CRN, Professor prof, int remainingSpace, Arraylist<Block> blocks) {
        this.courseName = courseName;
        this.CRN = CRN;
        this.prof = prof;
        this.remainingSpace = remainingSpace;
        this.blocks = blocks; 
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

    public ArrayList<Block> getBlocks() {
        return this.blocks;
    }

    public boolean isFull() {
        return remainingSpace <= 0; 
    }

    @Ovveride 
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