
public class Customer {
	private String name;
	private int age;
	private String emailAddress;
	private boolean hasRenewed;
	
	public Customer() {};
	
	public Customer(String name, int age, String emailAddress, boolean hasRenewed) {
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
		this.hasRenewed = hasRenewed;
	}

	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isHasRenewed() {
		return hasRenewed;
	}

	public void setHasRenewed(boolean hasRenewed) {
		this.hasRenewed = hasRenewed;
	}
	
	
}
