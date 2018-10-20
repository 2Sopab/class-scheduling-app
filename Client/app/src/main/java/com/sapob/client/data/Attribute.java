public class Attribute {
    private int prefrence;
    private Section preferredSection; 

    public Attribute(int prefrence, Section preferredSection) {
        this.prefrence = prefrence;
        this.preferredSection = preferredSection;
    }

    public int getPrefrence() {
        return this.prefrence;
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
        return this.prefrence == a.prefrence && this.preferredSection.equals(a.preferredSection);
    }
}