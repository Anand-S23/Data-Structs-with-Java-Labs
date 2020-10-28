/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 4
 * HiringApp 
 * It is the program the user interacts with to keep track of their employee. 
   This includes the current employees, the applicants and the ex-employees. 
   The program hires and the fires the person based on senority and if that 
   person has already worked there before. 
 */
package hiringapp;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Scanner;

public class HiringApp {
    // private data fileds to make user interface code cleaner
    private static int currentScreen = 0;
    private static Queue<Person> applicationList = new LinkedList<Person>();
    private static ArrayDeque<Person> employeeList = new ArrayDeque<Person>();
    private static Queue<Person> firedList = new LinkedList<Person>();

    public static void main(String[] args) {
        // controls if the program is running
        boolean running = true;

        // keeps running until user quits
        while (running) {
            switch (currentScreen) {
                case 0:
                    optionScreen();
                    break;
                case 1:
                    applicationScreen();
                    break;
                case 2:
                    hireScreen();
                    break;
                case 3:
                    fireScreen();
                    break;
                case 4:
                    running = false; // breaks out of loop 
                    break;
                default: // if an invalid input goes to option screen
                    currentScreen = 0;
                    break;
            }
        }
    }

    // main menu screen which displays all the option user can do 
    public static void optionScreen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Action (1 to accept, 2 to hire, 3 to fire, 4 to quit): ");
        int input = sc.nextInt();
        currentScreen = input; // goes to the screen associated with that corresponds
    }

    // hire method
    public static void hireScreen() {
        if (!firedList.isEmpty()) { // checks fired list first
            Person newHire = firedList.remove();
            employeeList.add(newHire);
            System.out.println(newHire.getName() + " hired");
        } else if (!applicationList.isEmpty()) { // then the application list
            Person newHire = applicationList.remove();
            employeeList.add(newHire);
            System.out.println(newHire.getName() + " hired");
        } else { // if both empty then tells user that info
            System.out.println("Memo to Supervisor: There is nobody to hire");
        }

         System.out.println("");
        currentScreen = 0; // sets the screen back to option screen
    }

    //fire method
    public static void fireScreen() {
        if (!employeeList.isEmpty()) { // checks employee list
            // removes from eployee list and adds to fired list
            Person firedPerson = employeeList.pop();
            firedList.add(firedPerson);
            System.out.println(firedPerson.getName() + " fired");
        } else { // if empty then tells user that info
            System.out.println("Memo to supervisor: There is nobody to fire");
        }
        
        System.out.println("");
        currentScreen = 0; // sets the screen back to option screen
    }
    
    // accept applicants method
    public static void applicationScreen() {
        // get name and degree
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the applicant’s name, degree: ");
        String name = sc.next();
        String degree = sc.next(); 
        
        // gets the skills based on the number of skills
        ArrayList<String> skills = new ArrayList<String>();
        System.out.print("Enter the number of skills and the skill list: ");
        int numOfSkills = sc.nextInt();
        for (int i = 0; i < numOfSkills; ++i) {
            skills.add(sc.next());
        }
        
        // creates that person and adds to application list
        Person applicant = new Person(name, degree, skills); 
        applicationList.add(applicant);
        System.out.println("");
        
        currentScreen = 0; // sets the screen back to option screen
    }
}
