package bugelli;

import java.util.HashSet;

/**
 * Creates and provides algorithms to test a Binary Search Tree
 * @author Lauren
 * @version 1.0
 * @since   09-20-2020 
 */
public class BinaryTree {
	Node root;
	
	/**
	 * Method to test if Binary tree is empty
	 * @return t/f boolean for empty tree or not
	 */
	public boolean isEmpty() {
		return root == null;
	}
	/**
	 * Recursive Method to add node
	 * @param current Node is referring to the Node being added
	 * @param value int is the value of the Node being added
	 * @return current Node return the added Node
	 */
	public Node addNode(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		
		if (value < current.n) {
			current.left = addNode(current.left, value);
		}else if (value > current.n) {
			current.right = addNode(current.right, value);
		}else {//value already exists in the tree
			return current;
		}
		return current;
	}
	/**
	 * Method to add node starting from the root
	 * @param value int value of node being added
	 */
	public void add(int value) {
		root = addNode(root, value); 
	}
	/**
	 * Method to create a sample BinaryTree
	 * @return bt BinaryTree sample Binary Tree that will be run through the tester
	 */
	public BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();
		
		bt.add(1);
		bt.add(2);
		bt.add(3);
		bt.add(4);
		bt.add(5);
		bt.add(6);
		bt.add(7);
		
		return bt;
	}
	/**
	 * Method to recursively delete a node
	 * @param current Node The current node being tested
	 * @param value int Value of the current Node being tested
	 * @return current Node
	 */
	public Node deleteNode(Node current, int value) {
		if(current == null) {
			return null;
		}
		if(value == current.n) {
			//IF NODE IS A LEAF NODE
			if (current.left == null && current.right == null) {
			    return null;
			}
			//IF NODE HAS ONE CHILD
			if (current.right == null) {
			    return current.left;
			}
			 
			if (current.left == null) {
			    return current.right;
			}
			//IF NODE HAS TWO CHILDREN
			int smallestValue = findSmallestValue(current.right);
			current.n = smallestValue;
			current.right = deleteNode(current.right, smallestValue);
			return current;
		}
		if(value < current.n) {
			current.left = deleteNode(current.left, value);
			return current;
		}
		current.right = deleteNode(current.right, value);
		return current;
	}
	/**
	 * Method to delete Node starting at root
	 * @param value
	 */
	public void delete (int value) {
		root = deleteNode(root, value);
	}
	/**
	 * Method used to find the smallest value currently in the bt
	 * @param root Node is the root of the Binary Tree
	 * @return value int The smallest value in the BinaryTree
	 */
	public int findSmallestValue(Node root) {
	    return root.left == null ? root.n : findSmallestValue(root.left);
	}
	/**
	 * Method to recursively travel through tree looking for a specific value
	 * @param current Node current Node being tested
	 * @param value int value of int being tested
	 * @return value int of the node in tree
	 */
	public boolean containsNode( Node current, int value) {
		if (current == null){
			return false;
		}
		if (value == current.n) {
			return true;
		}
		return value < current.n
			? containsNode(current.left, value)
			: containsNode(current.right, value);
	}
	/**
	 * Method that starts looking from the root
	 * @param value int value of node being looked for
	 * @return value int value of node found in tree
	 */
	public boolean lookForIt(int value) {
		return containsNode(root, value);
	}
	/**
	 * Method to print out binary tree
	 * @param node Node nodes are printed in order
	 */
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.n);
	        traverseInOrder(node.right);
	    }
	
	}
	/**
	 * Method used to find Parent Node recursivly
	 * @param current Node the current node being tested
	 * @param value int Value of the Node being tested
	 * @param parent int Value of the parent Node
	 * @return t/f boolean value weather a node has a parent of not
	 */
	public boolean findParent(Node current, int value, int parent) {
		//CHECK IF EMPTY
		if (current == null) 
	        return false; 
	  
	    //CHECK IF CURRENT IS PARENT 
	    if (current.n == value)  
	    { 
	  
	   //DOUBLE CHECK ROOT NODE IN CONSOLE JUST TO BE SURE
	        System.out.println("Parent of root should print as (-1) --> " + parent); //parent should return in console as -1
	    } 
	    else 
	    { 
	      
	    //MAKE CURRENT NODE PARENT TO KEEP CHECKING
	        findParent(current.left, value, current.n); 
	        findParent(current.right, value, current.n); 
	    } 
	    return true;
	}
	 /**
	  * Recursive Method to check for Duplicates
	  * @param root Node Started node to run check
	  * @param s HashSet Holds all values within the Binary Tree
	  * @return t/f boolean if value is duplicated within tree
	  */
    public boolean checkDuplicates(Node root, HashSet<Integer> s)  
    {   
    	//CHECK IF EMPTY
        if (root == null)  
            return false;  
    
        //CHECK IF DUPLICATE VALUE
        if (s.contains(root.n))  
            return true;  
    
        //INSERT NODE 
        s.add(root.n);  
        
        //RECURSIVLY RUN THROUGH LEFT AND RIGHT BRANCHES OF TREE  
        return checkDuplicates(root.left, s) || checkDuplicates(root.right, s);  
    }  
    
    /**
     * Method called by tester app to check for duplicate or cycles 
     * @param root Node starting node to be tested
     * @return t/f boolean to pass to the checkDuplicates method
     */
    public boolean checkForCycle(Node root)  
    {  
        HashSet<Integer> s=new HashSet<>(); 
        return checkDuplicates(root, s);  
    } 
    
    //A BINARY SEARCH TREE IS A BINARY TREE THAT IS CORRECTLY FORMATTED
    	//SMALL VALUES ON LEFT, LARGER VALUES ON RIGHT
    /**
     * Method called from tester to check if the tree is a Binary search tree
     * @return t/f boolean weather a tree is formated correctly
     */
    public boolean isConsistant()  { 
        return correctFormat(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    } 
  
    /**
     * Method to test binary search tree method, will return true if correct
     * @param node Node root where testing will start
     * @param min int The minimum value in tree
     * @param max int The maximum value in tree
     * @return t/f boolean if tree is BST or Not
     */
    public boolean correctFormat(Node node, int min, int max) 
    { 
      	//CHECK IF TREE IS EMPTY
        if (node == null) 
            return true; 
  
        //IF NODE FALLS OUTSIDE MIN/MAX RANGE
        if (node.n < min || node.n > max) 
            return false; 
  
        //CONTINUE THROUGH TREE, DECRIMENTING CONSTRAINTS TO CHECK EACH NODE
        return (correctFormat(node.left, min, node.n-1) && correctFormat(node.right, node.n+1, max)); 
    }  
}
