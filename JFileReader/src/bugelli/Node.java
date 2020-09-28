package bugelli;
/**
 * Node class with setters and getters for current node, next, and prev
 * @author Lauren
 * @since 9/27/20
 */
public class Node {
	private double n;
	private Node next;
	private Node prev;
	
	public Node(double n) {
		this.n = n;
		this.next = null;
		this.prev = null;
	}

	/**
	 * @return n get node
	 */
	public double getNode() {
		return n;
	}

	/**
	 * @param n set node
	 */
	public void setNode(double n) {
		this.n = n;
	}

	/**
	 * @return get next node
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param set next node
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return get prev node
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * @param set prev node 
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
