
public class Customer {
	private static int count = 0;
	
	private String id;
	private Address address;
	private Phone phone;
	private String email;
	
	private Customer customer;
	
	public Customer() {
		this.id = String.valueOf(++count);
		this.customer = new Customer();
	}
	
	public int getId() {
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
}
