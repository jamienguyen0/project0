// Represents an entry in the database

public class Entry {
    private String charClass;
    private String mapName;
    private int money;
    private int exp;
    private String videoLink;

    public Entry(String charClass, String mapName, int money, int exp, String videoLink) {
        this.charClass = charClass;
        this.mapName = mapName;
        this.money = money;
        this.exp = exp;
        this.videoLink = videoLink;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
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
        return "Class: " + this.charClass + "\n" +
               "Map: " + this.mapName + "\n" +
               "Money: " + this.money + "\n" +
               "Exp: " + this.exp + "\n" +
               "Video: " + this.videoLink + "\n";
    }
}
