
public class WebUser {
	private String loginId;
	private String password;
	private UserState state;
	
	private Customer customer;
	private ShoppingCart shoppingcart;
	
	public WebUser(String login_id, String password, Customer customer) {
		this.loginId = login_id;
		this.password = password;
		this.state = UserState.New;

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
	
	public void setShoppingCart(ShoppingCart cart) {
		this.shoppingcart = cart;
	}
	
}
