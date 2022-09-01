package Model;

public class MaplestoryClass {
    private int classID;
    private String className;

    public MaplestoryClass(int classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    @Override
    public String toString() {
        return "(" + this.classID + ", " + this.className + ")";
    }
}
