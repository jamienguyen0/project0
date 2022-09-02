package Service;

import DOA.MapRepository;

public class MapService {
    MapRepository mr;

    public MapService() {
        mr = new MapRepository();
    }

    public MapService(MapRepository mr) {
        this.mr = mr;
    }

    public String getMapNameFromID(int id) {
        return mr.getMapNameFromID(id);
    }
}
