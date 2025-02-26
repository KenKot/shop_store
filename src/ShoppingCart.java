import java.time.LocalDateTime;

public class ShoppingCart {
	private LocalDateTime createdAt;
	
	private WebUser webuser;
	private Account account;
	
	public ShoppingCart(WebUser webuser) {
		this.createdAt = LocalDateTime.now();
	}
	
	// GETTERS
	
	// SETTERS
	
	// ASSOCIATIONS
	public void setWebUser(WebUser webuser) {
		this.webuser = webuser;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

}
