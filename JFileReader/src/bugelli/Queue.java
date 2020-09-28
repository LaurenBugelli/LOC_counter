package bugelli;

public class Queue {
	private Node head;
	private Node tail;
	public double mean = 0;
	public double stanD = 0;

	/**
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
	public void addNode(int n) {
		if(head == null) {
			head = new Node(n);
			tail = this.head;

		}
		else if(head == tail) {
			tail = new Node(n);
			head.setNext(tail);
			tail.setPrev(head);
		}
		else{
			Node temp = new Node(n);
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
	}

	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * @param head the First Node in queue
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * @param tail the Last Node in Queue
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public int size() {
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
	 * print function that prints the list in order 
	 */
	public void showList() {
		Node current = head;
		
		while(current != tail) {
			System.out.println(current.getN());
			current = current.getNext();
		}
		// TAIL CALCULATION
		System.out.println(current.getN());
	}
	
	/**
	 * mean function will find mean of int in file
	 * 
	 * @param mean double stores value of Queue over Count
	 * @return mean is the mean of the LinkedList values 
	 */
	public double FindM() {
		Node current = head;
		
		while(current != tail) {
			mean += current.getN();
			current = current.getNext();
		}
		mean += current.getN();
		
		int count = size();
		mean /= count;
		
		return mean;
	}
	
	/**
	 * get_standard_deviation function returns the standard deviation from the LinkedList
	 * 
	 * @param mean double is the mean of the LinkedList
	 * @param current Node tracks through LinkedList
	 * @param sd double stores the standard deviation 
	 * @param count int is the size of the LinkedList
	 * @return sd the value of sd of ints in file
	 */
	public double findSD(double mean) {

		Node current = head;
		double sd = 0;
		
		while(current != tail) {
			sd += Math.pow((current.getN() - mean),2);
			current = current.getNext();
		}
		sd += Math.pow((current.getN() - mean),2);
		
		int count = size();
		sd /= count;
		sd = Math.sqrt(sd);

		return sd;
	}

}
