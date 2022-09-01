package Model;// Represents an entry in the database

public class Entry {
    private int entryID;
    private int classID;
    private String mapName;
    private int money;
    private int exp;
    private String videoLink;

    public Entry(int entryID, int classID, String mapName, int money, int exp, String videoLink) {
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

    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
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
        return  "EntryID: " + this.entryID + "\n" +
                "Class: " + this.classID + "\n" +
                "Map: " + this.mapName + "\n" +
                "Money: " + this.money + "\n" +
                "Exp: " + this.exp + "\n" +
                "Video: " + this.videoLink + "\n";
    }
}
