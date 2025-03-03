import java.util.HashSet;

public class Customer {
	private static int count = 0; // used for unique ID's

	private String id;
	private Address address;
	private Phone phone;
	private String email;

	private WebUser webuser;
	private Account account;

	public Customer(String street, String city, String state, String zip, Phone phone, String email) {
		this.id = String.valueOf(++count);
		this.address = new Address(street, city, state, zip);
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

	public HashSet<Order> getOrders() {
		if (account != null) {
			return account.getOrders();
		}
		return new HashSet<>();
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
	public void setWebuser(WebUser webuser) {
		this.webuser = webuser;
	}

	public Account getAccount() {
		return this.account;
	}
//	public void setAccount(Account newAccount) {
//		this.account = newAccount;
//	}

	public void createAccount(String street, String city, String state, String zip) {
		Address address = new Address(street, city, state, zip);
		this.account = new Account(address);
	}

	// Overloaded to use customer address as shipping address if no args given
	public void createAccount() {
		this.account = new Account(this.address);
	}

}
