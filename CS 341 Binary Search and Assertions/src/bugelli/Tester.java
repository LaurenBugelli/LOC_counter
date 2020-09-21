package bugelli;
/**
 * Tester app, runs assertions based of booleans in BinaryTree class
 * @author Lauren
 * @version 1.0
 * @since   09-20-2020 
 */
public class Tester {

	public static void main(String[] args) {
		
//CREAT A BINARY TREE
		BinaryTree bt = new BinaryTree();
		bt = bt.createBinaryTree();
//PRINT OUT TREE BEFORE TESTING OCCURS BEFORE ANY DELETIONS OR ADDITIONS
		System.out.print("Binary Tree in Order, Before Testing:");
		bt.traverseInOrder(bt.root);
		System.out.print("\n");
		
	//For this test app the tree contains values: 1-7		
		//Test if Tree is empty
		if(!bt.isEmpty()) {
			assert true;
		}
		
		//Test addNode
		bt.add(8);
		if(bt.lookForIt(8)) {
			assert true;
		}else
			assert false : "Value 8 not found";
		
		//Test deleteNode
		bt.delete(2);
		if(!bt.lookForIt(2)) {
			assert true;
		}else
			assert false : "Value 2 is still in Tree";
		
		//Test if root has a parent, console will print -1 if run correctly
		if(bt.findParent(bt.root, 1, -1)) {
			assert true;
		}else
			assert false : "Root has a parent, oops";
		
		//Test Cycle
			//Purposely add duplicate value to tree
		bt.add(4); //My recursive addNode method should not allow duplicate values to be added
		if(!bt.checkForCycle(bt.root)) {
			assert true;
		}else
			assert false : "There is a Duplicate Value in Tree";
		
		if(bt.isConsistant()) {
			assert true;
		}else
			assert false : "This BST is not formatted correctly";
		
//PRINT TREE AFTER NODE DELETION< NODE ADITION< AND OTHER TESTING
		System.out.print("Binary Tree in Order, After Testing:");
		bt.traverseInOrder(bt.root);
//PRINT IF ALL ASSERTIONS WHERE SUCCESSFUL
		System.out.println("\nTesting was: SUCCESSFUL");
	}
	

}
