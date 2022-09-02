package Model;// Represents an entry in the database

public class Entry {
    private int entryID;
    private String classID;
    private String mapName;
    private int money;
    private int exp;
    private String videoLink;

    public Entry(int entryID, String classID, String mapName, int money, int exp, String videoLink) {
        this.entryID = entryID;
        this.classID = classID;
        this.mapName = mapName;
        this.money = money;
        this.exp = exp;
        this.videoLink = videoLink;
    }

    public int getEntryID() {
        return entryID;
    }

    public String getClassName() {
        return classID;
    }

    public void setClassName(String className) {
        this.classID = classID;
    }

    public String getMapName() {
        return mapName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "(" + entryID + ", " + classID + ", " + mapName + ", " + money + ", " + exp + ", " + videoLink + ")";
    }
}
