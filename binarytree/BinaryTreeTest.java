/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 5
 * BinaryTreeTest 
 * It is the program that tests the methods in the binary tree by first
   constructing the tree by reading structure from file, then prints out the 
   results of the methods such as traversal, size and height
 */
package binarytree;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree1 = new BinaryTree<>();
        BinaryTree<String> treeWordBT = new BinaryTree<>();

        try {
            Scanner file = new Scanner(new File("WordBT_Data.txt")); // get the contence of the file
            treeWordBT = BinaryTree.readBinaryTree(file); // gets the data and constructs it into tree
            file.close(); // closes file

            Scanner input = new Scanner(new File("Fig_6_12.txt"));
            binaryTree1 = BinaryTree.readBinaryTree(input);
            input.close();

            // Prints out all of the methods
            System.out.println(treeWordBT.toString());
            System.out.println("Preorder traversal:" + treeWordBT.preOrderTraverse());
            System.out.println("Inorder traversal:" + treeWordBT.inOrderTraverse());
            System.out.println("Postorder traversal:" + treeWordBT.postOrderTraverse());
            System.out.println("Size: " + treeWordBT.size());
            System.out.println("Height: " + treeWordBT.height());
            // System.out.println(binaryTree1);
        } catch (FileNotFoundException e) { //handle the case when Fig_6_12.txt is not found.
            e.printStackTrace();    //Print the error stack: this exception, and its backtrace for the cause of this exception.
            System.exit(1);         //terminate this program with the status code 1, indicating abnormal termination.
        }
    }
}
