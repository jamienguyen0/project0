package Service;

import DOA.MaplestoryClassRepository;

public class MaplestoryClassService {
    MaplestoryClassRepository mcr;

    public MaplestoryClassService() {
        mcr = new MaplestoryClassRepository();
    }

    public MaplestoryClassService(MaplestoryClassRepository mcr) {
        this.mcr = mcr;
    }

    public String getClassNameFromID(int id) {
        return mcr.getClassNameFromID(id);
    }
}
