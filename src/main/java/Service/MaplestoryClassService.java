package Service;

import DOA.MaplestoryClassRepository;

public class MaplestoryClassService {
    MaplestoryClassRepository mcr;

    public MaplestoryClassService() {
        mcr = new MaplestoryClassRepository();
    }

    public String getClassNameFromID(int id) {
        return mcr.getClassNameFromID(id);
    }
}
