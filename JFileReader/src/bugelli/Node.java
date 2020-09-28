package bugelli;

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
	 * @return the n
	 */
	public double getN() {
		return n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(double n) {
		this.n = n;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
