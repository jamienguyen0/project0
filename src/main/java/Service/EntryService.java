package Service;

import DOA.EntryRepository;
import DOA.MapRepository;
import DOA.MaplestoryClassRepository;
import Model.Entry;

import java.util.List;

public class EntryService {
    EntryRepository er;

    public EntryService() {
        er = new EntryRepository();
    }

    public List<Entry> getAllEntries() {
        return er.getAllEntries();
    }

    public List<Entry> getAllEntriesByClassID(int id) {
        return er.getAllEntriesByClassID(id);
    }

    public List<Entry> getAllEntriesByMapID(int id) {
        return er.getAllEntriesByMapID(id);
    }

    public void addEntry(int entryID, String className, String mapName, int moneyEarned, int expEarned, String url) {
        Entry entry = er.getEntryByID(entryID);

        if (entry == null) {
            Entry newEntry = new Entry(entryID, className, mapName, moneyEarned, expEarned, url);
            er.addEntry(newEntry);
        }
    }
}
