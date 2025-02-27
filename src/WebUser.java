public class WebUser {
	private String loginId;
	private String password;
	private UserState state;
	
	private Customer customer;
	private ShoppingCart shoppingcart;
	
	public WebUser(String loginId, String password, Customer customer) {
		this.loginId = loginId;
		this.password = password;
		this.state = UserState.NEW;
		this.customer = customer;
	}
	
	// GETTERS
	public String getLoginId() {
		return this.loginId;
	}
	
	public UserState getUserState() {
		return this.state;
	}
	
	// SETTERS
	public void setLoginId(String newId) {
		this.loginId = newId;
	}
	
	public void setPassword(String newPass) {
		this.password = newPass;
	}
	
	public void setUserState(UserState newState) {
		this.state = newState;
	}
	
	
	// ASSOCIATIONS
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShoppingCart getShoppingCart() {
		return this.shoppingcart;
	}
	public void setShoppingCart(ShoppingCart cart) {
		this.shoppingcart = cart;
	}
	
}
