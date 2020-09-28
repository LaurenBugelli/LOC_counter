package bugelli;
/**
 * Queue class, ie LinkedList class that will hold values from file
 * @author Lauren
 * @since 9/27/20
 */
public class Queue {
	private Node head;
	private Node tail;
	public double mean = 0;
	public double stanD = 0;

	/**
	 * Constructor
	 * @param head Node is the pointer for head
	 * @param tail Node is the pointer for tail 
	 * 
	 */
	public Queue() {
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * addNode function will add a Node to the Queue
	 *  
	 * @param n int stores value of node in Queue
	 */
	public void addNode(double n) {
		//IS QUEUE EMPTY?
		if(head == null) {
			head = new Node(n);
			tail = this.head;

		}
		//IS THERE ONLY ONE NODE IN QUEUE
		else if(head == tail) {
			tail = new Node(n);
			head.setNext(tail);
			tail.setPrev(head);
		}
		//IF QUEUE IS POPULATED WITH MORE THAN ONE
		else{
			Node temp = new Node(n);
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
	}

	/**
	 * getHead will return the first Node in the Queue
	 * @return the head, get head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * setHead will set the pointer to the first node in the Queue
	 * @param head set the First Node in queue
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * getTail will return the last Node in the Queue
	 * @return get the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * setTail will set the pointer to the last node in the Queue
	 * @param tail set the Last Node in Queue
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}
	/**
	 * length method will find the amount of nodes in Queue, important for finding mean and sd
	 * @return
	 */
	public int length() {
		Node current = head;
		int count = 0;
		while(current != tail) {
			count++;
			current = current.getNext();
		}
		count++;
		
		return count;
	}
	/**
	 * mean method will find mean of values in file
	 * 
	 * @param mean double stores value of Queue over Count
	 * @return mean is the mean of values in file 
	 */
	public double FindM() {
		//iterator
		Node current = head;
		//Loop through queue
		while(current != tail) {
			mean += current.getNode();
			current = current.getNext();
		}
		mean += current.getNode();
		
		int count = length();
		mean /= count;
		
		return mean;
	}
	
	/**
	 * standard deviation method returns the standard deviation from values in file
	 * 
	 * @param mean double is the mean of the values in file
	 * @param current Node tracks through queue
	 * @param sd double stores the standard deviation of the values in file 
	 * @param count int is the size of the Queue
	 * @return sd double the value of sd of values in file
	 */
	public double findSD(double mean) {
		//iterator
		Node current = head;
		double sd = 0;
		//Loop through queue
		while(current != tail) {
			sd += Math.pow((current.getNode() - mean),2);
			current = current.getNext();
		}
		sd += Math.pow((current.getNode() - mean),2);
		
		int count = length();
		sd /= count;
		sd = Math.sqrt(sd);

		return sd;
	}

}
