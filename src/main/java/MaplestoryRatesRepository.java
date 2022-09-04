import Model.Entry;
import Model.Map;
import Model.MaplestoryClass;
import Service.EntryService;
import Service.MapService;
import Service.MaplestoryClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaplestoryRatesRepository {
    public static void main(String[] args) {
        EntryService es = new EntryService();
        MapService ms = new MapService();
        MaplestoryClassService mcs = new MaplestoryClassService();

        List<Entry> entries = es.getAllEntries();
        List<Map> maps = ms.getAllMaps();
        List<MaplestoryClass> classes = mcs.getAllClasses();

        // Command Line Menu
        // CRUD
        boolean inMenu = true;
        int menuSelection = 0;  // Default value, 0 = nothing selected
        Scanner input = new Scanner(System.in);
        while(inMenu) {
            // Menu options
            System.out.println("Choose a menu option:");
            System.out.println("1) Add");
            System.out.println("2) Delete");
            System.out.println("3) View");
            System.out.println("4) Exit");

            // Scanner input = new Scanner(System.in);
            menuSelection = input.nextInt();
            input.nextLine();

            switch(menuSelection) {
                case 1: // Add a new entry
                    // New entry id
                    int entryID = entries.size() + 1;

                    // Get class name
                    System.out.println("Class?");
                    String classInput = input.nextLine();
                    int classID = classes.size() + 1;
                    mcs.addClass(classID, classInput);

                    // Get map name and add to list of existing maps
                    System.out.println("Map?");
                    String mapInput = input.nextLine();
                    int mapID = maps.size() + 1;
                    ms.addMap(mapID, mapInput);

                    // Get mesos earned
                    // -2,000,000,000 <= mesosEarned <= 2,000,000,000
                    System.out.println("Total money earned? (0 - 2,000,000,000)");
                    String moneyInput = input.nextLine();
                    int money = Integer.parseInt(moneyInput);   // Convert to int

                    // Get exp earned
                    System.out.println("Total exp earned? (Percentage)");
                    String expInput = input.nextLine();
                    int exp = Integer.parseInt(expInput);   // Convert to int

                    // Get link to video
                    System.out.println("Video? (OPTIONAL)");
                    String videoInput = input.nextLine();

                    // Add entry to table
                    es.addEntry(entryID, classID, mapID, money, exp, videoInput);

                    // Update list of classes and maps
                    entries = es.getAllEntries();
                    classes = mcs.getAllClasses();
                    maps = ms.getAllMaps();

                    break;
                case 2: // Delete an existing entry
                    // Display currently existing entries for user to select
                    for(int i = 0; i < entries.size(); i++) {
                        System.out.println(entries.get(i));
                    }

                    // Get the id of entry user is trying to delete
                    System.out.println("ID of entry to delete");
                    int id = input.nextInt();

                    // Delete the entry
                    es.deleteEntry(id);

                    break;
                case 3: // Select filter
                    System.out.println("View by\n1) Class\n2) Map");

                    int filter = input.nextInt();
                    input.nextLine();

                    // 1 = Filter by CLASS
                    // 2 = Filter by MAP
                    switch(filter) {
                        case 1:
                            // Check if there are any classes in the database to view
                            if (classes.size() == 0) {
                                System.out.println("There are currently no entries to view\n");
                                break;
                            }

                            // Display all classes
                            for (int i = 0; i < classes.size(); i++) {
                                if (i > 0 && i % 4 == 0) {
                                    System.out.println();
                                }
                                System.out.format("%2d) %-25s ", classes.get(i).getClassID(), classes.get(i));
                            }
                            System.out.println();   // New line for formatting

                            System.out.println("Enter class id to view entries");
                            int currClass = input.nextInt();
                            input.nextLine();

                            // Database query to display all entries associated with selected class
                            List<Entry> allEntriesWithClassID = es.getAllEntriesByClassID(currClass);

                            if (allEntriesWithClassID.size() == 0) {    // Check if there are entries to display
                                System.out.println("There are no entries associated with this class\n");
                                break;
                            }

                            for (int i = 0; i < allEntriesWithClassID.size(); i++) {
                                System.out.println(allEntriesWithClassID.get(i));
                            }
                            System.out.println();   // New line for formatting

                            break;
                        case 2:
                            // Check if there are any maps in the database to view
                            if (maps.size() == 0) {
                                System.out.println("There are currently no entries to view\n");
                                break;
                            }

                            // Display current maps in database
                            for (int i = 0; i < maps.size(); i++) {
                                System.out.format("%d) %s\n", i, maps.get(i));
                            }

                            // Get Input
                            int currMap = input.nextInt();
                            input.nextLine();

                            // Database query to display all Model.Entry's associated with selected map
                            List<Entry> allEntriesWithMapID = es.getAllEntriesByMapID(currMap);

                            if (allEntriesWithMapID.size() == 0) {  // Check if there are entries to display
                                System.out.println("There are no entries associated with this map\n");
                                break;
                            }

                            for (int i = 0; i < allEntriesWithMapID.size(); i++) {
                                System.out.println(allEntriesWithMapID.get(i));
                            }
                            System.out.println();   // New line for formatting

                            break;
                        default:
                            System.out.println("Invalid selection");
                            break;
                    }

                    break;
                case 4: // Exit
                    System.out.println("Exiting program...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
            // input.close();
        }
    }
}
