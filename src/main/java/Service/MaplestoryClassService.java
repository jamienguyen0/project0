package Service;

import DOA.MaplestoryClassRepository;
import Model.MaplestoryClass;

import java.util.List;

public class MaplestoryClassService {
    MaplestoryClassRepository mcr;

    public MaplestoryClassService() {
        mcr = new MaplestoryClassRepository();
    }

    public MaplestoryClassService(MaplestoryClassRepository mcr) {
        this.mcr = mcr;
    }

    public List<MaplestoryClass> getAllClasses() {
        return mcr.getAllClasses();
    }

    public String getClassNameFromID(int id) {
        return mcr.getClassNameFromID(id);
    }

    public int getClassIDFromName(String name) {
        return mcr.getClassIDFromName(name);
    }

    public void addClass(int id, String name) {
        MaplestoryClass existingClass = mcr.getClassByID(id);

        if (existingClass == null) {
            MaplestoryClass newClass = new MaplestoryClass(id, name);
            mcr.addClass(newClass);
        }
    }
}
