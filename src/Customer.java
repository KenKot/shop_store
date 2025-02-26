
public class Customer {
	private static int count = 0; // used for unique ID's
	
	private String id;
	private Address address;
	private Phone phone;
	private String email;
	
	private WebUser webuser;
	private Account account;
	
	public Customer(Address address, Phone phone, String email) {
		this.id = String.valueOf(++count);
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	// GETTERS
	public String getId() {
		return this.id;
	}

	public Address getAddress() {
		return this.address;
	}
	public Phone getPhone() {
		return this.phone;
	}
	public String getEmail() {
		return this.email;
	}
	
	// SETTERS
	public void setAddress(Address newAddress) {
		this.address = newAddress;
	}

	public void setPhone(Phone newPhone) {
		this.phone = newPhone;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	
	// ASSOCIATIONS
	public void addNewWebuser(String login, String pass) {
		this.webuser = new WebUser(login, pass, this);
	}
	
	
}
