package bugelli;
/**
 * Creates a Node
 * @author Lauren
 * @version 1.0
 * @since   09-20-2020 
 */
public class Node {
	public int n;
	public Node left;
	public Node right;
	
	public Node(int n) {
		this.n = n;
		right = null;
		left = null;
	}
}
