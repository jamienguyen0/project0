package Model;

public class Map {
    private int mapID;
    private String mapName;

    public Map(int mapID, String mapName) {
        this.mapID = mapID;
        this.mapName = mapName;
    }

    @Override
    public String toString() {
        return "(" + this.mapID + ", " + this.mapName + ")";
    }
}
