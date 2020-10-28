/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 2
 * VideoGameCollection 
 * It is the program the user interacts with to store their games. Allows them
   to input data about the game, append them to the list, remove them from the 
   list, print out all the list, print out the game with the latest release. 
 */
package videogamecollection;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class VideoGameCollection {
    // Data fields that need to be accessible to all funtions in the class
    private static int currentScreen = 0;
    private static LinkedList<VideoGame> gameList = new LinkedList<VideoGame>();
    private static boolean running = true;

    // The main function which gets run first when code is run
    public static void main(String[] args) {
        System.out.println("**** Welcome to Video Game Management Tool *****");
        
        // Runs while running is true (running is false when user inputs 5)
        while (running) {
            switch (currentScreen) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    addGame();
                    break;
                case 2:
                    removeGame();
                    break;
                case 3:
                    printList();
                    break;
                case 4:
                    latestRelease();
                    break;
                case 5:
                    running = false;
                    break;
                default: 
                    mainMenu(); 
                    break;
            }
        }
    }

    // Allows users to input a number and calls the funtion related to that function
    public static void mainMenu() {
        System.out.println("-------- Menu -------- ");
        System.out.println("1. Add a new game ");
        System.out.println("2. Remove an existing game ");
        System.out.println("3. Display the games in the order they were inserted");
        System.out.println("4. Find game with latest release ");
        System.out.println("5. Exit ");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number corresponded to what you would like to do: ");
        int input = sc.nextInt();
        currentScreen = input;
        System.out.println("");
    }

    // Allows user to input data to create VideoGame and adds it to the LinkedList
    public static void addGame() {
        System.out.println("--- Add Game --- ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the game title: ");
        String title = sc.nextLine();

        System.out.print("Enter the lead developer: ");
        String developer = sc.nextLine();

        System.out.print("Enter number of platforms: ");
        int numOfPlatforms = sc.nextInt();
        String[] platforms = new String[numOfPlatforms];
        sc.nextLine();
        for (int i = 0; i < numOfPlatforms; ++i) {
            System.out.print("Enter a platform: ");
            String platform = sc.nextLine();
            platforms[i] = platform;
        }

        System.out.print("Enter the release date (YYYY-MM-DD): ");
        String dateString = sc.nextLine();
        LocalDate date = LocalDate.parse(dateString);

        VideoGame game = new VideoGame(title, developer, platforms, date);
        gameList.add(game);
        System.out.println("");
        currentScreen = 0;
    }

    // Allows user to input title of game and removes game from the LinkedList
    public static void removeGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title of the game you wnat to remove: ");
        String title = sc.nextLine();

        LinkedList<VideoGame> cloneList = (LinkedList<VideoGame>) gameList.clone();
        Iterator<VideoGame> iterator = cloneList.iterator();

        // iterates  through copy of the LinkedList and removes from actual list
        while (iterator.hasNext()) {
            VideoGame game = iterator.next();
            if (game.getTitle().equals(title)) {
                gameList.remove(game);
            }
        }

        System.out.println("");
        currentScreen = 0;
    }

    // Prints out all the VideoGames in the list (calls their toString)
    public static void printList() {
        Iterator<VideoGame> iterator = gameList.iterator();

        while (iterator.hasNext()) {
            VideoGame game = iterator.next();
            System.out.println(game);
        }

        System.out.println("");
        currentScreen = 0;
    }

    // Prints out the VideoGame data is the latest date of release
    public static void latestRelease() {
        Iterator<VideoGame> iterator = gameList.iterator();
        VideoGame latest = gameList.getFirst();

        // iterates through and each iteration check if current came after
        while (iterator.hasNext()) {
            VideoGame current = iterator.next();
            if (current.getReleaseDate().isAfter(latest.getReleaseDate())) {
                latest = current;
            }
        }

        System.out.println(latest);
        System.out.println("");
        currentScreen = 0;
    }
}
