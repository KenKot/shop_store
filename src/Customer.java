
public class Customer {
	private static int count = 0; // used for unique ID's
	
	private String id;
	private Address address;
	private Phone phone;
	private String email;
	
	private WebUser webuser;
	private Account account;
	
//	public Customer(Address address, Phone phone, String email) {
	public Customer(String street, String city, String state, String zip , Phone phone, String email) {
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
	public void createAccount(String street, String city, String state, String zip ) {
		// "Account" as the parameter is nice
		// to easily mirror the common setup
		// of same shipping/billing address
		Address address = new Address(street, city, state, zip);
		this.account = new Account(address);
	}
	
	
	
	
}
