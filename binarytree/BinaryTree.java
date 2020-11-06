/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 5
 * BinaryTree 
 * Implementation of a Binary Tree, a collection of nodes, each node has a value
   and "points" to two other nodes, left and right, left being smaller than the 
   value of the data of the current node and right being greater than the value of 
   data of the current node. There are many methods such as preorder traversal, 
   inorder treversal and postorder terversal, which traverse throught the tree 
   differently and size, which returns the number of nodes, and height, which 
   returns the height of the tree. 
 */
package binarytree;

import java.util.Scanner;

public class BinaryTree<E> {

    public static void main(String[] args) {
        // plus node
        Node<Character> x = new Node<>('x');
        Node<Character> y = new Node<>('y');
        Node<Character> plus = new Node<>('+');
        plus.left = x;
        plus.right = y;

        // divide node
        Node<Character> a = new Node<>('a');
        Node<Character> b = new Node<>('b');
        Node<Character> divide = new Node<>('/');
        divide.left = a;
        divide.right = b;

        // root node
        Node<Character> multiply = new Node<>('*');
        multiply.left = plus;
        multiply.right = divide;

        //BinaryTree<Character> exprBT = new BinaryTree<>(plus);
        BinaryTree<Character> exprBT2 = new BinaryTree<>();
        exprBT2.root = multiply;
        System.out.println(exprBT2.toString()); // Prints out the tree

        //System.out.println(exprBT2.preOrderTraverse());
        //System.out.println(exprBT2.inOrderTraverse());
        //System.out.println(exprBT2.postOrderTraverse());
        //System.out.println(exprBT2.size());
        //System.out.println(exprBT2.height());
    }

    // return string based on preorder traversal of the tree
    public String preOrderTraverse() {
        StringBuilder treeString = new StringBuilder();
        preOrderTraverse(root, treeString);
        return treeString.toString();
    }

    // private counterpart where recursively constructs the string
    private void preOrderTraverse(Node<E> currentRoot,
            StringBuilder currentResultSB) {
        if (currentRoot == null) {
            return;
        }

        String currentRootString = "  " + currentRoot.data;
        currentResultSB.append(currentRootString);

        preOrderTraverse(currentRoot.left, currentResultSB);
        preOrderTraverse(currentRoot.right, currentResultSB);
    }

    // return string based on inorder traversal of the tree
    public String inOrderTraverse() {
        StringBuilder treeString = new StringBuilder();
        inOrderTraverse(root, treeString);
        return treeString.toString();
    }

    // private counterpart where recursively constructs the string
    private void inOrderTraverse(Node<E> currentRoot,
            StringBuilder currentResultSB) {
        if (currentRoot == null) {
            return;
        }

        inOrderTraverse(currentRoot.left, currentResultSB);

        String currentRootString = "  " + currentRoot.data;
        currentResultSB.append(currentRootString);

        inOrderTraverse(currentRoot.right, currentResultSB);
    }

    // return string based on postorder traversal of the tree
    public String postOrderTraverse() {
        StringBuilder treeString = new StringBuilder();
        postOrderTraverse(root, treeString);
        return treeString.toString();
    }

    // private counterpart where recursively constructs the string
    private void postOrderTraverse(Node<E> currentRoot,
            StringBuilder currentResultSB) {
        if (currentRoot == null) {
            return;
        }

        postOrderTraverse(currentRoot.left, currentResultSB);
        postOrderTraverse(currentRoot.right, currentResultSB);

        String currentRootString = "  " + currentRoot.data;
        currentResultSB.append(currentRootString);
    }

    // return the number of nodes in the tree
    public int size() {
        return size(root);
    }

    // private counterpart that calculates the number of nodes recursively
    private int size(Node<E> currentRoot) {
        if (currentRoot == null) {
            return 0;
        }

        int treeSize = 1;

        treeSize += size(currentRoot.left);
        treeSize += size(currentRoot.right);

        return treeSize;
    }

    // returns the height of the tree 
    public int height() {
        return height(root);
    }

    // private counterpart that calculates the height of the tree
    private int height(Node<E> currentRoot) {
        if (currentRoot == null) {
            return 0;
        }

        int leftTreeHeight = height(currentRoot.left);
        int rightTreeHeight = height(currentRoot.right);

        return (leftTreeHeight < rightTreeHeight)
                ? (rightTreeHeight + 1) : (leftTreeHeight + 1);
    }

    protected static class Node<E> {

        protected E data; // value stored in node
        protected Node<E> left; // a node with data less than root data
        protected Node<E> right; // a node with data greater than root data

        // Constructors
        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        //This constructor should be protected, not public,
        // because classes that are not subclasses of BinaryTree do not directly use Node.
        protected Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        //must be public because it overrides what's in class Object.
        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Data Field
    /**
     * The root of the binary tree
     */
    //use the access modifier protected to give family member classes the direct access
    //   to the root data field.
    protected Node<E> root;

    /**
     * Construct an empty BinaryTree1
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a BinaryTree1 with a specified root. Should only be used by
     * subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    //Use the access modifier protected because we want to hide details of Node class
    //   from non-family member classes (i.e. classes that are not subclasses of BinaryTree).
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree as its left
     * subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
            BinaryTree<E> rightTree) {
        root = new Node<E>(data);           //new node: right, left are both null
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;               //don't have to do this, root.left is already null
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;              //don't have to do this, root.right is already null.
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or the left subtree
     * is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) { //if there is a left subtree
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or null if either the root or the right
     * subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {   //if there is a right subtree
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data in the root node
     *
     * @return the data in the root node or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        //empty tree or 1-node tree
        return (root == null || (root.left == null && root.right == null));
    }

    /**
     * get a string containing all data items in this binary tree. The string is
     * a preorder traversal sequence of this binary tree.
     *
     * @return the preorder traversal sequence of this binary tree as a string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //call the private recursive method to do the real job.
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal of the binary tree rooted at node.
     *
     * @param node The local root (i.e. the current root node)
     * @param depth The depth of the local root
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
            StringBuilder sb) {
        //add a number of spaces that is proportial to the depth value
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {         //current root node does not exist
            sb.append("null\n");
        } else {
            sb.append(node.toString()); //add current root node's data
            sb.append("\n");
            //recursively preorder traverse the left subtree of current root node
            preOrderTraverse(node.left, depth + 1, sb);
            //recursively preorder traverse the right subtree of current root node            
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /**
     * Method to read a binary tree.
     *
     * @pre The input consists of a preorder traversal of the binary tree. The
     * line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) { //data (i.e. current root node's data) is "null"
            return null;
        } else {
            //recursively keep reading and building the left subtree of current root node until it's done.
            BinaryTree<String> leftTree = readBinaryTree(scan);
            //recursively keep reading and building the right subtree of current root node until it's done.
            BinaryTree<String> rightTree = readBinaryTree(scan);
            //build and return a new binary tree that has root data in variable data, leftTree as left subtree, rightTree as right subtree.
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }
}
