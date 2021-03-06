import java.util.LinkedList;

/**
 * Waitlist class
 * @author Jacob Tunning
 * @version 1
 */

public class Waitlist {
	//Data members
	private int size;
	private LinkedList<Node> list;
	
	/**
	 * Default constructor
	 */
	public Waitlist() {
		size = 0;
		list = new LinkedList();
	}
	
	/**
	 * Size method
	 * @return size 
	 */
	public int size() {
		return size;
	}
	
	/**
	 * isEmpty method
	 * @return true/false
	 */
	public boolean isEmpty() {
		return(size == 0);
	}
	
	/**
	 * dequeue method
	 * @return output(element that has highest priority)
	 */
	public String remove() throws QueueEmptyException {
		String output;
		sort();
		if(!isEmpty()) {
			size--;
			output = list.get(0).toString();
			list.remove(0);
			return output;	
		}else {
			throw new QueueEmptyException();
		}
	}
	
	/**
	 * enqueue method
	 * @param jobNum, priority
	 */
	public void insert(String name, Customer customer) {
		if(!find(customer)) {
			//Creates a new node with the given parameters
			Node n = new Node(name, customer);
			//Adds the node to the list
			list.add(n);
			//Increments the size
			size++;
		}else {
			System.out.println("This customer is already registered");
		}
	}
	
	/**
	 * sort method
	 * This method sorts the Waitlist so the highest priority letter is first
	 */
	void sort() {
		for(int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
	            if(list.get(i).customer.isHasRenewed() == false && list.get(j).customer.isHasRenewed() == true) {
	               Node temp = list.get(i);
	               list.set(i, list.get(j));
	               list.set(j, temp);
	            }
	         }
		}
	}
	
	/**
	 * printQueue method
	 * @return queueString(Waitlist items all printed out)
	 */
	public String printQueue(){
		sort();
		if(!isEmpty()) {
			String queueString = "";
			for(int i = 0; i < list.size(); i++) {
				
				queueString += list.get(i).customer.getName() + "\n";
			}
			return queueString;
		}else {
			return "Queue is Empty";
			}
		
	}
	
	/**
	 * This method searches for a customer by name
	 * @param name
	 * @return String
	 */
	public String search(String name) {
		sort();
		if(!isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).customer.getName().equals(name)) {
					return list.get(i).customer.toString();
				}
			} 
				return "Customer not found";
		}else {
			return "Waitlist is empty";
		}
	}
	
	/**
	 * Check to see if the customer object already exists 
	 * @param customer
	 * @return boolean
	 */
	boolean find(Customer customer) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).customer == customer) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This class represents the nodes that will be inserted into the list
	 * @author Jacob Tunning
	 * @version 1
	 */
	public class Node{
		public Node(String name, Customer customer) {
			this.name = name;
			this.customer = customer;
		}
		private String name;
		private Customer customer;
	}
	
	/**
	 * QueueEmptyException class
	 * @author Jacob Tunning
	 * @version 1
	 */
	public class QueueEmptyException extends Exception {
	}
}



