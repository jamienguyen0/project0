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
            System.out.println("Choose a menu option");
            System.out.println("1) Add");
            System.out.println("2) View");
            System.out.println("3) Exit");

            // Scanner input = new Scanner(System.in);
            menuSelection = input.nextInt();
            input.nextLine();

            switch(menuSelection) {
                case 1: // Add a new entry
                    // Get class name
                    System.out.println("Class?");
                    String classInput = input.nextLine();
                    mcs.addClass(classes.size()+1, classInput);

                    // Get map name and add to list of existing maps
                    System.out.println("Map?");
                    String mapInput = input.nextLine();
                    ms.addMap(maps.size()+1, mapInput);

                    // Get mesos earned
                    // -2,000,000,000 <= mesosEarned <= 2,000,000,000
                    System.out.println("Total money earned?");
                    String moneyInput = input.nextLine();
                    int money = Integer.parseInt(moneyInput);   // Convert to int

                    // Get exp earned
                    System.out.println("Total exp earned?");
                    String expInput = input.nextLine();
                    int exp = Integer.parseInt(expInput);   // Convert to int

                    // Get link to video
                    System.out.println("Rotation video? (OPTIONAL)");
                    String videoInput = input.nextLine();

                    // Add entry to table
                    es.addEntry(entries.size()+1, classInput, mapInput, money, exp, videoInput);

                    // Update list of classes and maps
                    entries = es.getAllEntries();
                    classes = mcs.getAllClasses();
                    maps = ms.getAllMaps();

                    break;
                case 2: // Select filter
                    System.out.println("View by\n1) Class\n2) Map");

                    int filter = input.nextInt();
                    input.nextLine();

                    // 1 = Filter by CLASS
                    // 2 = Filter by MAP
                    switch(filter) {
                        case 1:
                            // Display all classes
                            for (int i = 0; i < classes.size(); i++) {
                                if (i > 0 && i % 4 == 0) {
                                    System.out.println();
                                }
                                System.out.format("%2d) %-25s ", classes.get(i).getClassID(), classes.get(i));
                            }
                            System.out.println();   // New line for formatting

                            // 0-48
                            int currClass = input.nextInt();
                            input.nextLine();

                            // Database query to display all Model.Entry's associated with selected class
                            List<Entry> allEntriesWithClassID = es.getAllEntriesByClassID(currClass);
                            for (int i = 0; i < allEntriesWithClassID.size(); i++) {
                                System.out.println(allEntriesWithClassID.get(i));
                            }
                            System.out.println();   // New line for formatting

                            break;
                        case 2:
                            // Display current maps in database
                            for (int i = 0; i < maps.size(); i++) {
                                System.out.format("%d) %s\n", i, maps.get(i));
                            }

                            // Get Input
                            int currMap = input.nextInt();
                            input.nextLine();

                            // Database query to display all Model.Entry's associated with selected map
                            List<Entry> allEntriesWithMapID = es.getAllEntriesByMapID(currMap);
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
                case 3: // Exit
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
