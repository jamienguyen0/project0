package Model;

public class Map {
    public static int mapCount = 0;
    private int mapID;
    private String mapName;

    public Map(int mapID, String mapName) {
        mapCount++;     // Update static counter to use for map id
        this.mapID = mapID;
        this.mapName = mapName;
    }

    public int getMapID() {
        return mapID;
    }

    public String getMapName() {
        return mapName;
    }

    @Override
    public String toString() {
        return "(" + this.mapID + ", " + this.mapName + ")";
    }
}
