import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String[] classes = {"Adele", "Angelic Buster", "Aran", "Ark", "Battle Mage", "Beast Tamer", "Bishop",
                                  "Blaster", "Blaze Wizard", "Bowmaster", "Buccaneer", "Cadena", "Cannonneer", "Corsair",
                                  "Dark Knight", "Dawn WArrior", "Demon Avenger", "Demon Slayer", "Dual Blade", "Evan",
                                  "Hayato", "Hero", "Hoyoung", "Illium", "Jett", "Kain", "Kaiser", "Kanna", "Kinesis", "Lara",
                                  "Luminous", "Fire Poison", "Ice Lightning", "Marksman", "Mechanic", "Mihile", "Mercedes",
                                  "Night Lord", "Night Walker", "Paladin", "Pathfinder", "Phantom", "Shade", "Shadower",
                                  "Thunder Breaker", "Wild Hunter", "Wind Archer", "Xenon", "Zero"};
        List<String> maps = new ArrayList<String>();


        // Command Line Menu
        boolean inMenu = true;
        int menuSelection = 0;  // Default value, 0 = nothing selected
        while(inMenu) {
            // Menu options
            System.out.println("Choose a menu option");
            System.out.println("1) Add");
            System.out.println("2) View");
            System.out.println("3) Exit");

            Scanner input = new Scanner(System.in);
            menuSelection = input.nextInt();

            switch(menuSelection) {
                case 1: // Add a new entry
                    Scanner newEntryInput = new Scanner(System.in);

                    // Get class name
                    System.out.println("Class?");
                    String classInput = newEntryInput.nextLine();

                    // Get map name and add to list of existing maps
                    System.out.println("Map?");
                    String mapInput = newEntryInput.nextLine();
                    maps.add(mapInput);

                    // Get mesos earned
                    System.out.println("Total mesos earned?");
                    String mesosInput = newEntryInput.nextLine();

                    // Get exp earned
                    System.out.println("Total exp earned?");
                    String expInput = newEntryInput.nextLine();

                    // Get link to video
                    System.out.println("Rotation video? (OPTIONAL)");
                    String videoInput = newEntryInput.nextLine();

                    // Add entry to table


                    break;
                case 2: // Select filter
                    System.out.println("View by\n1) Class\n2) Map");
                    // Scanner
                    Scanner filterInput = new Scanner(System.in);
                    int filter = filterInput.nextInt();
                    filterInput.nextLine();

                    // 1 = Filter by CLASS
                    // 2 = Filter by MAP
                    switch(filter) {
                        case 1:
                            // Display all classes
                            for (int i = 0; i < classes.length; i++) {
                                System.out.format("%d) %s\n", i, classes[i]);
                            }

                            // Get input

                            // Display

                            break;
                        case 2:
                            // Display current maps in database
                            for (int i = 0; i < maps.size(); i++) {
                                System.out.format("%d) %s\n", i, maps.get(i));
                            }

                            // Get Input

                            // Display

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
        }
    }
}
