package Service;

import DOA.MapRepository;
import Model.Map;

import java.util.List;

public class MapService {
    MapRepository mr;

    public MapService() {
        mr = new MapRepository();
    }

    public MapService(MapRepository mr) {
        this.mr = mr;
    }

    public List<Map> getAllMaps() {
        return mr.getAllMaps();
    }

    public String getMapNameFromID(int id) {
        return mr.getMapNameFromID(id);
    }

    public void addMap(int mapID, String mapName) {
        Map map = mr.getMapByID(mapID);

        if (map == null) {
            Map newMap = new Map(mapID, mapName);
            mr.addMap(newMap);
        }
    }
}
