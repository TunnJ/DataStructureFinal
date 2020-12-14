import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void sizeTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob Tunning", 19, "jacob.tunning@gmail.com", true);
		int expected  = 1;
		//Act
		waitlist.insert("Jacob", customer);
		//Assert
		assertEquals(expected, waitlist.size());
	}

	@Test
	void emptyTrueTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		boolean expected = true;
		//Assert
		assertEquals(expected, waitlist.isEmpty());
	}
	
	@Test
	void emptyFalseTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob Tunning", 19, "jacob.tunning@gmail.com", true);
		boolean expected = false;
		//Act
		waitlist.insert("Jacob", customer);
		//Assert
		assertEquals(expected, waitlist.isEmpty());
	}
	
	@Test
	void peekTest() throws Waitlist.QueueEmptyException {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob Tunning", 19, "jacob.tunning@gmail.com", true);
		int expected  = 0;
		//Act
		waitlist.insert("Jacob", customer);
		waitlist.remove();
		//Assert
		assertEquals(expected, waitlist.size());
	}
	
	@Test
	void sortTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob", 19, "jacob.tunning@gmail.com", false);
		Customer customer2 = new Customer("Bob", 20, "bob@gmail.com", true);
		String expected = "Bob\nJacob\n";
		//Act
		waitlist.insert("Jacob", customer);
		waitlist.insert("Bob", customer2);
		waitlist.sort();
		//Assert
		assertEquals(expected, waitlist.printQueue());
	}
	
	@Test
	void searchTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob", 19, "jacob.tunning@gmail.com", false);
		Customer customer2 = new Customer("Bob", 20, "bob@gmail.com", true);
		String expected = customer.toString();
		//Act
		waitlist.insert("Jacob", customer);
		waitlist.insert("Bob", customer2);
		//Assert
		assertEquals(expected, waitlist.search("Jacob"));
	}
	
	@Test
	void findTrueTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob", 19, "jacob.tunning@gmail.com", false);
		boolean expected = true;
		//Act
		waitlist.insert("Jacob", customer);
		//Assert
		assertEquals(expected, waitlist.find(customer));
	}
	
	@Test
	void findFalseTest() {
		//Arrange
		Waitlist waitlist = new Waitlist();
		Customer customer = new Customer("Jacob", 19, "jacob.tunning@gmail.com", false);
		Customer customer2 = new Customer("Bob", 20, "bob@gmail.com", true);
		boolean expected = false;
		//Act
		waitlist.insert("Jacob", customer);
		//Assert
		assertEquals(expected, waitlist.find(customer2));
	}
}
