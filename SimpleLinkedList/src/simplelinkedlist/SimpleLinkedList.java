/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 3
 * SimpleLinkedList 
 * It is the a bare bones implementation of Linked List Data Struct, this class 
   can create a list, append things to the list, remove things from the list, 
   find out if certain elements are in the list and the size of the list. This 
   class allows users to do that in multiple ways in some cases, for example
   an element can be removed by value or a certain index
 */
package simplelinkedlist;

public class SimpleLinkedList {

    private static class Node {

        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private int size;

    // Constructor for empty SimpleLinked List
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    // Remove the first occurrence of the specified item from this linked list. 
    // If success, return true. Otherwise, return false.
    public boolean removeByValue(int item) {
        Node current = this.head;

        if (current != null) {
            // if head is not null checks if head.data equals item
            if (current.data == item) {
                this.head = current.next; // removes head if it is 
                this.size--;
                return true;
            } else {
                // loops through the list and stops at the second last element
                while (current.next != null) {
                    // checks if the next one is the one passed in
                    if (current.next.data == item) {
                        // if it is then it is removed
                        current.next = current.next.next;
                        this.size--;
                        return true;
                    }
                    current = current.next; // sets current to the next 
                }
            }
        }
        return false; // item not found
    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    // if index is size, append item to the end of this linked list.
    public void add(int index, int item) {
        Node current = this.head;
        Node newNode = new Node(item);
        int pos = 0;

        // checks if index passed in is valid
        if (index >= this.size || index < 0) {
            // loop though the list to the end and appends item there
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        } else if (index == 0) { 
            // if index is 0, sets head to the item 
            Node temp = this.head;
            this.head = newNode;
            this.head.next = temp;
        } else {
            // finds the position before the index passed in and add item there
            while (pos + 1 != index) {
                current = current.next; // continues the loop
                pos++; // keeps track of the position in the list
            }
            Node temp = current.next;
            current.next = newNode;
            current.next.next = temp;
        }
        this.size++; // updates the size 
    }

    //Get the integer item at the specified position and return the integer value. 
    //If the index is not valid return Integer.MIN_VALUE
    public int get(int index) {
        Node current = this.head;
        int pos = 0;

        // checks if index is valid (returns Integer.MIN_VALUE if not
        if (index >= this.size || index < 0) {
            System.out.println("Invalid index, index provided out of range");
            return Integer.MIN_VALUE;
        }
        
        // loops through til it finds the index
        while (current != null) {
            if (pos == index) {
                return current.data; // returns the item at index
            }
            pos++; // keeps track of position in list
            current = current.next; // continues the loop 
        }

        return Integer.MIN_VALUE; // noting was found
    }

    //Search this linked list for the first occurrence of the specified integer: item. 
    //If the item is found, return its index. Otherwise return -1.
    public int indexOf(int item) {
        int pos = 0;
        Node current = head;

        // loops through the list, stops if current.data is the equal to item
        while (current != null) {
            if (current.data == item) {
                return pos; // returns the index if item found 
            }
            current = current.next; // continues the loop 
            pos++; // keeps track of position in the list
        }

        return -1; // item not found 
    }

    //Find out if the specified integer: item is in this linked list. 
    // Returns true if yes, false otherwise.
    public boolean contains(int item) {
        Node current = this.head;
        // loops though entire list, stops if item is current.data
        while (current != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next; // continues the loop
        }
        return false; // item was not found
    }

    //return how many integers are in this linked list
    public int size() {
        return this.size;
    }

    //Remove the item at the specified position from this linked list and 
    //  return the removed item.
    //If the index is not valid, throw an exception or print an error message 
    //   and return Integer.MIN_VALUE.
    public int removeByIndex(int index) {
        Node current = this.head;
        int pos = 0;
        int value = Integer.MIN_VALUE;

        // checks if index is valid
        if (index >= this.size || index < 0) {
            System.out.println("Invalid index, index provided out of range");
        } else if (index == 0) {
            // if index is 0 then it removes head
            value = this.head.data;
            this.head = this.head.next;
            this.size--; // updates size 
        } else {
            // loops through the list til it reaches one before index
            while (pos + 1 != index) {
                current = current.next; // continues the loop 
                pos++; // keeps track of the position in the list
            }
            // gets value of Node, then deletes it
            value = current.next.data;
            current.next = current.next.next;
            this.size--; // updates size
        }

        return value; // returns value of Node removed or Integer.MIN_VALUE
    }

    // append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }

    //return a string that contains all integers (in the original sequence) in the linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
