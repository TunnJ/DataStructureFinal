/**
 * This is the customer class
 * @author Jacob Tunning
 * @version 1
 */

public class Customer {
	//Data members
	private String name;
	private int age;
	private String emailAddress;
	private boolean hasRenewed;
	
	/**
	 * Default constructor
	 */
	public Customer() {};
	
	/**
	 * Non-default constructor
	 * @param name
	 * @param age
	 * @param emailAddress
	 * @param hasRenewed
	 */
	public Customer(String name, int age, String emailAddress, boolean hasRenewed) {
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
		this.hasRenewed = hasRenewed;
	}

	/**
	 * This method returns a name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method changes the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method returns an age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * This method changes an age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This method returns an email address
]	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * This method changes an email address
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * This method returns whether a person is renewing their lease or not
	 * @return
	 */
	public boolean isHasRenewed() {
		return hasRenewed;
	}
	
	/**
	 * This method changes whether a person is renewing their lease or not
	 * @param hasRenewed
	 */
	public void setHasRenewed(boolean hasRenewed) {
		this.hasRenewed = hasRenewed;
	}
	
	/**
	 * This method prints out the customers information
	 * @return customerInfo
	 */
	@Override
	public String toString() {
		String customerInfo = " Name: " + name + "\n Age: " + age + "\n Email: " + emailAddress + "\n Has Renewed: " + hasRenewed;
		return customerInfo;
	}
}
