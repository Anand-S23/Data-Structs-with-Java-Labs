/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 3
 * SimpleLinkedListTest
 * Tests the SimpleLinkedList class by using different methods implemented in 
   the SimpleLinkedList class (each method is used twice one for valid and one 
   for invaild parameters)
 */
package simplelinkedlist;

public class SimpleLinkedListTest {

    public static void main(String[] args) {

        SimpleLinkedList numbers = new SimpleLinkedList();

        //append 3 integers
        numbers.add(10);
        numbers.add(30);
        numbers.add(40);
        // Add (int, int) 
        numbers.add(0, 0);
        numbers.add(1, 20);
        numbers.add(100, 50);
        numbers.add(1, 5);

        // prints the list and the size of the list
        System.out.println("\nList of size " + numbers.size() + ":");
        System.out.println(numbers);

        // Cotains 
        System.out.println("\nContains");
        System.out.println(numbers.contains(40));
        System.out.println(numbers.contains(100000));

        // Index Of 
        System.out.println("\nIndex Of");
        System.out.println(numbers.indexOf(20));
        System.out.println(numbers.indexOf(213834));

        // Get
        System.out.println("\nGet");
        System.out.println(numbers.get(5));
        System.out.println(numbers.get(-5));

        // Remove by Value
        System.out.println("\nRemove By Value");
        System.out.println(numbers.removeByValue(50));
        System.out.println(numbers.removeByValue(1332948));

        // Remove by Index
        System.out.println("\nRemove By Index");
        System.out.println(numbers.removeByIndex(1));
        System.out.println(numbers.removeByIndex(-19));

        // Prints the list and the size of the list
        System.out.println("\nList of size " + numbers.size() + ":");
        System.out.println(numbers);
    }

}
